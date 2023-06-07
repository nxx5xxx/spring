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
		<a href="test1?num1=111&num2=222&number=333&number=444">같은이름의 데이터를 넘겼을때 map에서의 반응 test1</a><br>
		<a href="test2?num1=111&num2=222&number=333&number=444">같은 이름을 리스트로 받기 test2</a><br>
		<a href="test3_1?num1=111&num2=222&number=333&number=444">형변환     test3 - 제네릭형변환은 불가</a><br>
		<a href="test3_2?num1=111&num2=222&number=333&number=444">형변환2 test3</a><br>
		<hr>
		<h2>@ModelAttribute과 beans 사용</h2>
		<h4>빈즈클래스의 멤버변수 이름과 넘기는 데이터의 변수명이 같아야 한다</h4>
		<a href="test4?num1=111&num2=222&number=333&number=444">Model Attribute test4</a><br>
		<a href="test4_2?num1=111&num2=222&number=333&number=444">같은데이터를 여러개의 클래스에서 사용 test4_2</a><br>
		<a href="test5?num1=111&num2=222&number=333&number=444">ModelAttribute를 생략한 test5</a><br>
		<hr>
		
</body>
</html>