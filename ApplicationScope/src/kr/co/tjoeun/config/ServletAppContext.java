package kr.co.tjoeun.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
	
	
}
