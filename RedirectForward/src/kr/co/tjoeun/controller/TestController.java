package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test1")
	public String test1() {
		
		return "redirect:/sub1";
		//리턴에 리다이렉트를 이렇게 넣으면 컨트롤러내에 /sub1을 참조 
	}
	
	@GetMapping("/sub1")
	public String sub1() {
		
		return "sub1";
	}
	
	@GetMapping("/test2")
	public String test2() {
		
	return "forward:/sub2";
	 
	}
	
	@GetMapping("/sub2")
	public String sub2() {
		
		return "sub2";
	}
}
