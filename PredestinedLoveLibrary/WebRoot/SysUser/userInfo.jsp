<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<div class='row col-md-1'>
			<span>用户图像:</span><br />
			<img class="img-rounded" width="100px" height="100px"  src="<%=basePath %>/${SysReader.rdPhoto}"/>
		</div>
		<div class="row col-md-4">
			<span>用户名：</span>${SysReader.rdID}
			<br />
			<span>姓名：</span>${SysReader.rdName}
			<br />
			<span>性别：</span>${SysReader.rdSex}
			<br />
			<span>类别：</span>${SysReader.rdType} (0:代表老师，1：代表学生)
			<br />
			<span>角色：</span>${SysReader.rdAdminRoles}
			<br />
			
		</div>
	</body>
</html>