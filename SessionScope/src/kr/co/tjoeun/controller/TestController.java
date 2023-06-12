package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		//세션 객체 생성하기
		HttpSession session = request.getSession();
		//세션 영역에 data할당
		session.setAttribute("data1", "스프링 웹");
		return "test1";
	}
	
	@GetMapping("/test2_redirect")
	public String test2(HttpSession session) {
		session.setAttribute("data1", "MVC패턴");
		return "redirect:result1";
	}
	@GetMapping("/test3_forward")
	public String test3(HttpSession session) {
		session.setAttribute("data1", "Model2방식");
		return "forward:/result1";
	}
	
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		//세션 객체 생성
		HttpSession session = request.getSession();
		//세션 영역에 있는 data1 갖고오기
		String data1 = (String)session.getAttribute("data1");
		System.out.println("data1 : " +data1);
		return "result1";
	}
	//세션객체 바로주입
	@GetMapping("/result1_1")
	public String result1_1(HttpSession session) {
		//세션 객체 생성
		//HttpSession session = request.getSession();
		//세션 영역에 있는 data1 갖고오기
		String data1 = (String)session.getAttribute("data1");
		System.out.println("data1 : " +data1);
		return "result1";
	}
	
	@GetMapping("/test4")
	public String test4(HttpSession session) {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("자바웹");
		bean1.setData2("HTML/CSS");
		session.setAttribute("bean1", bean1);
		return "test4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpSession session) {
//		TestBean1 bean1 = (TestBean1)session.getAttribute("bean1");
//		System.out.println(bean1.getData1());
//		System.out.println(bean1.getData2());
		//콘솔 출력안하려면 굳이 겟어트리뷰트해서 끌고올 필요없이 test4에서 동작하고나면 세션에 올라가있다
		return "result4";
	}

	//@SessionAttribute
	@GetMapping("/test5")
	public String test5(HttpSession session) {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTML/CSS/JSON");
		session.setAttribute("bean1_t", bean1);
		return "test5";
	}
	
	@GetMapping("/result5")
	public String result5(@SessionAttribute("bean1_t") TestBean1 beans) {
		System.out.println(beans.getData1());
		System.out.println(beans.getData2());
		// session.getAttribute("bean1_t")를 자동으로 한것
		return "result5";
	}
	
	//@SessionAttribute
	@GetMapping("/test6")
	public String test6(HttpSession session, TestBean1 bean1) {
											//ㄴ 여기엔 ModelAttribute가 생략되어있다 
											//그치만 setAttribute를하여 session영역에 저장된것
		bean1.setData1("자바웹프로그래밍");
		bean1.setData2("HTML/CSS/JSON");
		session.setAttribute("bean1_t", bean1);
		return "test6";
	}
	
	// session.getAttribute("bean1_t")를 자동으로 한것
	@GetMapping("/result6")
	public String result6(@SessionAttribute("bean1_t") TestBean1 beans) {
		System.out.println(beans.getData1());
		System.out.println(beans.getData2());
		
		return "result6";
	}

}
