<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<h2>test4.jsp </h2>
	<h3>session 영역에서 data를 갖고옴</h3>
	<h3>bean1.data1 : ${bean1.data1 }</h3>
	<h3>sessionScope.bean1.data1 : ${sessionScope.bean1.data1 }</h3>
	<h3>sessionScope.bean1.data1 : ${sessionScope.bean1.data2 }</h3>
	<h3>requestScope.bean1.data1 : ${requestScope.bean1.data1 }</h3>
</body>
</html>