<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	Form Custom Tag에서 input 태그의  path속성은
	일반 input 태그의 id속성과 name속성 두가지 역할을 한다  
-->
	<h2>test4.jsp</h2>
	<form:form modelAttribute="bb" action="result" >
		이름 : <form:input path="userName" /><br>
		아이디 : <form:input path="userId" /><br>
		비밀번호 : <form:password path="userPw" showPassword="true"/><br>
		우편번호 : <form:input path="userPostCode" /><br>
		주소1 : <form:input path="userAddress1" /><br>
		주소2 : <form:input path="userAddress2" /><br>
	</form:form>
</body>
</html>