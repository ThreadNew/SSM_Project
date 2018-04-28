<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
			font-size: 20px;
			font-style: italic;
	}
	</style>
	<script type="text/javascript">
		function getVal()
		{
			var obj = document.getElementById("status");
			var index = obj.selectedIndex; // 选中索引
			var text = obj.options[index].text; // 选中文本
			var value = obj.options[index].value; // 选中值
			location.href="<%=basePath%>/book/findBookInfo?start=0&bkStatus="+value;
			window.reload();
		}
		function setVal()
		{
			var str="${parameter.bkStatus}";
			var obj=document.getElementById("status");
			for(var i=0;i<obj.options.length;i++)
			{
				var value=obj.options[i].value;
				if(str==value)
				{
					obj.options[i].selected=true;
				}
			}
		}
		
	</script>
	<body onload="setVal()">
	<div class="row">
		<span><h1>图书信息展示：</h1></span>
		<hr />
	</div>
	<div class="row">
	<form class="form-inline" action="searchBook?start=0" method="post">
		<div class="form-group">
			<span>书名</span>
			<input type="text" class="form-control" name="bkName" placeholder="书名" />
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-danger" value="搜索" />
			
		</div>
	</form>
	<hr />
	</div>
	<div class="row col-sm-1">
		<select class="form-control" name="bkStatus" id="status" onchange="getVal()">
						<option value="" >全部</option>
		 				<option value="在馆">在馆</option>
		 				<option value="借出">借出</option>
		 				<option value="遗失">遗失</option>
		 				<option value="变卖">变卖</option>
		 				<option value="销毁">销毁</option>
		</select>
		<br />
		<a href="<%=basePath%>/book/exportBook?start=${parameter.start}&bkStatus=${parameter.bkStatus}&bkName=${parameter.bkName}"><span class="glyphicon glyphicon-save"><span>导出Excel表</span></span></a>
	</div>
	<div class="row col-sm-11" >
		<table class="table table-striped table-hover ">
				<fieldset>BOOK_INFO</fieldset>
				<thead class="bg-danger">
					<td>图书序号</td>
					<td>图书编号</td>
					<td>书名</td>
					<td>作者</td>
					<td>出版社</td>
					<td>出版日期</td>
					<td>ISBN书号</td>
					<td>分类号</td>
					<td>语言</td>
					<td>页数</td>
					<td>价格</td>
					<td>入馆日期</td>
					<td>图书封面</td>
					<td>图书简介</td>
					<td>图书状态</td>
					<td>操作</td>
				</thead>
				<tbody>
					<c:forEach items="${BookList }" var="book">
						<tr>
						<td>${book.bkID }</td>
						<td>${book.bkCode }</td>
						<td>${book.bkName }</td>
						<td>${book.bkAuthor }</td>
						<td>${book.bkPress }</td>
						<td><fmt:formatDate value="${book.bkDatePress }" pattern="yyyy-MM-dd"/></td>
						<td>${book.bkISBN }</td>
						<td>${book.bkCatalog }</td>
						<td>${book.bkLanguage }</td>
						<td>${book.bkPages }</td>
						<td>${book.bkPrice }</td>
						<td><fmt:formatDate value="${book.bkDateIn }" pattern="yyyy-MM-dd"/></td>
						<td><a href="<%=basePath%>/${book.bkCover }">查看</a></td>
						<td>${book.bkBrief }</td>
						<td>${book.bkStatus }</td>
						<td>
							<a href="<%=basePath%>/book/editBook?bkID=${book.bkID}&start=-1&end=-1"><span class="glyphicon glyphicon-edit"></span></a>
							<a href="javascript:void(0)" onclick="if(confirm('你确定删除?')){location.href='<%=basePath %>/book/deleteBook?start=${parameter.start }&bkID=${book.bkID }'; window.reload();}"><span class="glyphicon glyphicon-remove"></span></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>

			</table>
		
		<nav aria-label="...">
				<ul class="pager">
					<li>
						<a href="<%=basePath%>/book/findBookInfo?start=${start-10}&bkStatus=${parameter.bkStatus}">Previous</a>
					</li>
					<li>
						<a href="<%=basePath%>/book/findBookInfo?start=${start+10}&bkStatus=${parameter.bkStatus}">Next</a>
					</li>
				</ul>
			</nav>
	</div>
	<div class="row col-md-12">
		<hr />
	</div>
</body>
		
</html>
