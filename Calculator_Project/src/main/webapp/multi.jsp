<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="">
<input type="text" placeholder="enter 1st number" name="a"> <br>
<input type="text" placeholder="enter 2nd number" name="b"> <br>
<button>multification</button>
</form>
<%
try{
	int a=Integer.parseInt(request.getParameter("a"));
	int b=Integer.parseInt(request.getParameter("b"));
	int c=a*b;
	PrintWriter pw=response.getWriter();
	pw.println("the multification is :"+c);
}catch(Exception e){}
%>
</body>
</html>