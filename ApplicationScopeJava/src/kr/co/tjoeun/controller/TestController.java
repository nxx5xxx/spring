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
	
	//byType
	@Autowired
	TestBean1 applicationBean1;
	//byName
	@Resource(name="applicationBean2")
	TestBean2 applicationBean2;
	
	//byType
	@Autowired
	TestBean3 applicationBean3;
	
	//byName 
	//component value와 name을 일치시켜줘야한다 
	@Resource(name="applicationBean4")
	TestBean4 applicationBean4;
	
	@GetMapping("/test1")
	public String test1() {
		applicationBean1.setData1("데이터1");
		applicationBean1.setData2("데이터2");
		applicationBean2.setData3("데이터3");
		applicationBean2.setData4("데이터4");
		return "test1";
	}
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println(applicationBean1.getData1());
		System.out.println(applicationBean1.getData2());
		System.out.println(applicationBean2.getData3());
		System.out.println(applicationBean2.getData4());
		//주입만 이루어지고 자동으로 application 영역에 저장되지는 않는다
		//그래서 model로 올려주는것
		//model로 올려주면 request scope에 저장된다
		model.addAttribute("applicationBean1", applicationBean1);
		model.addAttribute("applicationBean2", applicationBean2);
		
		return "result1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		applicationBean3.setData5("데이터5");
		applicationBean3.setData6("데이터6");
		applicationBean4.setData7("데이터7");
		applicationBean4.setData8("데이터8");
		return "test2";
	}
	@GetMapping("/result2")
	public String result2(Model model) {
		System.out.println(applicationBean3.getData5());
		System.out.println(applicationBean3.getData6());
		System.out.println(applicationBean4.getData7());
		System.out.println(applicationBean4.getData8());
		//주입만 이루어지고 자동으로 application 영역에 저장되지는 않는다
		//그래서 model로 올려주는것
		//model로 올려주면 request scope에 저장된다
		model.addAttribute("applicationBean3", applicationBean3);
		model.addAttribute("applicationBean4", applicationBean4);
		
		return "result2";
	}
}
