package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {
	
	// Bean을  type(클래스이름) 으로 주입받음
//	@Autowired
//	TestBeanbyType testBeanbyType; //이렇게만해도 자동으로 생성돼서 할당까지됨 = new TestBeanbyType();이 생략됨
	  @Autowired
	  @Lazy
	  TestBean1 sessionBean1;
	
	// Bean을  name(설정한 이름) 으로 주입받음
//	@Resource(name = "sessionBean2")
//	TestBeanbyName sessionBean2;
	  @Resource(name="sessionBean2")
	  @Lazy
	  TestBean2 sessionBean2;
	//위에 두개 다 web.xml에서 설정해줬음
	// web.xml에서 id를 지정해주지않으면 클래스가 name이된다
	
	  @Autowired
	  TestBean3 sessionBean3;
	  
	  @Resource(name="sessionBean4")
	  TestBean4 sessionBean4;
	  
	  @GetMapping("/test1")
	  public String test1() {
		
		sessionBean1.setData1("자바웹");
		sessionBean1.setData2("스프링");
		sessionBean2.setData3("의존성주입");
		sessionBean2.setData4("제어의 역전");
		
		return "test1";
	  }
	  @GetMapping("/result1")
	  public String result1(Model model) {
		
		System.out.printf("sessionBean1.data1 : %s\n", sessionBean1.getData1());
		System.out.printf("sessionBean1.data2 : %s\n", sessionBean1.getData2());
		System.out.printf("sessionBean2.data3 : %s\n", sessionBean2.getData3());
		System.out.printf("sessionBean2.data4 : %s\n", sessionBean2.getData4());
		
		model.addAttribute("sessionBean1", sessionBean1);
		
		// xml 설정방식 중 byName 방식에서만 
		// session scope 에 객체를 자동으로 올림 
		// model.addAttribute("sessionBean2", sessionBean2);
		
		return "result1";
	  }

	  @GetMapping("/test2")
	  public String test2() {
		
		sessionBean3.setData5("자바웹");
		sessionBean3.setData6("스프링");
		sessionBean4.setData7("의존성주입");
		sessionBean4.setData8("제어의 역전");
		
		return "test2";
	  }
	  
	  @GetMapping("/result2")
	  public String result2(Model model) {
		
		System.out.printf("sessionBean3.data5 : %s\n", sessionBean3.getData5());
		System.out.printf("sessionBean3.data6 : %s\n", sessionBean3.getData6());
		System.out.printf("sessionBean4.data7 : %s\n", sessionBean4.getData7());
		System.out.printf("sessionBean4.data8 : %s\n", sessionBean4.getData8());
		
		//model.addAttribute("sessionBean1", sessionBean1);
		// model.addAttribute("sessionBean2", sessionBean2);
		model.addAttribute("sessionBean3", sessionBean3);
		model.addAttribute("sessionBean4", sessionBean4);
		
		return "result2";
	  }
	}
