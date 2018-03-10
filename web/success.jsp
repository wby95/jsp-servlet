<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <jsp:useBean id="user" class="com.wby.bean.User" scope="request"></jsp:useBean>
  <body>
    <%--欢迎您,  <%=request.getParameter("username") %> ,会员注册成功<br>--%>
    欢迎您, <jsp:getProperty name="user" property="username"></jsp:getProperty> ,会员注册成功

  <%=user.toString()
  %>
  <%
  %>
  </body>
</html>
