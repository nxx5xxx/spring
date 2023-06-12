package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;

@Controller
@SessionAttributes({"sessionBean1","sessionBean2"})
public class TestController2 {
	
	// @ModelAttribute 를 활용하여 객체를 생성하고 반환하는 메소드를 작성해야 한다 
	// return new TestBean1()에서 반환하는 객체의 주소를
	// @ModelAttribute("sessionBean1")에 지정한 "sessionBean1" 이라는 이름으로 session 영역에 저장한다는 의미 
	@ModelAttribute("sessionBean1")
	public TestBean1 sessionBean1() {
		return new TestBean1();
	}
	//sessionBean1은 TestBean1과 연결되어있고
	//sessionBean2는 TestBean2과 연결되어있다는 의미
	@ModelAttribute("sessionBean2")
	public TestBean2 sessionBean2() {
		return new TestBean2();
	}
	
	
	@GetMapping("/test7")
	public String test7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		// @ModelAttribute("sessionBean1") -> session.setAttribute(sessionBean1)를 자동으로 해주는것
		// 매개변수에 TestBean1 sessionBean1 를 써줌으로써 TestBean1 sessionBean1 = new TestBean1() 까지 자동으로해줌
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		return "test7";
	}
	
	@GetMapping("/result7")
	public String result7(@ModelAttribute("sessionBean1") TestBean1 sessionBean1) {
		//@ModelAttribute("sessionBean1") TestBean1 sessionBean1 는 콘솔창에 출력하려고 쓴것이고 생략해도된다
		System.out.println(sessionBean1.getData1());
		System.out.println(sessionBean1.getData2());
		return "result7";
	}
	
	@GetMapping("/test8")
	public String test8(@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		sessionBean2.setData3("화면구현2");
		sessionBean2.setData4("UI테스트2");
		return "test8";
	}
	
	@GetMapping("/result8")
	public String result8(@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		System.out.println(sessionBean2.getData3());
		System.out.println(sessionBean2.getData4());
		return "result8";
	}
	//메소드 하나로 객체 두개 한꺼번에 설정
	
	@GetMapping("/test9")
	public String test9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
			@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		sessionBean1.setData1("화면구현");
		sessionBean1.setData2("UI테스트");
		sessionBean2.setData3("화면구현2");
		sessionBean2.setData4("UI테스트2");
		return "test9";
	}
	
	@GetMapping("/result9")
	public String result9(@ModelAttribute("sessionBean1") TestBean1 sessionBean1,
			@ModelAttribute("sessionBean2") TestBean2 sessionBean2) {
		System.out.println(sessionBean1.getData1());
		System.out.println(sessionBean1.getData2());
		System.out.println(sessionBean2.getData3());
		System.out.println(sessionBean2.getData4());
		return "result9";
	}
}
