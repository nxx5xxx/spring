package kr.co.tjoeun.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import kr.co.tjoeun.beans.TestBeanbyName;
import kr.co.tjoeun.beans.TestBeanbyType;

//상속이 없음 : 프로젝트 작업시 사용할 bean을 정의하는 클래스
//root_context.xml의 역할
@Configuration
public class RootAppContext {

	//어떤 빈을 세션스코프에서 사용할수 있도록 설정하는것이
	
	//[Controller 에서] 타입을 통해 주입 -(주입: 객체를 생성하여 사용하겠다는 의미)
	@Bean
	@SessionScope
	public TestBeanbyType testBeanbyType() {
		return new TestBeanbyType();
	}
	
	//이름을통해 주입
	//[Controller 에서] 이름을 통해 주입할때만 Bean에 이름을 지정가능하다 
	@Bean("sessionBean2")
	@SessionScope
	public TestBeanbyName testBeanbyName() {
		return new TestBeanbyName();
	}
}
