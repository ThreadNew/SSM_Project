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
			.row {
				margin-left: 15px;
					}

			span {
				font-family: "楷体";
				font-size: 18px;
				}

			h1 {
				font-family: "楷体";
				}
			fieldset
				{
					font-family: "楷体";
					font-size: 25px;
					font-style: italic;
				}
				.ra{
					margin-left: 30%;
				}
		</style>
	</head>
	<body>
		<div class="row">
			<h1>归还-续借</h1>
		<hr />
		</div>
		<div class="row">
		<form class="col-md-5" method="post" action="<%=basePath%>/borrow/borrowOperator">
				<div class="form-group">
					<span>读者ID</span>
					<input class="form-control" type="text" name="rdID" />
				</div>
				<div class="form-group">
					<span>图书ID</span>
					<input class="form-control" type="text" name="BkID" />
				</div>
				<div class="form-group">
					<span>操作员</span>
					<input class="form-control" type="text" name="operator" />
				</div>
				 <div class="form-group ra" >
				 	<input type="radio" class="radio-inline " name="tool"value="1"/><span>归还</span>
				 	<input type="radio" class="radio-inline" name="tool"value="2"/><span>续借</span>
				 </div>
				<div class="form-group">
				<input class="btn btn-danger col-md-2"  type="submit" value="提交" style="margin-left: 20px;"/>
				<input class="btn btn-default col-md-2"  type="reset" value="重置" style="float: right;"/>
				</div>
			</form>
			<hr />
		</div>
	
	</body>
</html>
