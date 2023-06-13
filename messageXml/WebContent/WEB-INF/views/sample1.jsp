<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>sample1.jsp</h2>
	<h3>student1.name1 : <spring:message code="student1.name1"/></h3>
	<h3>student2.name2 : <spring:message code="student2.name2"/></h3>
	
	<!-- MessgeSource 설정에서 bean id가 messageSource로 되어있는지 확인해야 한다.
	JSP 에서 spring:message 태그를 사용하려면 설정처럼 bean id 가 messageSource로 되어있어야 사용가능하다. -->
</body>
</html>