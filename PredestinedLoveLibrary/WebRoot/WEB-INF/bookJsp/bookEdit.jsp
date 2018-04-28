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
	<style type="text/css">.row {
	margin-left: 15px;
}

span {
	font-family: "楷体";
	font-size: 18px;
}

h1 {
	font-family: "楷体";
}</style>
<script type="text/javascript">
	function showPreview(source) {
      var file = source.files[0];
      if(window.FileReader) {
          var fr = new FileReader();
          console.log(fr);
          var portrait = document.getElementById('portrait');
          fr.onloadend = function(e) {
            portrait.src = e.target.result;
          };
          fr.readAsDataURL(file);
          portrait.style.display = 'block';
      }
    }
</script>    
	<body>
		<div class="row">
			<h1>图书信息录入</h1>
			<hr />
		</div>
		 <div class="row col-md-3">
		 	<form action="<%=basePath %>/book/updateBook" method="post" enctype="multipart/form-data">
		 		<div class="form-group">
		 			<span>图书序号</span>
		 			<input class="form-control" type="text" name="bkID" placeholder="图书序号" value="${book.bkID }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>图书编号</span>
		 			<input class="form-control" type="text" name="bkCode" placeholder="图书编号" value="${book.bkCode }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>书名</span>
		 			<input class="form-control" type="text" name="bkName" placeholder="书名" value="${book.bkName }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>作者</span>
		 			<input class="form-control" type="text" name="bkAuthor" placeholder="作者" value="${book.bkAuthor }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>出版社</span>
		 			<input class="form-control" type="text" name="bkPress" placeholder="出版社" value="${book.bkPress }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>出版日期</span>
		 			<input class="form-control" type="date" name="DatePress" placeholder="年-月-日" />
		 		</div>
		 		<div class="form-group">
		 			<span>ISBN书号</span>
		 			<input class="form-control" type="text" name="bkISBN" placeholder="ISBN书号"value="${book.bkISBN }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>分类号</span>
		 			<select class='form-control' name="bkCatalog">
		 			<c:forEach items="${classList}" var="bookClass">
		 				<option value="${bookClass.bkCatalog }">${bookClass.bkCatalog }</option>
		 			</c:forEach>
		 			</select>
		 		</div>
		 	
		 </div>
		 <div class=" row col-md-3 ">
		 	<div class="form-group">
		 			<span>语言</span>
		 			<select class='form-control' name="bkLanguage">
		 				<option value="中文">中文</option>
		 				<option value="英文">英文</option>
		 				<option value="日文">日文</option>
		 				<option value="俄文">俄文</option>
		 				<option value="徳文">徳文</option>
		 				<option value="法文">法文</option>
		 			</select>
		 		</div>
		 		<div class="form-group">
		 			<span>页数</span>
		 			<input class="form-control" type="text" name="bkPages" placeholder="页数" value="${book.bkPages }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>价格</span>
		 			<input class="form-control" type="text" name="bkPrice" placeholder="价格" value="${book.bkPrice }"/>
		 		</div>
		 		<div class="form-group">
		 			<span>入馆日期</span>
		 			<input class="form-control" type="date" name="DateIn"/>
		 		</div>
		 		<div class="form-group">
		 			<span>内容简介</span>
		 			<textarea class="form-control" name="bkBrief" placeholder="内容字数不要超100" >${book.bkBrief }</textarea>
		 		</div>
		 		<div class="form-group">
		 			<span>图书封面照片</span>
		 			<input class="form-control" type="file" onchange="showPreview(this)" name="file"/>
		 		</div>
		 		<div class="form-group">
		 			<span>图书状态</span>
		 			<select class="form-control" name="bkStatus">
		 				<option value="在馆">在馆</option>
		 				<option value="借出">借出</option>
		 				<option value="遗失">遗失</option>
		 				<option value="变卖">变卖</option>
		 				<option value="销毁">销毁</option>
		 			</select>
		 		</div>
		 		
		 			<input type="submit" class="btn btn-danger col-md-3" value="提交"/>
		 			<input type="reset" class="btn btn-default col-md-3" style="float: right;" value="重置" />
		 		
		 </div>
		 </form>
		  <div class="row col-md-4">
		 	<span> 图书封面预览</span>
		 	   <img id="portrait"  class="img-rounded " src="" style="display:none; width:300px ; height: 200px;"  />
		 </div>
	</body>
</html>
