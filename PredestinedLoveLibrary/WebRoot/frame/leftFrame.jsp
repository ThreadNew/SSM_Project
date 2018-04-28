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
			
		
		<style type="text/css">
			body
			{
				background-color:#122B40;
			}
			* {
				margin: 0;
				padding: 0
			}
			
			a {
				text-decoration: none
			}
			
			#conter {
				width: 1000px;
				margin-left: 0px;
			}
			
			#help-left {
				width: 200px;
				font-family: 'microsoft YaHei';
				float: left
			}
			
			.menu {
				border-left: 1px solid #ccc;
				border-right: 1px solid #ccc
			}
			
			.menu:last-child {
				border-bottom: 1px solid #ccc
			}
			
			.menu summary {
				height: 40px;
				line-height: 40px;
				text-indent: 10px;
				outline: 0;
				font-size: 14px;
				font-weight: 700;
				border-top: 1px solid #ddd;
				background: -webkit-gradient(linear, left top, left bottom, color-stop(0, #FEFEFE), color-stop(1, #CCC));
				cursor: pointer
			}
			
			.menu summary::-webkit-details-marker {
				display: none
			}
			
			.menu summary:before {
				content: "+";
				display: inline-block;
				width: 16px;
				height: 16px;
				margin-right: 10px;
				font-size: 18px;
				font-weight: 700
			}
			
			.menu[open] summary:before {
				content: "-"
			}
			
			.menu ul {
				padding: 10px 0
			}
			
			.menu ul li {
				list-style: none;
				text-indent: 25px;
				font-size: 12px;
				height: 30px;
				line-height: 30px;
				border-bottom: 1px solid #F00
			}
			
			.menu ul li a {
				display: block;
				color: #FFF;
				background-color: #122B40
			}
			
			.menu ul li a:hover {
				text-decoration: underline
			}
		</style>
	</head>

	<body>
		<!--代码部分begin -->
		<section id="conter">
			<section id="help-left">
				<details class="menu" open>
					<summary>图书编目管理</summary>
					<ul>
						<li>
							<a href="<%=basePath%>/bookClass/toBookClass" target="mainFrame">图书编目</a>
						</li>
						<li>
							<a href="<%=basePath%>/bookClass/selectBookClass?start=0" target="mainFrame">编目维护</a>
						</li>
					</ul>
				</details>
				<details class="menu" open>
					<summary>图书信息管理</summary>
					<ul>
						<li>
							<a href="<%=basePath%>/book/toBook" target="mainFrame">图书录入</a>
						</li>
						<li>
							<a href="<%=basePath%>/book/findBookInfo?start=0" target="mainFrame">图书信息</a>
						</li>
					</ul>
				</details>
				<details class="menu" open>
					<summary>图书借阅管理</summary>
					<ul>
						<li>
							<a href="<%=basePath%>/borrow/toBorrow" target="mainFrame">借阅图书</a>
						</li>
						<li>
							<a href="<%=basePath%>/borrow/selectBorrowInfo?start=0" target="mainFrame">借阅信息</a>
						</li>
						<li>
							<a href="<%=basePath%>/borrow/comeBorrowEdit" target="mainFrame">归还-续借</a>
						</li>
					</ul>
				</details>
				<details class="menu" open>
					<summary>读者管理</summary>
					<ul>
						<li>
							<a href="<%=basePath%>/reader/toReader" target="mainFrame">办证</a>
						</li>
						<li>
							<a href="<%=basePath%>/reader/findReader?start=0" target="mainFrame">读者信息</a>
						</li>
						<li>
							<a href="<%=basePath%>/readerType/searchReaderType?start=0&rdType=-1" target="mainFrame">读者类别</a>
						</li>
						<li>
							<a href="<%=basePath%>/reader/toReaderStatus" target="mainFrame">证件操作</a>
						</li>
					
					</ul>
				</details>
				<details class="menu" open>
					<summary>系统管理</summary>
					<ul>
						<li>
							<a href="<%=basePath %>/Userlogin/selectPermission?start=0" target="mainFrame">权限信息</a>
						</li>
						<li>
							<a href="<%=basePath %>/Userlogin/toReaderPermission" target="mainFrame">用户权限</a>
						</li>
					</ul>
				</details>
			</section>
			<section id="help-right"></section>
		</section>
		<!--代码部分end -->
	</body>

</html>