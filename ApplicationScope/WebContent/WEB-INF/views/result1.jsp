<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result1.jsp</h1>
	<h2>ApplicationScope에서 data갖고옴</h2>
	<h2>name : ${name }</h2>
	<h2>applicationScope.name : ${applicationScope.name }</h2>
	<h2>sessionScope.name : ${sessionScope.name }</h2>
	<h2>requestScope.name : ${requestScope.name }</h2>
</body>
</html>