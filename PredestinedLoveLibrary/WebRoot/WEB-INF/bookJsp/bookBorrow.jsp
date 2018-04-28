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
				margin-left: 15px;
			}
			h1{
				font-family: "楷体";
			}
			span{
				font-family: "楷体";
				font-size: 18px;
			}
		</style>
	</head>
	<body>
	<div class="row">
	<span><h1>借书</h1></span>
	<hr />
	</div>
	<div class="row">
		<form class="col-md-6" method="post" action="<%=basePath%>/borrow/insertBorrow">
			<div class="form-group">
				<span>读者序号</span>
				<input class="form-control" type="text" name="rdID" />
			</div>
			<div class="form-group">
				<span>图书序号</span>
				<input class="form-control" type="text" name="bkID" />
			</div>
			<div class="form-group">
				<span>借书日期</span>
				<input class="form-control" type="date" name="DateOut" />
			</div>
			<div class="form-group">
				<span>借书操作员</span>
				<input class="form-control" type="text" name="operatorLend" />
			</div>
			<div class="form-group">
				<input class="btn  btn-danger" type="submit" style="width:200px"value="提交" />
				<input class="btn  btn-default" type="submit" style="float:right;width: 200px;"value="重置" />
			</div>
		</form>
	</div>
	</body>
</html>
