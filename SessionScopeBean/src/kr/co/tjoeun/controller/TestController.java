package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBeanbyName;
import kr.co.tjoeun.beans.TestBeanbyType;

@Controller
public class TestController {
	
	// Bean을  type(클래스이름) 으로 주입받음
	@Autowired
	TestBeanbyType testBeanbyType; //이렇게만해도 자동으로 생성돼서 할당까지됨 = new TestBeanbyType();이 생략됨

	// Bean을  name(설정한 이름) 으로 주입받음
	@Resource(name = "sessionBean2")
	TestBeanbyName sessionBean2;
	
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	@GetMapping("/result1")
	public String result1() {
		
		return "result1";
	}
}
