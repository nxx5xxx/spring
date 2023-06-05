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
	
	<h2> 한개의 jsp로 Get Post 나누기</h2>
	<a href="test1">test1 get</a><br>
	<form action="test1" method="post">
	<input type="submit" value="테스트1로 가기">
	</form>
	<br><br>
	
	<h2> Get방식으로 Post로 연결하기 test2</h2>
	<a href="test2">test2 get</a><br>
	<form action="test2" method="post">
	<input type="submit" value="테스트2로 가기">
	</form>
	<br><br>
	
	<h2> 두개의 jsp로 get과 post방식 나눠서 처리하기 </h2>
	<a href="test3">test3 get</a><br>
	<form action="test3" method="post">
	<input type="submit" value="테스트3로 가기">
	</form>
	<br><br>
	
	<a href="test4">test4 get</a><br>
	<form action="test4" method="post">
	<input type="submit" value="테스트4로 가기">
	</form>
	
	<a href="test5">test5 get</a><br>
	<form action="test5" method="post">
	<input type="submit" value="테스트5로 가기">
	</form>
	<br><br>
	<h2>한개의 Request맵핑을 그룹화(배열)하여 Post.Get두개 다 받기</h2>
	<a href="test6">test6 get</a><br>
	<form action="test6" method="post">
	<input type="submit" value="테스트6로 가기">
	</form>
</body>
</html>