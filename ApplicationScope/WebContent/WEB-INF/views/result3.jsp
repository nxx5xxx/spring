<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result3.jsp</h1>
	<h2>ApplicationScope에서 data갖고옴</h2>
	<h2>bean1.data1 : ${bean1.data1 }</h2>
	<h2>applicationScope.bean1.data1 : ${applicationScope.bean1.data1 }</h2>
	<h2>applicationScope.bean1.data2 : ${applicationScope.bean1.data2 }</h2>
	<h2>sessionScope.name : ${sessionScope.bean1.data1 }</h2>
	<h2>requestScope.name : ${requestScope.bean1.data1 }</h2>
</body>
</html>