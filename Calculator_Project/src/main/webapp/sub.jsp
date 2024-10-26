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
<button>substraction</button>
<%
try{
	int num1=Integer.parseInt(request.getParameter("a"));
	  int num2=Integer.parseInt(request.getParameter("b"));
	  int res=num1-num2;
	  PrintWriter p=response.getWriter();
	  p.println("the substraction of two number is: "+res);
}catch(Exception e){}
%>
</form>
</body>
</html>