<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<!--[if IE]>
		
	<![endif]-->
<style type="text/css">
.row {
	margin-left: 20px;
}

span {
	font-family: "楷体";
	font-size: 20px;
}

h1 {
	font-family: "楷体";
}
</style>

<body>
	<div class="row">
		<h1>信息浏览</h1>
	</div>
	<hr>
	<span>编辑信息：</span>
	<div class="row">
		<form class="form-inline" method="post" action="<%=basePath%>/bookClass/updateBookClass?start=${start }">
			<div class="form-group">
				<span>分类号</span> <input class="form-control" type="text"
					placeholder="分类号" name="bkCatalog" readonly  value="${BookClass.bkCatalog }"/>
			</div>
			<div class="form-group">
				<span>分类名</span> <input type="text" class="form-control"
					placeholder="分类名" name="bkClassName" value="${BookClass.bkClassName }" />
			</div>

			<input type="submit" class="btn btn-danger" value="提交" />
		</form>
	</div>
	<hr />
	<div class="row">
		<span> 提交信息展览</span>
	</div>
	<div class="row col-md-6">
		<table class="table table-striped table-hover ">
			<thead>
				<td><span>分类号</span></td>
				<td><span>分类名</span></td>
				<td><span>操作</span></td>
			</thead>
			<tbody>
				<c:forEach items="${bookClassList }" var="bookClass">
					<tr>
						<td><span>${bookClass.bkCatalog }</span></td>
						<td><span>${bookClass.bkClassName}</span></td>
						<td><a href="<%=basePath%>/bookClass/editBookClass?rdID=${bookClass.bkCatalog}&start=${start}"><span class="glyphicon glyphicon-edit"></span></a>
							<a href="javascript:void(0)" onclick="if(confirm('你确定删除?')){location.href='<%=basePath %>/bookClass/deleteBookClass?start=${start }&bkCatalog=${bookClass.bkCatalog }'; window.reload();}"><span class="glyphicon glyphicon-remove"></span></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="row">
			<nav aria-label="...">
				<ul class="pager">
					<li><a href="<%=basePath%>/bookClass/selectBookClass?start=${start-10}">Previous</a></li>
					<li><a href="<%=basePath%>/bookClass/selectBookClass?start=${start+10}">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>

</body>

</html>