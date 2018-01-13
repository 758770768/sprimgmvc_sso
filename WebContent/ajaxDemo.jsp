<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button>ajax</button>
	<button>ajax2</button>
	<button>ajaxlist</button>
	<script type="text/javascript">
		$(function() {
			$("button:contains('ajax')").click(function() {
				$.ajax({
					url : "ajaxBack",
					data : {
						"pname" : "123",
						"psex" : "male",
						"pDate" : "2017/12/23"
					},
					success : function(data) {
						alert(123);
					}
				});
			});
			$("button:contains('ajax2')").click(function() {
				$.ajax({
					url : "ajaxBack1",
					data : {
						"pname" : "123",
						"psex" : "male",
						"pDate" : "2017/12/23"
					},
					success : function(data) {
						alert(data[0]);
					}
				});
			});
			$("button:contains('ajaxlist')").click(function() {
				$.ajax({
					url : "ajaxList",
					data : JSON.stringify([ {
						"pname" : "123",
						"psex" : "male",
						"pDate" : "2017/12/23"
					}, {
						"pname" : "123",
						"psex" : "male",
						"pDate" : "2017/12/23"
					}, {
						"pname" : "123",
						"psex" : "male",
						"pDate" : "2017/12/23"
					} ]),
					type : "post", 
					contentType : "application/json",
					success : function(data) {
						alert(data[0]);
					}
				});
			});

		});
	</script>
</body>
</html>