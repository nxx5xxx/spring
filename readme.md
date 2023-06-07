# 스프링 

## 0607
### 수업내용
    getObjectParameter
    ViewResolver
    CommandObject
    FormCustomTag
    FormCustomTag2
    FormCustomTag3

---

# getObjectParameter
## 파라미터로 객체 주입받기

	Map 으로 주입 받음
		*Client가 전달하는 모든 parameter data를 한꺼번에
		 Map으로 전달받는다
		*같은 이름으로 2개 이상의 parameter를 전달하면
		   하나만 받게 된다 - 이 경우에는 List로 주입받아야한다(같은이름으로 2개이상의 파라메터를 받고싶을경우)
		   				@RequestParam List<String> number와 같이 parameter type을 List로
		   				- Parameter 이름에 주의해야함
		   
		*맵으로 받을땐 데이터의 변수명은 <String,~> 에 대입돼 맵명은 마음대로 기입가능하지만 
		   리스트로 받을땐 리스트명과 데이터의 변수명이 같아야한다
		 
    @ModelAttribute
        ㄴ객체를 parameter로 주입 받을 수 있음
            전달하는 객체의 이름(참조변수)과 parameter의 이름을 맞추어줘야함
            @ModelAttribute 어노테이션은 생략이 가능하다
            이러한 객체를 Command Object라고 칭한다
            
    스프링이 객체를 생성해서 관리하는 객체를 bean이라고함

# ViewResolver
    ViewResolver
        ㄴ Controller에서 전달받은 View의 이름을 기반으로 (return 에서 받은 문자열을 의미 {ex:return "result" 에서 result})
        jsp파일을 찾아 선택하고 jsp 데이터를 분석해 응결과를 만들어 전달한다
            -response를 받아 response를 받은 데이터를 브라우저가 해석하여 우리 눈에 보여주는것임
        
        ViewResolver 가 사용하는 View의 이름을 지정하는 방법
        jsp를 통해 응답결과를 만들 때 필요한 data를 전달하는 방법
        
        
    HttpServletRequest
        ㄴSpring MVC가 jsp를 처리할 때 (SpringMVC는 SpringFramework를 뜻함)
        HttpServletRequest 객체를(자동으로 생성하여) jsp로 전달한다
        ㄴViewResolver 는 이러한 과정을 이용하여 jsp 작업시 data 를 사용한다
        
        
        
        1) 웹브라우저 주소표시줄에 /test1이 표시되면 < 요청 정보라 함 (request
        2) DispatcherServlet 이  요청정보를 받아 분석해 Controller를 선택한다
        3) @GetMapping("/test1") 이 있는 메소드를 호출하고
        4) 이 메소드의 return값으로 지정된 이름의 jsp파일(View)을 선택한다
        5) 이 정보를 ViewResolver가 받아 해당 jsp 파일을 분석하여
        6) 해당 jsp 파일에 있는 java code나 , EL , JSTL등을 모두 실행시킨다
        7) 이 결과를 다시 DispatcherServlet으로 전달해
        8) 여기서 생성된 정보(html) 를 Client 로 보내면 (response
        9) Client의 web browser가 이를 rendering하여 화면으로 보여준다
        
    컨트롤러를 거치지않고 바로 받으려면 ${param.변수명 }

    HttpServletRequest 객체를 주입받는 방법
        ㄴ public String test2(HttpServletRequest request)
        request.setAttribute("변수",값)

    Model 객체를 주입받는 방법
        ㄴ public String test3(Model model)
            ㄴ Model 객체를 주입 받으면 HttpServletRequest 객체에 담아져서 jsp 에 전달 할 수 있다
            ㄴ model.addAttribute("변수", 값)
            
    ModelAndView 객체를 주입받는방법
        ㄴ public ModelAndView test4(ModelAndView mv){ return mv}
            ㄴ ModelAndView 는 Model에 값을 설정하고 View의 이름을 지정까지 할 수 있다
            test3 메소드는 View의 이름을 return 하지 않고 ModelAndView 객체를 return한다
            ㄴ mv.addObject("변수",값)
            mv.setViewName("View 이름")
            
    ViewResolver 에 의해서 jsp가 실행되고 응답결과가 만들어진다
    Controller 에서 View를 지정할 때
    ViewResolver가 사용할 data를 Request 영역에 저장한다

    Request 영역에 저장한 data를 jsp에서 꺼내 사용할 때
    ${requestScope.지정한변수명 } 이라는 EL을 사용한다


## ModelAndView 추가설명
    ModelAndView는 foward방식으로도 redirect 방식으로도 보낼수 있는데

    작성한 코드를 보면

    	@PostMapping("/send")
	public ModelAndView sendData(BeanData bean) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bean", bean);
		mv.setViewName("result");

		/* 
		 *  mv.setViewName("~~"); ->포워드방식
		 *  
		 *  mv.setViewName("redirect:/notice/List.do?num=1"); -> 리다이렉트방식
		 */
		
		return mv;
	}

    이렇게 된다 

    -- 받는 jsp 에서는
    데이터테스트1 : ${beanData.data1 }<br>
	데이터테스트3 : ${bean.data1 }<br>

    이렇게 받아 올 수 있다

# CommanObject
CommanObject : 커맨드 객체 - HttpServletRequest 객체에 자동으로 담긴다 (단 , 자동으로 저장되는 이름은 클래스의 이름이며 첫글자는 소문자로 저장된다)
	ㄴ Client 가 전달해 주는 parameter data를 주입받을 때 사용하는 객체
	
	
	ex)
	@PostMapping("/test1")
	public String test1(@ModelAttribute BeanDate bean){
		return "test1";
	
	}
	
	여기서 (@ModelAttribute BeanDate bean) 이것이 커맨드 객체이다
	(DTO라고 볼 수 있음)

## 커맨드객체 추가 예제(컨트롤러로 설명)
	//DataBean1 : 커맨드객체
	// 커맨드 객체는 HttpServletRequest 객체에 자동으로 담겨서(저장되어서)
	// 지정한 이름의 View(test1.jsp)로 전달된다 > EL로 화면에 출력함
	//이때, HttpServletRequest 객체에 자동으로 저장되는 이름은 클래스의 이름으로 된다
	//						(클래스의 )첫 글자가 소문자로 되어서 저장됨
	//						ex) ${requestScope.dataBean1.number1}
	// (@ModelAttribute DataBean1 bean1) <- 파라메터로 선언된 객체를
	// 									HttpServletRequest 객체에 담아서 jsp로 전달한다는 의미
	@PostMapping("/test1")
	public String test1(@ModelAttribute DataBean1 bean1) {
		System.out.printf("number1 : %s\n",bean1.getNumber1());
		System.out.printf("number2 : %s\n",bean1.getNumber2());
		return "test1";
	}
	
	//EL에서 받는 클래스이름을 다른걸로 하고싶을때
	
	//HttpServletRequest 객체에 자동으로 저장되는 이름을 클래스 이름으로 안하고 다른이름으로 할때는
	//(@ModelAttribute("bb") DataBean2 bean2) 이런식으로 작성하면
	// test2.jsp에서 dataBean2를 bb로 인식하게 된다
	@PostMapping("/test2")
	public String test2(@ModelAttribute("bb") DataBean2 bean2) {
		System.out.printf("number3 : %s\n",bean2.getNumber3());
		System.out.printf("number4 : %s\n",bean2.getNumber4());
		return "test2";
	}
	
	//ModelAttribute는 클래스이름의 변경이 없을 시 생략이 가능하다
	@PostMapping("/test3")
	public String test3(DataBean3 bean3) {
		System.out.printf("number5 : %s\n",bean3.getNumber5());
		System.out.printf("number6 : %s\n",bean3.getNumber6());
		return "test3";
	}

# FormCustomTag
    Form Custom Tag
	    Spring 에서 <form : 태그이름> 형태로 제공되는 태그
        Form Custom Tag 를 사용하면
        @ModelAttribute 어노테이션으로 bean을 주입 받아서 사용 할 수도 있고
        Model 객체에 저장된(담겨있는) 값을 form 요소에 주입 할 수 있음
        회원 정보 수정 같은 수정페에지를 작성할 때 주로 사용한다
## form태그를 사용하려면
    jsp문서 상단에
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    을 기입해야 사용가능하다

### 예제 - controller
    	//form커스텀태그 이용해서 받기
	@GetMapping("/test2")
	public String test2(UserInfoBean bean) {
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("bb") UserInfoBean bean) {
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");		
		return "test3";
	}
	
	//객체를 주입하지않고 모델을 쓰는방법 ( 모델을 직접 생성 ) 
	@GetMapping("/test4")
	public String test4(Model model) {
		UserInfoBean bean = new UserInfoBean(); //위에서는 이 과정을 스프링이 자동으로 해준것임
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");		
		model.addAttribute("bb", bean);
		return "test4";
	}

### jsp 
#### test1.jsp
    <form action="result" method="post">
	이 름 : <input type="text" name="userName" value="${userInfoBean.userName }"/><br>
	<!-- 또는 requestScope.userInfoBean.getUserName() -->
	아이디 : <input type="text" name="userId" value="${userInfoBean.userId }"/><br>
	비밀번호 : <input type="password" name="userPw" value="${userInfoBean.userPw }"/><br>
	우편번호 : <input type="text" name="userPostCode" value="${userInfoBean.userPostCode }"/><br>
	주소1 : <input type="text" name="userAddress1" value="${userInfoBean.userAddress1 }"/><br>
	주소2 : <input type="text" name="userAddress2" value="${userInfoBean.userAddress2 }"/><br>
	<input type="submit" value="전송"/>

#### test2.jsp
	Form Custom Tag에서 input 태그의  path속성은
	일반 input 태그의 id속성과 name속성 두가지 역할을 한다  
	<h2>test2.jsp</h2>
	<form:form modelAttribute="userInfoBean" action="result" >
		이름 : <form:input path="userName" /><br>
		아이디 : <form:input path="userId" /><br>
		비밀번호 : <form:password path="userPw" showPassword="true"/><br>
		우편번호 : <form:input path="userPostCode" /><br>
		주소1 : <form:input path="userAddress1" /><br>
		주소2 : <form:input path="userAddress2" /><br>
	</form:form>

#### test3.jsp
	<form:form modelAttribute="bb" action="result" >
		이름 : <form:input path="userName" /><br>
		아이디 : <form:input path="userId" /><br>
		비밀번호 : <form:password path="userPw" showPassword="true"/><br>
		우편번호 : <form:input path="userPostCode" /><br>
		주소1 : <form:input path="userAddress1" /><br>
		주소2 : <form:input path="userAddress2" /><br>
	</form:form>
#### test4.jsp
	<form:form modelAttribute="bb" action="result" >
		이름 : <form:input path="userName" /><br>
		아이디 : <form:input path="userId" /><br>
		비밀번호 : <form:password path="userPw" showPassword="true"/><br>
		우편번호 : <form:input path="userPostCode" /><br>
		주소1 : <form:input path="userAddress1" /><br>
		주소2 : <form:input path="userAddress2" /><br>
	</form:form>

# FormCustomTag2
    Spring-form jsp tag library

    https://docs.spring.io/spring-framework/docs/4.2.x/spring-framework-reference/html/spring-form-tld.html



## \<form:form> 태그
	ㄴ <form>태그를 생성
	
	form custom tag의 속성들
		modelAttribute : 넘어온데이터를 받는부분
			ㄴ form 태그 내의 입력 요소들에 적용된 value 값을 가진 객체이름을 받는 속성
			modelAttribute 속성에 할당된 값 (객체이름)이 input 태그의 id 속성 값으로 된다
			이를 생략하면 command 라는 문자열이 input 태그의 id 속성값으로 설정됨
			
			
		action
			ㄴ 요청할 주소를 할당받는 속성
			    생략할시 현재 페이지(자기자신 페이지)로 자동으로 설정된다
			    
		method
			ㄴ 요청방식을 할당받는 속성
			    생략하면 post로 설정된다
			    
	다 생략시 이렇게 된다는 뜻임
	<form id="command" action="/FormCustomTag2/test1" method="post">
	
	
## \<form:button> 태그 
	ㄴ submit버튼을 생성한다
	
		disabled 속성을 true로 설정할시 버튼이 비활성화 되어 누를수가 없는상태가 된다
			ㄴ form태그에서 disabled="disabled" 와 같은것

## \<form:hidden> 태그
	ㄴ input태그의 type="hidden"과 같은태그
	ㄴ화면에는 보이지않지만 값을 처리할 때 쓰는태그
		path속성 : id속성과 name속성의 역할을 함 - modelAttribute에 할당된 값까지 value에 받아옴(주입함)
			ㄴpath 속성에 할당된 값은 일반 input 태그의 id속성과 name 속성의 역할을 함
			
## \<form:input> 태그
	ㄴ type 이 text인 input 태그를 생성한다
		path속성 : id속성과 name속성의 역할을 함 - modelAttribute에 할당된 값까지 value에 받아옴(주입함)
			ㄴpath 속성에 할당된 값은 일반 input 태그의 id속성과 name 속성의 역할을 함	
			=form:form태그의 modelAttribute 속성에 의해 추출된
			 model의 (HttpServletRequest 객체에 저장된 객체)
			  멤버 변수를 추출해서 (input 태그로 변환된) value 속성에 주입(할당) 한다
			  
## \<form:password> 태그
	ㄴ type 이 password인 input 태그를 생성함
		path속성은 input과 특징이 같다
	ㄴ showPassword속성
		ㄴ 이 속성을 true로 해야 password가 보인다(불릿으로) - showPassword를 안걸면 value가 넘어오질 않는다
		
## \<form:textarea> 태그
	ㄴ type이 textarea인 input 태그를 생성함


# FormCustomTag3
## form custom tag의 select, checkbox, radio 태그

### \<form:select> 태그
	ㄴ select 태그를 생성함
		path속성은 input폼태그의 설명과 같음
		단, 받은 data값이 옵션의 기본 값으로 선택되어있음 (selected="selected" 되어잇단 말임)

        
    <form:option> 태그 <form:select> 태그의 하위태그
    <form:option> : select 태그의 option 태그 하나를 생성함
    <form:options> : select 태그의 option 태그 여러개를 생성함
    items:option <== 태그들을 생성할 때 필요한 data가 담긴 list나 배열