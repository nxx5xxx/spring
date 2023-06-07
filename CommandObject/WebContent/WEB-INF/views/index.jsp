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
	<hr>
	<form action="test1" method="post">
		number1 : <input type="text" name="number1" /><br>
		number2 : <input type="text" name="number2" /><br>
		<input type="submit" value="전송"/>
	</form>
	<hr>
	<form action="test2" method="post">
		number3 : <input type="text" name="number3" /><br>
		number4 : <input type="text" name="number4" /><br>
		<input type="submit" value="전송"/>
	</form>
	
	<hr>
	<form action="test3" method="post">
		number5 : <input type="text" name="number5" /><br>
		number6 : <input type="text" name="number6" /><br>
		<input type="submit" value="전송"/>
	</form>
	
</body>
</html>