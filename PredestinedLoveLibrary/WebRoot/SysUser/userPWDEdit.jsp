<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userPWDEdit.jsp' starting page</title>
 		<!-- Bootstrap -->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			function compare()
			{
				var password1=document.getElementById("password1");
				var password2=document.getElementById("password2");
				if(!password1.equals(password2))
				{
					alert("密码错误");
					window.reload();
				}
			}
		</script>
	</head>
	<body>
		<form class="col-md-3" onclick="compare()" action="Userlogin/pwdEdit" method="post"> 
			<div class="form-group">
			<span class='glyphicon glyphicon-user'>UserName</span>
			<input type="text" class="form-control"  placeholder="用户名" name="username" value="${admin }" readonly/>
			</div>
			<div class="form-group">
			<span class='glyphicon glyphicon-lock'>PassWord</span>
			<input type="password" class="form-control" placeholder="请输入密码" id="password1" name="password"/>
			</div>
			<div class="form-group">
			<span class='glyphicon glyphicon-lock'>PassWord</span>
			<input type="password" class="form-control" placeholder="确认密码" id="password2"/>
			</div>
			<div class="form-group">
		
			<input type="submit" class="btn-danger btn" value="Submit"/>
			</div>
		</form>
	</body>
</html>
