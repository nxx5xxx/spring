package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1() {
		System.out.println("Test1 을 호출하였습니다");
		
		return "test1";
	}
	@GetMapping("/test2")
	public String test2() {
		System.out.println("Test2 을 호출하였습니다");
		
		return "test2";
	}
	@GetMapping("/sub1/test3")
	public String sub1Test3() {
		System.out.println("sub1/Test3 을 호출하였습니다");
		
		return "sub1/test3";
	}
	@GetMapping("/sub1/test4")
	public String sub1Test4() {
		System.out.println("sub1/Test4 을 호출하였습니다");
		
		return "sub1/test4";
	}
}
