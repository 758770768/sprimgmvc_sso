<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://cdn.sockjs.org/sockjs-0.3.js"></script>
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
</head>
<body>
	<button>connect</button>
	<textarea rows="20" cols="10"></textarea>
	<input type="text" />
	<script type="text/javascript">
		$(function() {
			var ws = null;
			var url = null;
			$("button:contains('connect')")
					.on(
							"click",
							function() {
								if ('WebSocket' in window) {
									/* alert("yes:" + window.WebSocket);
									console.log(window);
									console.log(this); */
									ws = new WebSocket(
											"ws://localhost:8080/${pageContext.request.contextPath}/websocket");
								} else {
									alert("no");
								}
								ws.onopen = function(evnt) {
									alert("send....");
									ws.send("send some message!");
								};
								ws.onmessage = function(evnt) {
									alert("服务器消息:" + evnt.data);
									$("input")
											.val($("input").val() + evnt.data);
								};
								ws.onclose = function() {
									alert("websocket closed!");
								};

								ws.onerror = function(evnt) {
									alert("error:" + evnt);
								};
							});

		});
	</script>
</body>
</html>