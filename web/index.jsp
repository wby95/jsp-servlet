<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <body>
  <jsp:useBean id="user" class="com.wby.bean.User"></jsp:useBean>
  <jsp:setProperty name="user" property="*"></jsp:setProperty>
 <center>
  <table>
   <form action="/doLogin">
     用户名：<input type="text" name="username" ><br/>
     密码：<input type="password" name="password" ><br/>
   <input type="submit" values="登陆" > <input type="reset" value="重置">
   </form>
  </table>
 </center>
  </body>
</html>
