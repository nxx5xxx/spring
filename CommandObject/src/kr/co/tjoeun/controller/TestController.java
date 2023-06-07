package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.DataBean1;
import kr.co.tjoeun.beans.DataBean2;
import kr.co.tjoeun.beans.DataBean3;

@Controller
public class TestController {
	
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
}
