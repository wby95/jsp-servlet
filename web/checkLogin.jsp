<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkLogin.jsp' starting page</title>
    
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
  <jsp:useBean id="user" class="com.wby.bean.User" scope="request"/>
  <%--为属性自动赋值--%>
  <jsp:setProperty name="user" property="*"></jsp:setProperty>
  <%--<%--%>
<%--/*   String username=request.getParameter("username");--%>
   <%--String password=request.getParameter("password");--%>
   <%--String email=request.getParameter("email");--%>
   <%--String age=request.getParameter("age");--%>
  <%--*/--%>
   <%--//if(username!=""&&username!=null&&password!=""&&password!=null&&email!=""&&email!=null&48<=age.charAt(0)&&age.charAt(0)<=57&&48<=age.charAt(1)&&age.charAt(1)<=57)--%>
      <%----%>
   <%--{%>--%>
 <%----%>

  <%
    if(user.isValidate()){
  %>
       <jsp:forward page="success.jsp"></jsp:forward>
  <%
      }else {
  %>
       <jsp:forward page="index.jsp"></jsp:forward>
  <%}%>
     <br>
  </body>
</html>
