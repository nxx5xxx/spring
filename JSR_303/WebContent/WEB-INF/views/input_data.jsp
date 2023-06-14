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
	<h2>input_data.jsp</h2>
	<form:form action="input_procedure" modelAttribute="testBean1" method="post">
		data1 : <form:radiobutton path="data1" value="true"/>true<br>
				<form:radiobutton path="data1" value="false" /> false<br>
				<form:errors path="data1" /> <br>
				
		data2 : <form:radiobutton path="data2" value="true" />true<br>
				<form:radiobutton path="data2" value="false" />false<br>
				<form:errors path="data2" /> <br>
		data3 : <form:input path="data3" type="text"/><br>
				<form:errors path="data3" /><br>
		data4 : <form:input path="data4" type="text" /><br>
				<form:errors path="data4" /><br>
		DecimalMax,Min - data5 : <form:input path="data5" type="text" /><br>
				<form:errors path="data5" type="text" /><br>
		Null - data6 : <form:checkbox path="data6" value="check1" />체크박스1<br>
				<form:errors path="data6" type="text" /><br>
		NotNull - data7 : <form:checkbox path="data7" value="check2" />체크박스2<br>
				<form:errors path="data7" type="text" /><br>
		Digits - data8 : <form:input path="data8" type="text" /><br>
				<form:errors path="data8" type="text" /><br>
		Size - data9 : <form:input path="data9" type="text" /><br>
				<form:errors path="data9" type="text" /><br>
		Pattern - data10 : <form:input path="data10" type="text" /><br>
				<form:errors path="data10" type="text" /><br>
				
		<form:button type="submit">전송</form:button>
	</form:form>
</body>
</html>