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
		a{
			margin-right: 20px;
			color:#FFFFFF;
		}
		.pull-right
		{
			margin-top: 30px;
		}
		body{
			background-color:#122B40;
		}
	</style>

	<body>
		<div class="pull-left">
			<a href="<%=basePath %>/frame/mainFrame.jsp" target="mainFrame" ><img src="<%=basePath %>/img/title.png" style="margin-top: -20px;"/></a>
		</div>
		<div class="pull-right ">
			<img class="img-circle" width="30px" height="30px" src="<%=basePath %>/${SysReader.rdPhoto}" style="margin-right: 10px;"/>
			<a href="<%=basePath %>/SysUser/userPWDEdit.jsp" target="mainFrame"><span class="glyphicon glyphicon-cog"></span> Settings</a>	
			<a href="<%=basePath %>/SysUser/userInfo.jsp" target="mainFrame"><span class="glyphicon glyphicon-user"></span>${admin } </a>
			<a target="mainFrame" href="javascript:void(0)" onclick="if(confirm('你确定退出系统?')){top.location.href='<%=basePath %>/Userlogin/logout'; window.location.reload();}"><span class="glyphicon glyphicon-log-out"></span> Logout</a>

		</div>
	</body>

</html>