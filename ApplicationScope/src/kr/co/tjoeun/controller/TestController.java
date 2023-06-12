package kr.co.tjoeun.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	
	@Autowired
	ServletContext application;
	
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		//ServletContext 객체는 application을 의미
		ServletContext application = request.getServletContext(); //서블릿컨텍스트 객체생성
		application.setAttribute("name", "강아지");
		return "test1";
	}
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		String name = (String)application.getAttribute("name"); //받아올떈 Object로 갖고와서 형변환을 해줘야한다
		System.out.println(name);
		return "result1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		//ServletContext 객체는 application을 의미
		//ServletContext application = request.getServletContext(); //서블릿컨텍스트 객체생성
		application.setAttribute("name", "강아지");
		return "test2";
	}
	@GetMapping("/result2")
	public String result2() {
		//ServletContext application = request.getServletContext();
		String name = (String)application.getAttribute("name"); //받아올떈 Object로 갖고와서 형변환을 해줘야한다
		System.out.println(name);
		return "result2";
	}
	@GetMapping("/test3")
	public String test3() {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("데이터1");
		bean1.setData2("데이터2");
		
		application.setAttribute("bean1", bean1);
		
		return "test3";
	}
	@GetMapping("/result3")
	public String result3() {
		TestBean1 bean1 = (TestBean1)application.getAttribute("bean1");
		System.out.println(bean1.getData1());
		System.out.println(bean1.getData2());
		return "result3";
	}

}
