<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
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
		.table {
			margin-left: 15px;
		}
		.form-group
		{
			margin-left: 30px;
		}
	</style>
	<body>
		<div class="row">
			<div class="col-md-5">

			</div>
			<div class="col-md-5">
				<img src="<%=basePath %>/img/fen.png" class='img-rounded' />

			</div>
		</div>
		<div class="row">
			<hr />
		</div>
		<div class='row'>
			<form class="form-inline" action="reader/searchReader" method="post">
				<div class="form-group">
					<span class="glyphicon glyphicon-user"></span>
					<input type="text" class="form-control" placeholder="用户名" name="rdID"/>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-danger" value="搜索" />
				</div>
			</form>
		</div>
		<div class="row">
			<hr />
		</div>
		<div class="row">
		<table class="table table-striped table-hover ">
			<thead>
				<td>用户名</td>
				<td>姓名</td>
				<td>密码</td>
				<td>性别</td>
				<td>类型</td>
				<td>办证日期</td>
				<td>电话</td>
				<td>邮箱</td>
				<td>角色</td>
				<td>证件状态</td>
				<td>已借书数量</td>
				<td>照片</td>
				<td>操作</td>
			</thead>
			<tbody>
				<c:forEach items="${readerList }" var="reader">
				<tr>
					<td>${reader.rdID }</td>
					<td>${reader.rdName }</td>
					<td>${reader.rdPwd }</td>
					<td>${reader.rdSex }</td>
					<c:if test="${reader.rdType==0}">
					<td><a href="">教师</a></td>
					</c:if>
					<c:if test="${reader.rdType==1}">
					<td><a href="">学生</a></td>
					</c:if>
					<td><fmt:formatDate value="${reader.rdDateReg }" pattern="yyyy-MM-dd"/></td>
					<td>${reader.rdPhone }</td>
					<td>${reader.rdEmail }</td>
					<td>${reader.rdAdminRoles }</td>
					<td>${reader.rdStatus }</td>
					<td>${reader.rdBorrowQty }</td>
					<td><a href="<%=basePath %>/${reader.rdPhoto }">查看</a></td>
					<td>
						<a href="<%=basePath%>/reader/editReader/${reader.rdID}?start=${start}"><span class="glyphicon glyphicon-edit"></span></a>
						<a href="<%=basePath%>/reader/deleteReader?rdID=${reader.rdID}&start=${start}"><span class="glyphicon glyphicon-remove"></span></a>
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
					<a href="<%=basePath%>/reader/findReader?start=${start-10}&rdID=${rdID}">Previous</a>
				</li>
				<li>
					<a href="<%=basePath%>/reader/findReader?start=${start+10}&rdID=${rdID}">Next</a>
				</li>
			</ul>
		</nav>
	</div>
		<a href="<%=basePath%>/reader/exportExcel?start=${start}&rdID=${rdID}"><span class="glyphicon glyphicon-save">导出Excel表</span></a>
	<div class="row">
			<hr />
		</div>
		<div class="row">
			<form class=" form-inline  col-md-10" action="reader/updateReader/${start }" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<span>用户名&nbsp;&nbsp;:</span>
					<input type="text" class="form-control"  name="rdID" placeholder="用户名"  value="${editReader.rdID }" readonly="readonly"/>
				</div>
				<div class="form-group">
					<span>姓名&nbsp;&nbsp;&nbsp;&nbsp;:</span>
					<input type="text" class="form-control" name="rdName" placeholder="姓名" value="${editReader.rdName }"/>
				</div>
				<div class="form-group">
					<span>性别&nbsp;&nbsp;&nbsp;&nbsp;:</span>
					<input type="text" class="form-control" name="rdSex" placeholder="性别" value="${editReader.rdSex }"/>
				</div>
				<div class="form-group">
					<span>密码&nbsp;&nbsp;&nbsp;&nbsp;:</span>
					<input type="text" class="form-control" name="rdPwd" placeholder="密码" value="${editReader.rdPwd }"/>
				</div>
				<div class="form-group">
					<span>读者类别:</span>
					<select class="form-control" name="rdType">
						<option value="0">教师</option>
						<option value="1">学生</option>
					</select>
				</div>
				<div class="form-group">
					<span>单位名称:</span>
					<input type="text" class="form-control" name="rdDept" placeholder="单位名称" value="${editReader.rdDept }"/>
				</div>
				<div class="form-group">
					<span>电话号码:</span>
					<input type="text" class="form-control" name="rdPhone" placeholder="电话号码" value="${editReader.rdPhone }" />
				</div>
				<div class="form-group">
					<span>电子邮箱:</span>
					<input type="text" class="form-control" name="rdEmail" placeholder="邮箱"  value="${editReader.rdEmail }"/>
				</div>
				<div class="form-group">
					<span>证件状态:</span>
					<select class="form-control" name="rdStatus" >
						<option value="有效">有效</option>
						<option value="挂失">挂失</option>
						<option value="注销">注销</option>
					</select>
				</div>
				<div class="form-group">
					<span>管理角色:</span>
					<select class="form-control" name="rdAdminRoles">
						<option value="SysManager">系统管理员</option>
						<option value="BookManager">图书管理员</option>
						<option value="Manager">前台管理员</option>
						<option value="User"> 普通用户</option>
					</select>
				</div>
				<div class="form-group">
					<span>用户照片:</span>
					<input type="file" class="form-control " name="filePhoto"/>
				</div>
				<div class="form-group">
					<input type="submit" class="form-control btn btn-danger" value="更新数据" />
				</div>
			</form>
		</div>
	</body>

</html>