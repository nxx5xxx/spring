<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="root" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>미니 프로젝트</title>
<!-- Bootstrap CDN -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style>
.er {color:red;font-weight:bold}
</style>
</head>
<script>
function checkUserIdExist(){	
	var user_id = $("#user_id").val();
	
	if(user_id.length == 0){
		//길이가 0이면 입력을 안한경우
		alert('아이디를 입력해주세요');
		//return
	}else{
		$.ajax ({
			url : "${root}user/checkUserIdExist/" + user_id,
			type : "get",
			dataType : "text",
			success : function(result){
				if(result.trim()=="true"){
					alert("사용할 수 있는 아이디 입니다");
					$("#userIdExist").val("true");
				}else{
					alert("이미 존재하는 아이디 입니다");
					$("#userIdExist").val("false");
				}
			}
			
		});
		
		
	}
}
// 아이디를 입력하는 input 창에서 키를 눌렀을때 호출되는 함수
// id가 userIdExist 인 element(tag) 의 value 를 false 로 설정한다
// 여기서 element는 < > 이 전체를 태그는 input 이런걸 말하는데 input태그는 <input ~>전체
// Spring 의 form custom tag는 웹어플리케이션이 실행되면 알아서 원래 form태그로 변형됨
function resetUserIdExist(){
	$("#userIdExist").val("false");
	
}
</script>

<body>

<c:import url="/WEB-INF/views/include/top_menu.jsp" />


<div class="container" style="margin-top:100px">
	<div class="row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<div class="card shadow">
				<div class="card-body">
					<form:form action="${root }user/join_procedure" method="post" modelAttribute="joinUserBean">
					<form:hidden path="userIdExist" />
						<div class="form-group">
							<form:label path="user_name">이름</form:label>
							<form:input path="user_name" class="form-control"/>
							<form:errors path="user_name" class="er"/>
						</div>
						<div class="form-group">
							<form:label path="user_id">아이디</form:label>
							<div class="input-group">
								<form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>
								<div class="input-group-append">
									<form:button type="button" class="btn btn-primary" onclick="checkUserIdExist()">중복확인</form:button>
								</div>
							</div>
							<form:errors path="user_id" class="er"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw">비밀번호</form:label>
							<form:password path="user_pw" class="form-control"/>
							<form:errors path="user_pw" class="er"/>
						</div>
						<div class="form-group">
							<form:label path="user_pw2">비밀번호 확인</form:label>
							<form:password path="user_pw2" class="form-control"/>
						</div>
						<div class="form-group">
							<div class="text-right">
								<form:button class="btn btn-primary">회원가입</form:button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<div class="col-sm-3"></div>
	</div>
</div>

<c:import url="/WEB-INF/views/include/bottom_menu.jsp" />

</body>
</html>







