<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>result2.jsp</h1>
	<h2>결국 requestScope에서 data갖고옴</h2>
	<h2>applicationBean3.data5 : ${applicationBean3.data5 }</h2>
	<h2>applicationBean3.data6 : ${applicationBean3.data6 }</h2>
	<h2>applicationBean4.data7 : ${applicationBean4.data7 }</h2>
	<h2>applicationBean4.data8 : ${applicationBean4.data8 }</h2>
	
	<hr>
	<h2>applicationScope.applicationBean3.data5 : ${applicationScope.applicationBean3.data5 }</h2>
	<h2>applicationScope.applicationBean3.data6 : ${applicationScope.applicationBean3.data6 }</h2>
	<h2>applicationScope.applicationBean4.data7 : ${applicationScope.applicationBean4.data7 }</h2>
	<h2>applicationScope.applicationBean4.data8 : ${applicationScope.applicationBean4.data8 }</h2>
	<hr>
	<h2>sessionScope.applicationBean3.data5 : ${sessionScope.applicationBean3.data5 }</h2>
	<h2>sessionScope.applicationBean3.data6 : ${sessionScope.applicationBean3.data6 }</h2>
	<h2>sessionScope.applicationBean4.data7 : ${sessionScope.applicationBean4.data7 }</h2>
	<h2>sessionScope.applicationBean4.data8 : ${sessionScope.applicationBean4.data8 }</h2>
	<hr>
	<h2>requestScope.applicationBean3.data5 : ${requestScope.applicationBean3.data5 }</h2>
	<h2>requestScope.applicationBean3.data6 : ${requestScope.applicationBean3.data6 }</h2>
	<h2>requestScope.applicationBean4.data7 : ${requestScope.applicationBean4.data7 }</h2>
	<h2>requestScope.applicationBean4.data8 : ${requestScope.applicationBean4.data8 }</h2>
</body>
</html>