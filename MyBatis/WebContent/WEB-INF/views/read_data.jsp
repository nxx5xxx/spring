<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${testList }" var="t" varStatus="cnt">
		순번 : ${cnt.count}<br>
		data1 : ${t.data1 }<br>
		data2 : ${t.data2 }<br>
		data3 : ${t.data3 }<br>
	<hr>
	</c:forEach>
</body>
</html>