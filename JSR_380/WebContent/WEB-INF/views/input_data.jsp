<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.er {color:red;font-size:50%;font-weight:bold}
</style>
</head>
<body>
	<h2>input_data.jsp</h2>
	<form:form action="input_procedure" modelAttribute="testBean1" method="post">
	data1 - NotEmpty	<form:input path="data1" type="text" /><br>
						<form:errors class="er" path="data1" /><br>
	data2 - NotBlank	<form:input path="data2" type="text" /><br>
						<form:errors class="er" path="data2" /><br>
	data3 - Positive	<form:input path="data3" type="text" /><br>
						<form:errors class="er" path="data3" /><br>
	data4 - PositiveOrZero	<form:input path="data4" type="text" /><br>
						<form:errors class="er" path="data4" /><br>
	data5 - Negative 	<form:input path="data5" type="text" /><br>
						<form:errors class="er" path="data5" /><br>
	data6 - NegativeOrZero 	<form:input path="data6" type="text" /><br>
						<form:errors class="er" path="data6" /><br>
	data7 - Email 	<form:input path="data7" type="text" /><br>
						<form:errors class="er" path="data7" /><br>
		<form:button type="submit">전송</form:button>
	</form:form>
</body>
</html>