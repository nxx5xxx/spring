package kr.co.tjoeun.config;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.interceptor.CheckLoginInterceptor;
import kr.co.tjoeun.interceptor.CheckWriterInterceptor;
import kr.co.tjoeun.interceptor.TopMenuInterceptor;
import kr.co.tjoeun.mapper.BoardMapper;
import kr.co.tjoeun.mapper.TopMenuMapper;
import kr.co.tjoeun.mapper.UserMapper;
import kr.co.tjoeun.service.BoardService;
import kr.co.tjoeun.service.TopMenuService;


// Spring MVC project 에 관련된 설정을 하는 클래스
//servlet_context.xml 의 설정을 java로 한다면
//ServletAppContext의 객체는  SpringConfigClass 의 onStartup 메소드에서 생성할것이다

@Configuration
// @Controller 어노테이션이 설정된 클래스를 Controller로 등록하는 Annotation - EnableWebmvc
@EnableWebMvc
//Scan할 bean 들이 모여있는 package 지정하는 Annotation
@ComponentScan("kr.co.tjoeun.controller")
@ComponentScan("kr.co.tjoeun.service")
@ComponentScan("kr.co.tjoeun.dao")
@PropertySource("/WEB-INF/properties/db.properties")
public class ServletAppContext implements WebMvcConfigurer {
	
	@Value("${db.classname}")
	private String dbClassname;
	
	@Value("${db.url}")
	private String dbUrl;
	
	@Value("${db.username}")
	private String dbUsername;
	
	@Value("${db.password}")
	private String dbPassword;
	
	@Autowired
	private TopMenuService topMenuService;
	
	@Resource(name="loginUserBean")
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;
	
	//BasicDataSource : 데이터 베이스 접속정보를 관리하는 Bean (을 return함)
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource source = new BasicDataSource();
		source.setDriverClassName(dbClassname);
		source.setUrl(dbUrl);
		source.setUsername(dbUsername);
		source.setPassword(dbPassword);
		return source;
	};
	// Query 문과 Database 접속 정보를 관리하는 Bean을 (을 return함)
	@Bean
	public SqlSessionFactory factory(BasicDataSource source) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(source);
		SqlSessionFactory factory = factoryBean.getObject();
		return factory;
	}
	
	// Query문 실행을 위한 Bean(Mapper 관리) (을return 함)
	// 맵퍼등록하기
	
	//BoardMapper
	@Bean
	public MapperFactoryBean<BoardMapper> getBoardMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<BoardMapper> factoryBean = new MapperFactoryBean<BoardMapper>(BoardMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
		
	}
	
	//TopMenuMapper
	@Bean
	public MapperFactoryBean<TopMenuMapper> getTopMenuMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<TopMenuMapper> factoryBean = new MapperFactoryBean<TopMenuMapper>(TopMenuMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
		
	}
	
	//UserMapper
	@Bean
	public MapperFactoryBean<UserMapper> getUserMapper(SqlSessionFactory factory) throws Exception{
		MapperFactoryBean<UserMapper> factoryBean = new MapperFactoryBean<UserMapper>(UserMapper.class);
		factoryBean.setSqlSessionFactory(factory);
		return factoryBean;
		
	}
	
	/////////////////////////////////////////////////////////
	
	
	
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
	
	//Interceptor 등록하기
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		
		TopMenuInterceptor topMenuInterceptor = new TopMenuInterceptor(topMenuService , loginUserBean);
		
		InterceptorRegistration reg1 = registry.addInterceptor(topMenuInterceptor);
		reg1.addPathPatterns("/**");
		
		CheckLoginInterceptor checkLoginInterceptor = new CheckLoginInterceptor(loginUserBean);
		InterceptorRegistration reg2 = registry.addInterceptor(checkLoginInterceptor);
		
		//로그인 하지 않으면 접근할 수 없는 url 등록하기
		reg2.addPathPatterns("/user/modify" , "/user/logout", "/board/*");
		//예외사항
		reg2.excludePathPatterns("/board/main");
		
		//내글이 아닌 글 수정못하게
		CheckWriterInterceptor checkWriterInterceptor = new CheckWriterInterceptor(loginUserBean,boardService);
		InterceptorRegistration reg3 = registry.addInterceptor(checkWriterInterceptor);
		reg3.addPathPatterns("/board/modify" , "/board/delete");
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	
	//에러 메세지를 작성한 properties 파일 등록하기
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
		res.setBasenames("/WEB-INF/properties/error");
		//강사님은 names 에 error.properties
		return res;
	}
	
	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
}
