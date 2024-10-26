<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
text-decoration: none
}
ul{
display: flex;
justify-content: space-between;
background: lightgreen;
padding:20px;
}
li{
list-style: none;
}
button{
border-radius: 12px;
}
h4{
	text-align: center;
	color: brown;
}
</style>
</head>
<body>
<h4>Click any button to perform action 👇</h4>
 <nav>
  <div>
	<ul>
		<li><a href="add.jsp"><button>+</button></a></li>
		<li><a href="sub.jsp"><button>-</button></a></li>
		<li><a href="multi.jsp"><button>*</button></a></li>
		<li><a href="div.jsp"><button>/</button></a></li>
		<li><a href="ama.jsp"><button>%</button></a></li>
		<li><a href="squre.jsp"><button>squre</button></a></li>
		<li> <a href="db.jsp"><button>div by 2</button></a> </li>
	</ul>
  </div>
 </nav>
</body>
</html>