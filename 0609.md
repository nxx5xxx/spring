## 0609
### 수업내용
    FormCustomTag3
    RedirectForward
    RequestScope
    RequestScopeBean
    RequestScopeBeanXml

---

# FormCustomTag3
    
form custom tag의
select, checkbox, radio 태그

    <form:select> 태그
        ㄴ select 태그를 생성함
            path속성은 input폼태그의 설명과 같음
            단, 받은 data값이 옵션의 기본 값으로 선택되어있음 (selected="selected" 되어잇단 말임)
    <form:option> 태그 <form:select> 태그의 하위태그

    <form:option> : select 태그의 option 태그 하나를 생성함
    <form:options> : select 태그의 option 태그 여러개를 생성함
        ㄴ <form:options items="컨트롤러에서의 할당해준 배열명"> - 배열 외 어레이리스트도 ㄱㅏ능하다
        
            <form:options items="${requestScope.dataList2 }" itemLabel="key" itemValue="value" />
            <!-- itemLabel은 멤버필드에있는 변수명중 키로 잡을것을 넣어주면된다 -->
            <!-- itemValue는 멤버필드에있는 변수명중 값으로 잡을것을 넣어주면된다 -->
            </form:select>
            이런식으로 키값과 밸류값을 따로 지정해주는것도 가능(아마 해쉬맵으로 가능할것같음)
        
    items:option <== 태그들을 생성할 때 필요한 data가 담긴 list나 배열
    --체크박스

    <form:checkbox>,<form:checkboxes>

    <form:checkbox> 체크박스 한개 생성
    <form:checkboxes> 체크박스 여러개 생성
    items : checkbox들을 생성하기 위해 필요한 정보가 저장된 list나 배열

    --라디오
    <form:radiobutton>, <form:radiobuttons>


    <form:radiobutton> : 라디오버튼 하나 생성
    <form:radiobuttons> 라디오버튼 여러개 생성

## form:select
### class에 private String key와 private String value를 잡아놨을때
        <form:select path="data4">
			<form:options items="${requestScope.dataList2 }" itemLabel="key" itemValue="value" />	
		 <!-- itemLabel은 멤버필드에있는 변수명중 키로 잡을것을 넣어주면된다 -->
		 <!-- itemValue는 멤버필드에있는 변수명중 값으로 잡을것을 넣어주면된다 -->
		</form:select>

        이런식으로 key와 value 지정이 가능하다

### key와 value없이 그냥 어레이리스트를 받아올때
	<form:select path="data3">
		<form:options items="${dataList1 }" /> 
	</form:select>

    배열로도 받아올 수 있다

<h2 style="color:red"> * 체크박스와 라디오 버튼도 사용법은 동일하다 <h2>

---

# RedirectForward

## Code의 흐름

				↗request(요청)-->요청정보분석↓↓
	Browser(Client)  				Server↓
				↖response(응답) <--		응답결과생성


## Spring Framework(MVC)

	ㄴ 요청이 들어오면 요청주소(URl) 를 분석함
	    이 URL과 mapping 된 메소드(Controller 내)를 호출함
	    이 메소드가 반환하는 정보(return "jsp page(view이름)")를 기반으로
	    응답결과는 생성해서(html(jsp) code) Client(Client 쪽의 Browser) 에게 보냄
	    
## 메소드(Controller 내의 메소드) 의 return

	Controller를 통해 요청주소(URL)와 Mapping 되어 있는 메소드가 반환하는 값
	
	문자열(view 이름), Model, ModelAndView 객체 등을 반환 할 수 있음
	 ㄴ Client쪽 Browser로 전달할 응답결과(response)를 
	     생성하기 위해 JSP를 지정하는 부분
	     
	문자열(view 이름), Model, ModelAndView 객체 이외의
	다른 정보들도 반활할 수 있음
	     
## Redirect (Browser 를 거침 : Browser에서 Server에 요청(request) 을 다시 보냄)

		:Client 에서 새로운 페이지 요청을 응답결과로 전달한다
	ㄴ Client가 Server에게 요청한 것(request)에 대한 응답결과(response)를 전달하는 것
										(Client 쪽의 Browser 로 전달)
	Redirect는 새로운 요청(request)이 발생하는 것임
		ㄴ HttpServletRequest 객체가 일단 소멸 된 후(메모리가 삭제) 새롭게 생성됨
		HttpSession 객체는 소멸되지않고 그대로 유지가 됨
    -- return "redirect:/sub1"; 이런식으로 사용함		
		
## Forward (Browser 를 거치지 않고 (code의 흐름이 ) Server 내부에서만 이동함)

		:Server 상 에서만 code의 흐름이 이동된다
	ㄴ즉, Browser는 다른 곳으로 흐름이 이동되었다는 것을 인식하지 못한다
	 	ㄴ 주소창의 주소가 변경되지 않는다
    -- return "forward:/sub2"; 이런식으로 사용함	 	

---

# RequestScope
RequestScope

	ㄴClient의 Browser 로부터
	새로운 요청이 들어와서 응답결과(response)가
	다시 Client의 Browser로 전달될 때까지
	요청(request) 정보가 담겨있는
	Request 객체를 사용할 수 있음
		<-- 이런 경우 사용범위를 RequestScope 라고 함
	ㄴHttpServletRequest 객체에
	 data 나 객체를 저장할 수 있고
	 RequestScope 내에서 사용할 수 있음
            (Scope : 영역 범위라는 뜻)
	 RequestScope 에 data를 저장한다는 것의 의미
	 	ㄴ request가 들어와서 response를 보낼 때 까지만
	 	    이 data를 사용하겠다는 것 

---

# RequestScopeBean

## Bean Injection : 빈 주입

	@Autowired 어노테이션을 사용하여
	Bean 을 자동으로 주입 받기
	
	Spring core에 prototype, singleton 이 있고
	Spring MVC 에서 request, session, application 이 추가됨
	
## Request Scope

		ㄴ Bean 을 정의할 때 request scope로 정의하면
		요청(request) 이 발생할 때 마다 Bean 객체가 생성되어서
		자동으로 주입된다
		(생성된) Bean은 요청 발생시 주입만 되고
		request scope에 저장되지는 않는다 - java방식은 byName을해도 저장안되ㅣ지만 xml방식은 request에 자동으로 저장된다
		* 저장을 되게하려면 xml 방식으로 설정해서 byName으로 주입 받을때
		request scope에 자동으로 저장되게 할 수 있다
				
				@Autowired
				TestBean1 testBean1;
			//이것을 타입으로 주입받는방식이라한다 
			//생성자로 주입받는방식과 타입으로 주입받는 방식이있음
		
			(byName)-?
				@Resource(name="testBean2")
				TestBean2 testBean2;
				
				
		java 방식으로 설정할 때는 @RequestScope 어노테이션을 사용한다
		
		xml 방식으로 Bean을 정의할 때, scope="request"로 설정한다
	ex)root_context.xml에서	
		<bean class="kr.co.tjoeun.beans.TestBean1" scope="request" />
		
		xml에서 byName방식은
		<bean class="kr.co.tjoeun.beans.TestBean2" scope="request" id="testBean2"/>
		
		
## @Component 어노테이션을 사용하여 Bean을 등록하는 경우,

	이 Bean 들이 들어있는 package 를 scan 해야
	Bean 으로 자동으로 등록된다
		ㄴ ServletAppContext.java 에서 설정함
			@ComponentScan("패키지명.클래스명")

---

# xml에서의 주의점 Controller

	//Lazy는 서버가 올라갔을때 객체를생성하는게 아닌 요청을 받을때 생성해라 라는 의미
	/*
	 * xml설정 방식으로 했을때
	 * scope="request" 인 경우에는
	 * @Lazy를 사용해야 요청이 들어올 때만 bean 객체가 주입된다
	*/
	@Autowired
	@Lazy
	TestBean1 testBean1;
	//RootAppContext에서 new TestBean1()을 호출해주는것
	//Autowired를 하면
	//testBean1이라는 객체의 타입을 바로 정의해줌
	//안썻을때는 TestBean1 testBean1 = new TestBean1(); 해야함
	//이것을 타입으로 주입받는방식이라한다
	//생성자로 주입받는방식과 타입으로 주입받는 방식이있음
	
	@Resource(name="testBean2")
	@Lazy
	TestBean2 testBean2;
	
	
	//RootAppcontext에서 할당하지않고 클래스파일에서 한것이다	
	@Autowired
	@Lazy
	TestBean3 testBean3;
	
	
	//컴포넌트에 밸류에 할당한 문자열이랑 name에 있는 문자열이랑 맞아야 할당된다 
	//RootAppcontext에서 할당하지않고 클래스파일에서 한것이다
	@Resource(name="testBean4")
	@Lazy
	TestBean4 testBean4;
	
	
	//RootAppontext에서 요청한다는것이 여기서보이는 String testBean1()이것을 뜻함
	@GetMapping("testBean1")
	public String testBean1() {
		testBean1.setData1("자바웹");//Autowired를 했기때문에 set,get등 바로바로 사용이 가능한것이다
		testBean1.setData2("프레임워크");
		
		testBean2.setData3("파이썬");//Resource를 했기때문에 set,get등 바로바로 사용이 가능한것이다
		testBean2.setData4("데이터분석");	
		
		testBean3.setData5("서블릿");
		testBean3.setData6("JSP");
		
		testBean4.setData7("프론트");
		testBean4.setData8("자바스크립트");
		
		//forwarding : 새로운 요청이 발생하지 않음
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println("testBean1.data1 : "+testBean1.getData1());
		System.out.println("testBean1.data2 : "+testBean1.getData2());

		System.out.println("testBean2.data3 : "+testBean2.getData3());
		System.out.println("testBean2.data4 : "+testBean2.getData4());
		
		System.out.println("testBean3.data5 : "+testBean3.getData5());
		System.out.println("testBean3.data6 : "+testBean3.getData6());
		
		System.out.println("testBean4.data7 : "+testBean4.getData7());
		System.out.println("testBean4.data8 : "+testBean4.getData8());
		
		model.addAttribute("testBean1", testBean1);
		model.addAttribute("testBean3", testBean3);
		model.addAttribute("testBean4", testBean4);
		//model.addAttribute("testBean2", testBean2); -- xml방식에서 byName은 이걸 생략해줘도된다
		//생략안할시 javax.servlet.ServletException: java.lang.StackOverflowError 가뜰것이다
		/*
		 * xml방식으로 설정할 때에 한해서
		 * root-context.xml에서
		 * 		<bean class="kr.co.tjoeun.beans.TestBean2" scope="request" id="testBean2"/>
		 * 에서 scope="request" id="testBean2" 이 두 설정을 같이 하면
		 * 자동으로 주입도 되고 , request scope 로딩도 자동으로 된다
		 * 
		 * 
		 */
		
		return "result1";
	}