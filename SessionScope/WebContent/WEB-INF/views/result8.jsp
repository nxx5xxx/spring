<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
	<h2>result8.jsp </h2>
	<h3>session 영역에서 sessionBean2를 갖고옴</h3>
	<h3>sessionBean2.data3 : ${sessionBean2.data3 }</h3>
	<h3>sessionScope.sessionBean2.data3 : ${sessionScope.sessionBean2.data3 }</h3>
	<h3>sessionScope.sessionBean2.data4 : ${sessionScope.sessionBean2.data4 }</h3>
	<h3>requestScope.sessionBean2.data3 : ${requestScope.sessionBean2.data3 }</h3>
	<h3>requestScope.sessionBean2.data4 : ${requestScope.sessionBean2.data4 }</h3>
</body>
</html>