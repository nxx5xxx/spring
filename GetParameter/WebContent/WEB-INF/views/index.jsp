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
	<a href="test1?number1=100&number2=200&numbers=300&numbers=400">test1 get</a><br>
	<hr>
	<form action="test2" method="post">
	<label for="number1">number1 : </label><input type="text" name="number1" id="number1"><br><br>
	<label for="number2">number2 : </label><input type="text" name="number2" id="number2"><br><br>
	numbers : <input type="checkbox" name="numbers" value="100"> 100
	<input type="checkbox" name="numbers" value="200"> 200<br><br>
	<input type="submit" value="전송">
	</form>
	<hr>
	<a href="test3?number1=100&number2=200&numbers=300&numbers=400">test3 get</a><br>
	<hr>
	<a href="test4/100/200/300">test4 get</a><br>
	<hr>
	<a href="test5/100/200/300/400">test5 get</a><br>
	<hr>
	<a href="test6?num1=100&num2=200&nums=300&nums=400">test6</a>
	<hr>
	<a href="test7?num1=100&num2=200&nums=300&nums=400">test7</a>
	<hr>
	<a href="test8?num1=100&num2=200&nums=300&nums=400">test8</a>
	<hr>
	<a href="test9?num1=100&num2=200&nums=300&nums=400">test9 - 없는 parameter를 요청하는경우</a>
	<hr>
	<a href="test10?num1=100&num2=200&nums=300&nums=400">test10 - required false</a>
	<hr>
	<a href="test11?num1=100&num2=200&nums=300&nums=400">test11 - defaultValue</a>
	<hr>
	<a href="test12?aa=aaa&bb=bbb">test12 - request forwardtest</a>
</body>
</html>