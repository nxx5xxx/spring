<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 index.jsp 입니다</h1>
	<img src="image/spring_logo.jpg"><br>
	<a href="test1?number1=111&number2=222">EL param.number 로 바로전달받기 test1</a><br>
	<a href="test2">HttpServletRequest setAttribute test2</a><br>
	<a href="test3">Model addAttribute test3</a><br>
	<a href="test4">ModelAndView - test4</a><br>
</body>
</html>