package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {

	//새로운 요청이 발생될때 주입된다	
	//(RootAppContext.java 에서 @RequestScope로 설정된다)
	@Autowired
	TestBean1 testBean1;
	//RootAppContext에서 new TestBean1()을 호출해주는것
	//Autowired를 하면
	//testBean1이라는 객체의 타입을 바로 정의해줌
	//안썻을때는 TestBean1 testBean1 = new TestBean1(); 해야함
	
	
	
	//이것이 이름으로 요청 - byName
	//새로운 요청이 발생될때 주입된다
	//(RootAppContext.java 에서 @RequestScope로 설정된다)
	@Resource(name="testBean2")
	TestBean2 testBean2;
	
	
	
	//RootAppcontext에서 할당하지않고 클래스파일에서 한것이다	
	@Autowired
	TestBean3 testBean3;
	
	
	//컴포넌트에 밸류에 할당한 문자열이랑 name에 있는 문자열이랑 맞아야 할당된다 
	//RootAppcontext에서 할당하지않고 클래스파일에서 한것이다
	@Resource(name="testBean4")
	TestBean4 testBean4;
	
	
	
	//RootAppontext에서 요청한다는것이 여기서보이는 String testBean1()이것을 뜻함
	@GetMapping("testBean1")
	public String testBean1() {
		testBean1.setData1("자바웹");//Autowired를 했기때문에 set,get등 바로바로 사용이 가능한것이다
		testBean1.setData2("프레임워크");
		
		testBean2.setData3("파이썬");//Resource를 했기때문에 set,get등 바로바로 사용이 가능한것이다
		testBean2.setData4("데이터분석");
		
		testBean3.setData5("서블릿");
		testBean3.setData6("JSP");
		
		testBean4.setData7("프론트");
		testBean4.setData8("자바스크립트");
		
		//forwarding : 새로운 요청이 발생하지 않음
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println("testBean1.data1 : "+testBean1.getData1());
		System.out.println("testBean1.data2 : "+testBean1.getData2());
		
		System.out.println("testBean2.data3 : "+testBean2.getData3());
		System.out.println("testBean2.data4 : "+testBean2.getData4());
		
		System.out.println("testBean3.data5 : "+testBean3.getData5());
		System.out.println("testBean3.data6 : "+testBean3.getData6());
		
		System.out.println("testBean4.data7 : "+testBean4.getData7());
		System.out.println("testBean4.data8 : "+testBean4.getData8());
		
		model.addAttribute("testBean1", testBean1);
		model.addAttribute("testBean2", testBean2);
		model.addAttribute("testBean3", testBean3);
		model.addAttribute("testBean4", testBean4);
		return "result1";
	}
	
	

}
