<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>图书管理系统</title>
<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css" href="css/Login.css">
<script type="text/javascript">
	//图片看不清换张图片
	function reloadImage() {
		
		document.getElementById("identity").src = "<%=basePath%>/Userlogin/identity?ts=" + new Date().getTime();
	}
</script>
</head>

<body>
	<form action="Userlogin/login" method="post">

		<div class="col-md-5 bg1">
			<div class="form-group">
				<h3>LOGIN</h3>
			</div>
			<div class="form-group ">
				<label class='bg'>UserName</label> 
				<input type="text" class="form-control" id="exampleInputEmail1"  name="username" placeholder="请输入用户名">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1" class="bg">Password</label> 
				<input type="password" class="form-control" id="exampleInputPassword1" name="password"
					placeholder="请输入密码">
			</div>
			<div class="form-group form-inline">
				<img src="<%=basePath%>/Userlogin/identity" width="150px" height="35"
					onclick="reloadImage()"  id="identity"/> 
				<input type="text" placeholder="请输入验证码" class="form-control " name="identity" />

			</div>
			<button type="submit" class="btn btn-danger col-xs-4">Submit</button>
			<button type="reset" class="btn btn-group-lg col-xs-4"
				style="float: right;">Reset</button>
		</div>
	</form>

</body>

</html>