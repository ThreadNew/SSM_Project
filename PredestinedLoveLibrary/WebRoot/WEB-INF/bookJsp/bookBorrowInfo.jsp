<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<style type="text/css">.row {
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
	var value = obj.options[index].value; // 选中值
	location.href="<%=basePath%>/borrow/selectBorrowInfo?start=0&isHasReturn="+value;
	window.reload();
	
}
	function setVal()
	{
		var ob="${parameter.isHasReturn}";
		
		var obj = document.getElementById("status");
		for(var i=0;i<obj.options.length;i++)
		{
			var value= obj.options[i].value;
			if(ob == value)
			{
				obj.options[i].selected=true;
			}
		}
	}
</script>
	<body onload="setVal()">
	<div class="row">
		<span><h1>借阅信息展示：</h1></span>
		<hr />
	</div>
	
	<div class="row col-sm-1">
		<select class="form-control" name="bkStatus" id="status" onchange="getVal()">
						<option  >全部</option>
		 				<option value="已还">已还</option>
		 				<option value="未还">未还</option>
		 				
		</select>
		<br />
		<a href=""><span class="glyphicon glyphicon-save"><span>导出Excel表</span></span></a>
	</div>
	<div class="row col-sm-11" >
		<table class="table table-striped table-hover ">
				<fieldset>BORROW_INFO</fieldset>
				<thead class="bg-danger">
					<td>序号</td>
					<td>读者序号</td>
					<td>图书序号</td>
					<td>续借次数</td>
					<td>借书日期</td>
					<td>应还日期</td>
					<td>实际还书日期</td>
					<td>超期天数</td>
					<td>超期金额</td>
					<td>罚款金额</td>
					<td>还书情况</td>
					<td>借书操作员</td>
					<td>还书操作员</td>
					<td>操作</td>
				</thead>
				<tbody>
					<c:forEach items="${BorrowList}" var="borrow">
					<tr>
					<td>${borrow.borrowID }</td>
					<td>${borrow.rdID }</td>
					<td>${borrow.bkID }</td>
					<td>${borrow.idContinueTimes }</td>
					<td><fmt:formatDate value="${borrow.idDateOut }" pattern="yyyy-MM-dd"/> </td>
					<td><fmt:formatDate value="${borrow.idDateRetPlan }" pattern="yyyy-MM-dd"/> </td>
					<td><fmt:formatDate value="${borrow.idDateRetAct }" pattern="yyyy-MM-dd"/> </td>
					<td>${borrow.idOverDay }</td>
					<td>${borrow.idOverMoney}</td>
					<td>${borrow.idPunishMoney }</td>
					<td>${borrow.isHasReturn}</td>
					<td>${borrow.operatorLend }</td>
					<td>${borrow.operatorRet }</td>
						<td>
							<a href="javascript:void(0)" onclick="if(confirm('你确定删除?')){location.href='<%=basePath%>/borrow/deleteBorrow?id=${borrow.borrowID }&rdID=${borrow.rdID }&bkID=${borrow.bkID }&isHasReturn=${borrow.isHasReturn }'; window.reload();}"><span class="glyphicon glyphicon-remove"></span></a>
						</td>
					</tr>
					</c:forEach>
				</tbody>

			</table>
		
		<nav aria-label="...">
				<ul class="pager">
					<li>
						<a href="<%=basePath%>/borrow/selectBorrowInfo?isHasReturn=${parameter.isHasReturn}&start=${parameter.start-10}">Previous</a>
					</li>
					<li>
						<a href="<%=basePath%>/borrow/selectBorrowInfo?isHasReturn=${parameter.isHasReturn}&start=${parameter.start+10}">Next</a>
					</li>
				</ul>
			</nav>
	</div>
	<div class="row col-md-12">
		<hr />
	</div>
</body>
		
</html>
