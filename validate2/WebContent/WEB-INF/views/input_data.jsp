<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Spring Form CustomTags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>input_data.jsp</h2>
	<form:form action="input_result" modelAttribute="testBean1" mehod="post">
		data1 : <form:input path="data1" type="text" /><br>
				<form:errors path="data1" /><br>
		data2 : <form:input path="data2" type="text" /><br>
				<form:errors path="data2" /><br>
		<form:button type="submit" >전송</form:button>
	</form:form>
	
	

</body>
</html>
<%-- 
			<form:errors path="data1" /><br>
			둘이 같은의미
			<c:if test="${errors.hasFieldErrors('data1') }">
				<spring:message code="${errors.getFieldError('data1').codes[0] }" /><br>
			</c:if> 
			--%>