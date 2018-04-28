<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
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
		<div class="row ">
			<div class="form-group">
			<h3>信息注册</h3>
			</div>
			<form class="form-inline" method="post" action="readerType/insertReaderType">
				<div class="form-group">
					<label>类别：</label>
					<input type="text" class="form-control"  placeholder="读者类别如0，1。。。" name="rdType"/>
				</div>
				<div class="form-group">
					<label>名称：</label>
					<input type="text" class="form-control" placeholder="读者类型名称" name="rdTypeName"/>
				</div>
				<div class="form-group">
					<label>可借书的数量：</label>
					<input type="text" class="form-control" placeholder="借书的数量" name="canLendQty"/>
				</div>
				<div class="form-group">
					<label>可借书的天数：</label>
					<input type="text" class="form-control" placeholder="借书的天数" name="canLendDay"/>
				</div>
				<div class="form-group">
					<label>可续借的次数：</label>
					<input type="text" class="form-control" placeholder="续借的次数" name="canContinueTimes"/>
				</div>
				<div class="form-group">
					<label>罚款率：</label>
					<input type="text" class="form-control"placeholder="罚款率" name="punishRate"/>
				</div>
				<div class="form-group">
					<label>证书有效期：</label>
					<input type="text" class="form-control" placeholder="有效期" name="dateValid"/>
				</div>
				<div class="form-group right">
				<input type="submit" class="btn btn-danger " value="submit" />
				</div>
			</form>
		</div>
			<div class="row">
			<hr />
		</div>
		<div class="row">
			<div class="form-group">
			<h3>信息展示</h3>
			</div>
		<table class="table table-striped table-hover ">
			<thead>
				<td>类型</td>
				<td>名称</td>
				<td>可借书的数量</td>
				<td>可借书的天数</td>
				<td>可续借的次数</td>
				<td>罚款率</td>
				<td>证件有效期</td>
				<td>操作</td>
				
			</thead>
			<tbody>
				<c:forEach items="${TypeList}" var="readerType">
					<tr>
						<td>${readerType.rdType }</td>
						<td>${readerType.rdTypeName }</td>
						<td>${readerType.canLendQty }本</td>
						<td>${readerType.canLendDay }天</td>
						<td>${readerType.canContinueTimes }次</td>
						<td>${readerType.punishRate }</td>
						<td>${readerType.dateValid }天</td>
						<td>
							<a href="<%=basePath%>/readerType/editReaderType?rdType=${readerType.rdType }&start=${start}"><span class="glyphicon glyphicon-edit"></span></a>
							<a href="javascript:void(0)" onclick="if(confirm('你确定删除?')){location.href='<%=basePath %>/readerType/deleteReaderType?start=${start }&rdType=${readerType.rdType}'; window.reload();}"><span class="glyphicon glyphicon-remove"></span></a>
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
						<a href="<%=basePath%>/readerType/searchReaderType?start=${start-10}&rdType=${rdType}">Previous</a>
					</li>
					<li>
						<a href="<%=basePath%>/readerType/searchReaderType?start=${start+10}&rdType=${rdType}">Next</a>
					</li>
				</ul>
			</nav>
		</div>
			<a href="<%=basePath%>/readerType/exportExcel?start=${start}&rdType=${rdType}"><span class="glyphicon glyphicon-save">导出Excel表</span></a>
		<div class="row">
			<hr />
		</div>
		<div class="row ">
			<div class="form-group">
			<h3>信息修改</h3>
			</div>
			<form class="form-inline" method="post" action="readerType/updateReaderType?start=${start }">
				<div class="form-group">
					<label>类别：</label>
					<input type="text" class="form-control"  placeholder="读者类别如0，1。。。" name="rdType" readonly="readonly" value="${readerType.rdType }"/>
				</div>
				<div class="form-group">
					<label>名称：</label>
					<input type="text" class="form-control" placeholder="读者类型名称" name="rdTypeName" value="${readerType.rdTypeName  }"/>
				</div>
				<div class="form-group">
					<label>可借书的数量：</label>
					<input type="text" class="form-control" placeholder="借书的数量" name="canLendQty" value="${readerType.canLendQty }"/>
				</div>
				<div class="form-group">
					<label>可借书的天数：</label>
					<input type="text" class="form-control" placeholder="借书的天数" name="canLendDay" value="${readerType.canLendDay }"/>
				</div>
				<div class="form-group">
					<label>可续借的次数：</label>
					<input type="text" class="form-control" placeholder="续借的次数" name="canContinueTimes" value="${readerType.canContinueTimes }"/>
				</div>
				<div class="form-group">
					<label>罚款率：</label>
					<input type="text" class="form-control"placeholder="罚款率" name="punishRate" value="${readerType.punishRate }"/>
				</div>
				<div class="form-group">
					<label>证书有效期：</label>
					<input type="text" class="form-control" placeholder="有效期" name="dateValid" value="${readerType.dateValid }"/>
				</div>
				<div class="form-group right">
				<input type="submit" class="btn btn-danger " value="submit" />
				</div>
			</form>
		</div>
	</body>
</html>
