<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>test1.jsp</h2>
	<form action="result" method="post">
	이 름 : <input type="text" name="userName" value="${userInfoBean.userName }"/><br>
	<!-- 또는 requestScope.userInfoBean.getUserName() -->
	아이디 : <input type="text" name="userId" value="${userInfoBean.userId }"/><br>
	비밀번호 : <input type="password" name="userPw" value="${userInfoBean.userPw }"/><br>
	우편번호 : <input type="text" name="userPostCode" value="${userInfoBean.userPostCode }"/><br>
	주소1 : <input type="text" name="userAddress1" value="${userInfoBean.userAddress1 }"/><br>
	주소2 : <input type="text" name="userAddress2" value="${userInfoBean.userAddress2 }"/><br>
	<input type="submit" value="전송"/>
	
	</form>
</body>
</html>