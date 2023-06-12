<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<h2>result7.jsp </h2>
	<h3>session 영역에서 sessionBean1를 갖고옴</h3>
	<h3>sessionBean1.data1 : ${sessionBean1.data1 }</h3>
	<h3>sessionScope.sessionBean1.data1 : ${sessionScope.sessionBean1.data1 }</h3>
	<h3>sessionScope.sessionBean1.data1 : ${sessionScope.sessionBean1.data2 }</h3>
	<h3>requestScope.sessionBean1.data1 : ${requestScope.sessionBean1.data1 }</h3>
</body>
</html>