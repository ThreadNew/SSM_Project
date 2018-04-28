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
		.form-group
		{
			margin-left: 20px;
		}
	</style>
	<script type="text/javascript">
		function setValue()
		{
			var username=document.getElementById("name").value;
			location.href="<%=basePath%>/reader/findStatusByrdID?rdID="+username;
			window.reload();
			
			
			
		}
	</script>
	<body>
		<div class="row">
			<form class="form-inline" method="post" action="<%=basePath %>/reader/updateStatus">
				<div class="form-group">
					<span class="glyphicon glyphicon-user">用户名</span>
					<input class="form-control" type="text" name="rdID" placeholder="用户名" id="name" name="rdID" value="${rdID }"  onfocusout="setValue()"/>
				</div>
				<div class="form-group">
					<span>证件当前状态</span>
					<input type="text" class="form-control" disabled value="${status }"  id="status"/>
				</div>
				<div class="form-group" >
					<span>证件状态:</span>
					<select class="form-control" name="rdStatus" >
						<option value="有效">有效</option>
						<option value="挂失">挂失</option>
						<option value="注销">注销</option>
					</select>

				</div>
				<input type="submit" class="btn btn-danger" value="提交"/>
			</form>
		</div>

	</body>

</html>