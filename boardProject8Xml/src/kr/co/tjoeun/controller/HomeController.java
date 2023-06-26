package kr.co.tjoeun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.tjoeun.bean.UserBean;


@Controller //이 어노테이션을 보고 컨트롤러라고 인식 
public class HomeController {
	
	//byName이기때문에 리소스로 별칭지정 (byName이 Bean에 이름넣은것)
	//byType은 Autowired
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	//리퀘스트는 주소표시줄에 들어간 url을 얘기함
	// 도메인:포트번호/ 여기서 /를 뜻함
	// url끝에 / 가 들어오면 동작한다는 의미
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request) {//호출은 home()메소드로 호출하는것이 아닌 리퀘스트 어노테이션의 밸류값으로 호출하는것이다 
		String url = request.getContextPath();
		System.out.println("주소표시줄에 "+url+" 이 입력되었습니다 ");
		
		System.out.println("loginUserBean : "+loginUserBean);
		
		return "redirect:/main";
		/*
		 /WEB-INF/views/index.jsp 에서
		 /WEB-INF/views/ 이 부분을 접두사라 하고  - prefix
		 .jsp 이부분을 접미사라한다 - suffix
		 이 설정은  servlet-context.xml에서 설정한다
		*/
	}
	
}
