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
   <% request.setCharacterEncoding("utf-8"); //解决中文乱码%>
  <%--同 import语句--%>
  <jsp:useBean id="user" class="com.wby.bean.User" scope="request"/>
  <jsp:setProperty name="user" property="*"></jsp:setProperty>
  <body>
 <center>
     <jsp:include page="top.jsp"></jsp:include><br>
  <table>
   <form action="checkLogin.jsp">
     用户名：<input type="text" name="username" value="<jsp:getProperty name="user" property="username" />"><%= user.getErrorMsg("errname")%><br/>
   密码：<input type="password" name="password" value="<jsp:getProperty name="user" property="password" />"><%= user.getErrorMsg("errpassword")%><br/>
   年龄：<input type="text" name="age" value="<jsp:getProperty name="user" property="age" />"><%= user.getErrorMsg("errage")%><br/>
   电邮： <input type="email" name="email" value="<jsp:getProperty name="user" property="email" />"><%= user.getErrorMsg("erremail")%><br/><br>
   <input type="submit" values="登陆" > <input type="reset" value="重置">
   </form>
  </table>
 </center>
  </body>
</html>
