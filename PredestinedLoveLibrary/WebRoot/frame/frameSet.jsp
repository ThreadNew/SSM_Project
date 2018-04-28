<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>图书管理系统</title>
	</head>

	<frameset rows="80,*" cols="*" frameborder="no" border="0" framespacing="0">
		<frame src="<%=basePath %>/frame/topFrame.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
		<frameset cols="185,*" frameborder="no" border="0" framespacing="0">
			<frame src="<%=basePath %>/frame/leftFrame.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" />
			<frame src="<%=basePath %>/frame/mainFrame.jsp" name="mainFrame" id="mainFrame" />
		</frameset>
	</frameset>
	<noframes>
	<body>
	</body
	></noframes>

</html>
