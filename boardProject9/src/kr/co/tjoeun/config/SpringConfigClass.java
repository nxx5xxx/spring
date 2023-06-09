package kr.co.tjoeun.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/*//프로젝트 실행시 자동으로 호출됨
//web.xml의 역할
public class SpringConfigClass implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//System.out.println("onStartup() 메소드 - 프로젝트 시작시 자동으로 호출됨 ");
		
		  	web.xml을 자바방식으로 설정할것임 
        이것을 자바식으로 설정하면 즉 servlet_context.xml이랑 root_context.xml을 설정해줄것임
        ser_con은 serappcontext.java 참고
		
		
		// Spring MVC project 에 관련된 설정을 하는 클래스(ServletAppContext)의 객체 생성하기
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		servletAppContext.register(ServletAppContext.class); //이 서블릿앱콘텍스트 클래스의 정보를 갖고있는 객체를 생성함
		
		//요청 발생시 요청을 처리하는 Servlet을 
		//org.springframework.web.servlet 으로 지정함
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		
		//서블릿 레지스트레이션의 내부클래스인 다이나믹클래스
		//onStartup(ServletContext servletContext) 여기의 서블릿콘텍스트의 파라미터인 서블릿콘텍스트에 add해주는것
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
		
		
		// xml방식에서 <load-on-startup>1</~~> 설정부분
		servlet.setLoadOnStartup(1);
		
		
		      xml방식에서   <servlet-name>appServlet</servlet-name>
        				<url-pattern>/</url-pattern> 설정부분
		
		servlet.addMapping("/");
		
		//bean을 지정하는 클래스가 어떤클래스인지
		//Bean을 정의하는 클래스 지정하기 : RootAppContext
		AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootAppContext.class); //이 서블릿앱콘텍스트 클래스의 정보를 갖고있는 객체를 생성함
		
		//리스너 설정하기
		ContextLoaderListener listener = new ContextLoaderListener(rootAppContext); //()를 아규먼트라 한다
		servletContext.addListener(listener);
		
		//파라미터 인코딩 필터 설정 : 한글처리
		//뉴로 해서 넣는게아니라 클래스 정보를 넣는것 이므로 .class를 붙여야함
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		
			//	인코딩 utf-8 forceEncoding등 설정
		filter.setInitParameter("encodig", "UTF-8");
		filter.addMappingForServletNames(null, false,"dispatcherServlet" );//37번째 줄에있는 디스패쳐 서블릿임
	}*/
public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer{
	
	// 디스패쳐서블렛이 맵핑할 요청 주소 설정
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	// Spring MVC project 설정을 위한 클래스 지정하기
	@Override
		protected Class<?>[] getServletConfigClasses() {
		
			return new Class[] {ServletAppContext.class};
		}
	
	//project에서 사용하는 Beans 들을 정의하기 위한 클래스지정하기
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppContext.class};
	}
	//파라미터 엔코딩 필터 설정하기 : 한글처리
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		return new Filter[] {encodingFilter};
	}
	
	@Override
	protected void customizeRegistration(Dynamic registration) {
		super.customizeRegistration(registration);
		MultipartConfigElement config1 = new MultipartConfigElement(null, 1024*1024*50, 1024*1024*50*10, 0);
		registration.setMultipartConfig(config1);
//		location , maxFileSize, maxRequestSize , fileSizeThreshold
//		location : 파일 업로드 할 때 사용하는 임시 저장하는 경로
//		maxFileSize : 파일당 최대 파일 크기
//		maxRequestSize : 파일 한 개의 용량이 아니라 요청당 최대 파일 크기
//		fileSizeThreshold : 임시 파일을 만드는 기준, 메모리에서 바로 스트림으로 전달되는 크기
//		* 파일 업로드시 사용하는 옵션 maxFileSize, maxRequestSize  : -1은 크기 제한 없음
	}
}
