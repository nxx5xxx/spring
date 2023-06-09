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
	<h2>test1.jsp</h2>
	<form:form modelAttribute="beanData" action="result">
	<form:select path="data1">
	<form:option value="좋은학원">좋은학원</form:option>
	<form:option value="보통학원">보통학원</form:option>
	<form:option value="더좋은학원">더좋은학원</form:option>
	</form:select>
	<hr>
	<form:select path="data2">
		<form:options items="${dataArray1 }" /> <!-- requestScope.dataList1 리퀘스트 스코프를 붙여주는 이유를 딱히모르겠음 -->
	</form:select>
	<hr>
		<form:select path="data3">
		<form:options items="${dataList1 }" /> 
	</form:select>
	<hr>
		<form:select path="data4">
			<form:options items="${requestScope.dataList2 }" itemLabel="key" itemValue="value" />	
		 <!-- itemLabel은 멤버필드에있는 변수명중 키로 잡을것을 넣어주면된다 -->
		 <!-- itemValue는 멤버필드에있는 변수명중 값으로 잡을것을 넣어주면된다 -->
		</form:select>
	<hr>
	<h2>체크박스</h2>
		<form:checkbox path="data5" value="C언어과정" /> C언어과정
		<form:checkbox path="data5" value="JSP과정" /> JSP과정
		<form:checkbox path="data5" value="Spring과정" /> Spring과정
		<!-- TestController에서 배열값에 추가되어있는게 체크되어있다 - 나중에 update할때 편할듯 -->
		
	<hr>
		<form:checkboxes path="data6" items="${dataArray2 }" /> <!-- 배열로 받은것 -->
	<hr>
		<form:checkboxes path="data7" items="${dataList3 }" /> <!-- 어레이리스트로 받은것 -->
	<hr>
		<form:checkboxes path="data8" items="${dataList4 }" itemLabel="key" itemValue="value"/> <!-- 키와 밸류의 배열을 넣은 어레이리스트로 받은것 -->
		<!-- BeanKeyValue의 멤머필드와 itemLabel 에서 키로쓸 변수명과 itemValue에서 값으로 쓸 변수명을 일치시켜줘야함 -->
	<hr>
	<h2>라디오버튼</h2>
	<form:radiobutton path="data9" value="C언어과정" />C언어과정
	<form:radiobutton path="data9" value="JSP과정" />JSP과정
	<form:radiobutton path="data9" value="Spring과정" />Spring과정
	<form:radiobutton path="data9" value="자바웹개발과정" />자바웹개발과정
	<hr>
	<form:radiobuttons path="data10" items="${dataArray3 }" /><!-- 배열로한것 -->
	<hr>
	<form:radiobuttons path="data11" items="${dataList5 }" /><!-- 어레이리스트로 한것 -->
	<hr>
	<form:radiobuttons path="data12" items="${dataList6 }" itemLabel="key" itemValue="value"/><!-- 어레이리스트로 한것 -->
	<br>
	<form:button>전송</form:button>
	</form:form>
</body>
</html>