## 0612
### 수업내용
    SessionScope
    SessionScopeBean - (자바 설정방식)
    SessionScopeXml - (xml설정방식)
    ApplicationScope
    ApplicationScopeJava
    ApplicationScopeXml
    Cookie

---

## Session
	
	browser(client) 가 최초로 server에 요청하면
	browser 당 하나씩 메모리 공간을 server에 할당한다
	이 메모리 영역은 browser당 하나씩 지정되고
	새로운 요청이 발생해도 같은 메모리 공간을 사용한다
	이러한 메모리 공간을 session 이라고 한다
	이 영역은 browser를 종료할 때 까지 server에서 사용할 수 있다
	
	browser가 최초로 요청(request)을 보내고
	browser 를 닫을 때 까지의 scope를 SessionScope 라고 한다
	SessionScope에서는 session 영역에 저장된 data나 객체를 자유롭게 사용할 수 있다
									ㄴ>jsp에서 sessionScope 내장 객체를 사용한다
	
	HttpSession 객체를 생성하려면 HttpServletRequest객체가 필요하다 (또는 메소드에 바로 HttpSession으로 해도 가능하다)
			//세션 객체 생성
		HttpSession session = request.getSession();
			//세션 영역에 data할당
		session.setAttribute("el로 불러올 데이터명", 데이터변수명 혹은 "을이용하여 string전송");
	
---	
# SessionScope	
## @SessionAttribute - 메소드에 파라미터로 넣을시

	ㄴ session 영역에 저장되어 있는 객체를 사용하려고 할 때
		메소드의 매개변수로 @SessionAttribute를 선언 하면
		session 영역에 저장된 Bean을 주입 받게 된다
		즉, session.getAttribute(~)를 안해도 된다는 것
		
		**
		보내주는컨트롤러에서 
		session.setAttribute("bean1_t", bean1);을 했다면
		받는쪽에선 이런식으로 사용이 가능하다
		public String result5(@SessionAttribute("bean1_t") TestBean1 beans) {
		System.out.println(beans.getData1());
		System.out.println(beans.getData2());
		
		즉, 세션에 bean1_t라는 이름을 갖고와 TestBean1 beans 라는 이름으로 사용해라 이런의미
		EL태그에서도 세션으로 등록한 bean1_t로 써야 쓸 수 있다
		
	ㄴ @ModelAttribute 를 통해서 주입받는 Bean은
	    자동으로 request 영역에 저장되고 request영역으로부터 주입받는다

---

## @SessionAttributes("~") - 클래스위에 어노테이션으로 지정시

	    이 경우,@ModelAttribute를 통해 주입받는 Bean을
	  @SessionAttributes로 지정하면 request 영역에 아니라,
	  session 영역에 저장되고 , session 영역으로부터 주입받는다
	
	ㄴ이 경우 @ModelAttribute 를 활용하여 객체를 생성하고 반환하는 메소드를 작성해야 한다 
				ㄴ 해당하는 메소드 위에 @ModelAttribute("~") 를 주입
	예 : 
	@ModelAttribute("sessionBean1")
	public TestBean1 sessionBean1() {
		return new TestBean1();
	}
	- return new TestBean1()에서 반환하는 객체의 주소를
	- @ModelAttribute("sessionBean1")에 지정한 "sessionBean1" 이라는 이름으로 session 영역에 저장한다는 의미
	
	@GetMapping("/test7")
	public String test7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		// @ModelAttribute("sessionBean1") 
		// ㄴ"sessionBean1"을 TestBean1타입으로 session.setAttribute(sessionBean1)를 자동으로 해주는것
		// 매개변수에 TestBean1 sessionBean1 를 써줌으로써 TestBean1 sessionBean1 = new TestBean1() 까지 자동으로해줌
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		return "test7";
	}
	
	---
	
### @SessionAttributes("~") 여러개 넣고싶을시 중괄호를 이용한다
	
	예 : ({"sessionBean1", "sessionBean2"}); 
	- ModelAttribute는 request Scope영역에도 올라간다
	
	한꺼번에 올릴시
		public String test9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
			@ModelAttribute("sessionBean2") TestBean2 sessionBean2)
	이런식으로 가능하다


---

# SessionScopeBean
# SessionScopeBeanXML
## Session Scope
	Bean을 정의할 때, session scope 로 정의하면(= @SessionScope)
	browser가 server 에 최초로 요청(request)을 보낼 때
	Bean 객체가 주입된다 - 주입만 이루어지지 session 영역에 저장되지는 않음
	
	Java 설정 방식에서는 @SessionScope 어노테이션 사용
	xml 설정 방식에서는  bean을 정의할 때 scope = "session"으로 설정한다

---
# Application Scope
## Application Scope
	Server가 시작될 때 부터 종료될 때 까지의 범위
	Application Scope 동안 사용할 수 있는 메모리 영역이 만들어지고
	ServletContext(프로젝트(서버별로 사용하는 메모리영역을 Context라 칭한다)라는 클래스 타입의 객체로 관리된다
	
	ServeltContext 에 저장된 data나 객체는 Server가 종료되기 전 까지,
	웹브라우저 별로 별도의 메모리 공간을 사용하는 것이 아니고 같은 메모리 공간을 사용한다
	즉, 크롬으로 application 영역에 저장을해도 firefox에서도 같은 값을 갖고올수있음
	
## ServletContext
	Controller 에서 주입받는다
	HttpServletRequest 객체의 getServletContext() 메소드를 호출해서 생성한다

---
# ApplicationScopeJAVA
# ApplicationScopeXML
## ApplicationScope
	Bean을 정의할 때 application scope로 정의하면
	Server가 시작 할 때 자동으로 주입된다
	주입만 이루어지고 자동으로 application 영역에 저장되지는 않는다
	이 경우에는 Server가 시작할 때 자동으로 주입되므로
	@Lazy 어노테이션을 설정하지 않아도 된다
	
	Java 설정 방식 : @ApplicationScope 로 설정한다
	Java설정방식은 byName,byType 상관없이 주입만되고 application영역에 자동으로 저장되지않는다
	
	xml 설정 방식 : scope="application"으로 설정한다
	xml 설정방식은 byName만 자동으로 주입과 저장이 이루어진다

## @Component
	@ApplicationScope	
	//루트앱에서 인식이아닌 여기 자체에서 인식하게 하는것
	//컴포넌트 뒤에 (value="~") 를 붙이면 byName방식이 되는것 안붙이면 byType
	대신 ServletAppContext에서 @ComponentScan 에 등록을해줘야한다
	ex) @ComponentScan("kr.co.tjoeun.beans")

---

#     Cookie


## Cookie
	
	(여기서 client는 크롬 등등 브라우저)
	Client가 Server에 접속하면 Server에서 Client 쪽으로
	응답정보를 보내는데 이 정보가 Client의 web browser에 의해 저장된다
	response			ㄴ Client의 web browser에 저장됨
		ㄴ HttpServletResponse(내장객체)가 cookie를 추가한다 
									<--client 쪽 Browser에 저장된다
						reponse.addCookie(Cookie객체)
					
		Cookie 객체 생성 - 생성자의 argument 로 이름(변수)과 값을 지정함
		Cookie c1 = new Cookie("name","강아지")
		c1.setMaxAge(60*60*24*365); 시간 정함
		response.addCookie(c1); 쿠키추가
		
		*** 한글은 UTF-8 로 encoding 해줘야한다 ***				
	
	Client 의 Web browser에 Cookie가 저장된 이후에
	Client 가 Server에 재접속하면
	Client의 browser는 Server로 이 Cookie를 전달함
	
	Cookie는 Client의 browser에 저장되므로
	browser가 Server로 Cookie를 전달할 때만
	Server가 이 cookie 정보를 사용할 수 있음
	
	Server 측의 code로 Cookie에 data를 저장할 수는 없음
	 ㄴ browser 에 보내는 응답 결과(response) 에 
	 저장할 Cookie 정보를 담아 보내면
	 Client의 browser 에 의해서 Cookie가 저장된다
	 
	Spring MVC에서의 Cookie 저장은
	Servlet/JSP 에서 사용하는 방법으로 처리한다
	
		쿠키를 받으려면 배열로 받는다
		Cookie[] 배열명 = request.getCookies();
		인코딩했으니까 디코딩해줘야함
		URLDecoder.decode(반복문명.getValue(),"UTF-8")
		
	(Server) 에서 Cookie 읽기
	Cookie 정보는 client 의 browser 가 sever로 요청(request)을 보낼 때
	요청 정보에 담아서 server 쪽으로 전달함
	Servlet/JSP 에서는 Cookie 정보를 배열로 받아서 사용한다
	Spring MVC 에서는 Cookie 정보를 주입 받아서 사용한다
								ㄴ @CookieValue("전송했던쿠키이름") 라는 어노테이션을 사용
	ex)	public String loadCookie2(@CookieValue("data1") String cookie1) {

---