<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>result2.jsp : xml 설정</h2>
  <h3 style="color:blue;">ByType 방식</h3>
  <h3 style="color:blue;">request scope 에서 객체 가져옴</h3>
  <h3>requestScope.sessionBean3.data5 : ${ requestScope.sessionBean3.data5}</h3>
  <h3>requestScope.sessionBean3.data6 : ${ requestScope.sessionBean3.data6}</h3>
  
  <h3 style="color:red;">ByName 방식</h3>  
  <h3 style="color:red;">session scope 에서 객체 가져옴</h3>
  <h3>sessionScope.sessionBean4.data7 : ${ sessionScope.sessionBean4.data7}</h3>
  <h3>sessionScope.sessionBean4.data8 : ${ sessionScope.sessionBean4.data8}</h3>
</body>
</html>