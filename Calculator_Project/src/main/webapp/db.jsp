<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: right;
}
</style>
</head>
<body>
<form action="">
enter a number <input type="text" placeholder="number/2" name="num"> <br>
<button>div by 2</button>
</form>

<%
try{
	
	int num=Integer.parseInt(request.getParameter("num"));
	int result=num/2;
	PrintWriter pw=response.getWriter();
	pw.println("<html><body>the result is: "+result+"</body><html>");
}catch(Exception e){}
%>
</body>
</html>