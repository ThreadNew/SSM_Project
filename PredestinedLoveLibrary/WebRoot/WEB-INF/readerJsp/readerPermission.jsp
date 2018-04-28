<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<!-- Bootstrap -->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<style type="text/css">
		.row{
			margin-left: 12px;
			
		}
		span{
			font-family: "楷体";
			font-size: 20px;
		}
	</style>
	<body>
		<div class="row">
			<form class="form-inline" method="post" action="<%=basePath%>/Userlogin/insertPermission">
			<div class='form-group'>
				<span>用户名</span>
				<input type="text" class="form-control" name="userName" placeholder="用户名">
			</div>
				<div class='form-group'>
				<span>角色</span>
				<select class="form-control" name="roleName"> 
					<option value="SysManager">系统管理员</option>
					<option value="BookManager">图书管理员</option>
					<option value="Manager">前台管理员</option>
					<option value="User"> 普通用户</option>
				</select>
			</div>
			<div class="form-group">
				<input type="submit"  class="btn-danger btn" value="提交">
			</div>
				
			</form>
	</div>
	
	</body>
</html>