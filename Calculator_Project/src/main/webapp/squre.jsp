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
	text-align: center;
}
</style>
</head>
<body>
<form action="">
 <label>enter a number to show squre</label> <br> <input type="text" placeholder="enter here" name="num">
<button>squre</button>
</form>
<%
try{
	
	int num=Integer.parseInt(request.getParameter("num"));
	int squre=num*num;
	PrintWriter pw=response.getWriter();
	pw.println("The squre is: "+squre);
}catch(Exception e){}
//int num=(int)session.getAttribute("num");
//int res=num*num;
//out.println(res);
%>
</body>
</html>