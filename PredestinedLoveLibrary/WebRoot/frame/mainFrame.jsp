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
		<style type="text/css">
		.row{
			margin-top: 40px;
		}
		</style>
	</head>
	<body>
		<div class="container">
		<h1><span class="glyphicon glyphicon-home"></span></h1>
		<div class="row">
		<div class="col-md-6">
			<a href="<%=basePath%>/reader/toReader"><img src="<%=basePath %>/img/zheng.png" width="80%"  height="300px" class="img-thumbnail" /></a>
		</div>
		<div class="col-md-6">
			<a href="<%=basePath%>/book/toBook"><img src="<%=basePath %>/img/yuan.png" width="80%"  height="300px" class="img-thumbnail" /></a>
		</div>
		</div>
		<div class="row">
		<div class="col-md-6">
			<a href="<%=basePath %>/Userlogin/selectPermission?start=0"><img src="<%=basePath %>/img/tu.png" width="80%"  height="300px" class="img-thumbnail"/></a>
		</div>
		<div class="col-md-6">
			<a href="<%=basePath%>/borrow/selectBorrowInfo?start=0" ><img src="<%=basePath %>/img/shu.png" width="80%"  height="300px" class="img-thumbnail"/></a>
		</div>
		</div>
	
		</div>
	</body>
</html>
