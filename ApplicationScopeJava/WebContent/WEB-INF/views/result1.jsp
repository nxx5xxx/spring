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
	<h2>결국 requestScope에서 data갖고옴</h2>
	<h2>applicationBean1.data1 : ${applicationBean1.data1 }</h2>
	<h2>applicationBean1.data2 : ${applicationBean1.data2 }</h2>
	<h2>applicationBean2.data3 : ${applicationBean2.data3 }</h2>
	<h2>applicationBean2.data4 : ${applicationBean2.data4 }</h2>
	
	<hr>
	<h2>applicationScope.applicationBean1.data1 : ${applicationScope.applicationBean1.data1 }</h2>
	<h2>sessionScope.applicationBean1.data1 : ${sessionScope.applicationBean1.data1 }</h2>
	<h2>requestScope.applicationBean1.data1 : ${requestScope.applicationBean1.data1 }</h2>
</body>
</html>