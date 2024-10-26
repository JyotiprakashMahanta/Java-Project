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
<input type="text" placeholder="enter your 1st number" name="a"> <br>
<input type="text" placeholder="enter your 2st number" name="b"> <br>
<button>Addition</button>
</form>
<%
try{
int a=Integer.parseInt(request.getParameter("a"));
int b=Integer.parseInt(request.getParameter("b"));
int result=a+b;
PrintWriter pw=response.getWriter();
pw.println("The Addition is = "+result);
}catch(Exception e){
	
}


//int b=Integer.parseInt(request.getParameter("b"));

//int add=num1+num2;
//out.print(add);
//session.setAttribute("num",add);
//<form action="squre.jsp">
//<button>squre</button>
//</form>
%>
</body>
</html>