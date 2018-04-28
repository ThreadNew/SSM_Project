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
	<!--[if IE]>
		
	<![endif]-->
	<style type="text/css">
		.row
		{
			margin-left: 20px;
		}
		span
		{
			font-family: "楷体";
			font-size: 20px;
		}
		h1
		{
			font-family: "楷体";
		}
		</style>
	<body>
		<div class="row">
		<h1> 图书编目</h1>
		</div>
		<hr>
		<div class="row">
			<form class="form-inline" method="post" action="<%=basePath %>/bookClass/insertBookClass">
				<div class="form-group">
					<span >分类号</span>
					<input class="form-control" type="text" placeholder="分类号" name="bkCatalog" />
				</div>
				<div class="form-group">
					<span>分类名</span>
					<input type="text" class="form-control" placeholder="分类名" name="bkClassName"/>
				</div>
				
				<input type="submit" class="btn btn-danger" value="提交"/>
			</form>
		</div>
		<hr />
		<div class="row">
			<span> 提交信息展览</span>
		</div>
		<div class="row col-md-6" >
			<table class="table table-striped table-hover ">
				<thead>
					<td><span>分类号</span></td>
					<td><span>分类名</span></td>
				</thead>
				<tbody>
					<td><span>${bkCatalog }</span></td>
					<td><span>${bkClassName }</span></td>
				</tbody>
			</table>
		</div>
	</body>

</html>