<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery引入 -->
<script type="text/javascript" src="js/jquery-3.0.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 测试restful风格 -->
	<%-- <jsp:forward page="testthankyou/hello"></jsp:forward> --%>
	<!-- 测试@modelandAttribute注解 -->
	<%-- <jsp:forward page="modelAttribute?uname=oliver&upass=123&bdate=2017-12-23"></jsp:forward> --%>
	<!-- 测试自定义propertyeditorConverter -->
	<%-- <jsp:forward page="propertyConverter?person=emma:male:2017-12-23"></jsp:forward> --%>
	<!-- 测试自定义转换器 String2PersonConverter -->
	<%-- <jsp:forward
		page="string2PersonConverter?person=enna/female/2017-12-11"></jsp:forward> --%>
	<span style="color: red">${param.result} <img alt="点击" src="" />
	</span>
	<form action="multipartResolver" method="post"
		enctype="multipart/form-data">
		<input type="file" name="mFile" /> <input type="submit" value="上传">
	</form>
	<script type="text/javascript">
		$(function() {
			$("img").prop("src", "/image/${param.path}");
		});
	</script>

</body>
</html>