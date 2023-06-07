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
	beanData 객체의 멤버변수 data1에 설정된 값과
	같은 값은 value 로  하는 항목이 선택 된 상태로 태그가 생성된다
  -->
  123123
	<h2>test1.jsp</h2>
	<form:form modelAttribute="beanData" action="send">
	<form:select path="data1">
	<form:option value="좋은학원">좋은학원</form:option>
	<form:option value="보통학원">보통학원</form:option>
	<form:option value="더좋은학원">더좋은학원</form:option>
	</form:select>
	<form:button>전송</form:button>
	</form:form>
</body>
</html>