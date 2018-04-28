<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		.form-group
		{
			margin-left: 20px;
		}
		h3{
			font-family:"楷体";
			font-size: 25px;
		}
		.table{
			margin-left: 20px;
		}
	</style>
	<body>
			<div class="row">
			<div class="form-group">
			<h3>信息展示</h3>
			</div>
		<table class="table table-striped table-hover " >
			<thead>
				<td>用户名</td>
				<td>角色</td>
				
				<td>操作</td>
				
			</thead>
			<tbody>
				<c:forEach items="${permission }" var="p">
				<tr>
				<td>${p.userName}</td>
				<td>${p.roleName}</td>
			
				<td>
					<a href="<%=basePath %>/Userlogin/deletePermission?id=${p.id }&start=${parameter.start}"><span class="glyphicon glyphicon-remove"></span></a>
				</td>
				</tr>
				</c:forEach>
				
				
			</tbody>
		</table>
		</div>
		<div class="row">
			<nav aria-label="...">
				<ul class="pager">
					<li>
						<a href="<%=basePath %>/Userlogin/selectPermission?start=${parameter.start-10}">Previous</a>
					</li>
					<li>
						<a href="<%=basePath %>/Userlogin/selectPermission?start=${parameter.start+10}">Next</a>
					</li>
				</ul>
			</nav>
		</div>
	</body>
</html>
