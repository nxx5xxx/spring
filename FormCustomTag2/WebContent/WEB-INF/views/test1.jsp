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
	<h2>test1.jsp</h2><!-- 여기서도 접두접미 생략가능 -->
	<form:form modelAttribute="beanData" action="result" method="post">
	<form:button>전송1 </form:button>
	<form:button disabled="true" >disable="true" </form:button>
	<form:hidden path="data1" />	
	</form:form>
</body>
</html>