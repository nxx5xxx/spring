package kr.co.tjoeun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.tjoeun.interceptor.TestInterceptor1;
import kr.co.tjoeun.interceptor.TestInterceptor2;
import kr.co.tjoeun.interceptor.TestInterceptor3;
import kr.co.tjoeun.interceptor.TestInterceptor4;
import kr.co.tjoeun.interceptor.TestInterceptor5;
import kr.co.tjoeun.interceptor.TestInterceptor6;
import kr.co.tjoeun.interceptor.TestInterceptor7;
import kr.co.tjoeun.interceptor.TestInterceptor8;

// Spring MVC project 에 관련된 설정을 하는 클래스
//servlet_context.xml 의 설정을 java로 한다면
//ServletAppContext의 객체는  SpringConfigClass 의 onStartup 메소드에서 생성할것이다

@Configuration
// @Controller 어노테이션이 설정된 클래스를 Controller로 등록하는 Annotation - EnableWebmvc
@EnableWebMvc
//Scan할 bean 들이 모여있는 package 지정하는 Annotation
@ComponentScan("kr.co.tjoeun.controller")
public class ServletAppContext implements WebMvcConfigurer {

		//컨트롤러 메소드에서 반환하는 문자열의 prefix와 suffix경로 정보 설정하기 - 접두사 접미사
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		WebMvcConfigurer.super.configureViewResolvers(registry);
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	//정적파일 경로 지정하기 : HTML에서 사용하는 이미지 , 사운드 , js, css등 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	
	//interceptor를 등록하는 메소드
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		//System.out.println("addInterceptor시작");
		//서버가 켜질때 시작함
		TestInterceptor1 inter1 = new TestInterceptor1();
		InterceptorRegistration reg1 = registry.addInterceptor(inter1);
		
		// InterceptorRegistration 클래스의 addPathPatterns 메소드의 argutent로 url pattern을 지정한다
		
		reg1.addPathPatterns("/test1");
		//즉 /test1이 찍히면 이것을 동작 시키기 전(View가 나오기 전 )에 TestInterceptor클래스를 먼저 동작시킨다는것
		//그러면 TestInterceptor에 설정한 시점에 따라 코드가 실행된다
		
		TestInterceptor2 inter2 = new TestInterceptor2();
		InterceptorRegistration reg2 = registry.addInterceptor(inter2);
		reg2.addPathPatterns("/test1");
		//preHandle에서는 순서대로 실행되지만
		// post및 after에서는 순서가 뒤에서부터 실행된다
		
		TestInterceptor3 inter3 = new TestInterceptor3();
		InterceptorRegistration reg3 = registry.addInterceptor(inter3);
		reg3.addPathPatterns("/test2");
		
		TestInterceptor4 inter4 = new TestInterceptor4();
		InterceptorRegistration reg4 = registry.addInterceptor(inter4);
		//		reg4.addPathPatterns("/test1");
		//		reg4.addPathPatterns("/test2");
		//하나로 묶는법 , 한개로 두개를 지정하기		
		reg4.addPathPatterns("/test1","/test2");
		
		TestInterceptor5 inter5 = new TestInterceptor5();
		InterceptorRegistration reg5 = registry.addInterceptor(inter5);
		//		폴더내에 있는것에 인터셉터하기
		reg5.addPathPatterns("/sub1/test3", "/sub1/test4");
		
		// 와일드카드문자 사용 ( pattern )
		
		TestInterceptor6 inter6 = new TestInterceptor6();
		InterceptorRegistration reg6 = registry.addInterceptor(inter6);
		// 와일드카드문자
		// 그 다음  ' / ' 전 까지만 동작
		//만일 동작시키고 싶다면 reg6.addPathPatterns("/**"); 이렇게 쓰면 된다 
		reg6.addPathPatterns("/*");
		
		
		TestInterceptor7 inter7 = new TestInterceptor7();
		InterceptorRegistration reg7 = registry.addInterceptor(inter7);
		// 패턴을 나누는 기준이 ' / ' 임을 알 수 있다
		reg7.addPathPatterns("/sub1/*");
		
		TestInterceptor8 inter8 = new TestInterceptor8();
		InterceptorRegistration reg8 = registry.addInterceptor(inter8);
		// inter6에서설명한것
		reg8.addPathPatterns("/**");
		
		
		// excludePathPatterns
		// 다음 '/' 나오기 전까지를 다 제외시켜버림
		reg8.excludePathPatterns("/*");
	}
	
	
}
