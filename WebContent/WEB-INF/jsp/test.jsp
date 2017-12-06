<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.0.0.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</head>
<body>
	<script type="text/javascript">
		$(function() {
			
			$("button:contains('login')").on("click",function(e){
				e.preventDefault();
				//alert($("#login").serialize());
              $.ajax({
            	 url:"jsonDemo",
            	 data:$("#login").serialize(),
            	 dateType:"json",
            	 success:function(data){
            		 //alert(data.uname+data.bdate.);
            		var time= new Date(data.bdate);
            		 alert(time.toLocaleString());
            	 }
              });
			});
		});
	</script>

	<div class="container">
		<form class="form-horizontal" id="login">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">uname</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						placeholder="Email" name="uname">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">upass</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword3"
						placeholder="Password" name="upass">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">bdate</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="inputPassword3"
						placeholder="Password" name="bdate">
				</div>
			</div>
			 
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">login</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>