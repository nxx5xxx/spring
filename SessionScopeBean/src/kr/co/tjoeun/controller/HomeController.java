package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller //이 어노테이션을 보고 컨트롤러라고 인식 
public class HomeController {
	
	//리퀘스트는 주소표시줄에 들어간 url을 얘기함
	// 도메인:포트번호/ 여기서 /를 뜻함
	// url끝에 / 가 들어오면 동작한다는 의미
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {//호출은 home()메소드로 호출하는것이 아닌 리퀘스트 어노테이션의 밸류값으로 호출하는것이다 
		System.out.println("주소표시줄에 http://localhost:8083/SpringMVCxml/ 이 입력되었습니다 ");
		return "index";
		/*
		 /WEB-INF/views/index.jsp 에서
		 /WEB-INF/views/ 이 부분을 접두사라 하고  - prefix
		 .jsp 이부분을 접미사라한다 - suffix
		 이 설정은  servlet-context.xml에서 설정한다
		*/
	}
	
	@RequestMapping(value="/tjoeun", method=RequestMethod.GET)
	public String tjoeun() {
		System.out.println("주소 표시줄에 http://localhost:8083/SpringMVCxml/tjoeun 이 입력되었습니다");
		return null;
	}
}
