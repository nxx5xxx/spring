package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	@RequestMapping(value="/test1",method=RequestMethod.GET)
	public String test1_get(Model model) {
		model.addAttribute("method", "get");
		return "test1";
	}
	
	@RequestMapping(value="/test1",method=RequestMethod.POST)
	public String test1_post(Model model) {
		model.addAttribute("method", "post");
		return "test1";
	}
	
	@RequestMapping("/test2")
	public void test2_Get() {
		test2_Post();
	}
	
	@RequestMapping(value="/test2",method=RequestMethod.POST)
	public String test2_Post() {
		return "test2";
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.GET)
	public String test3_get() {
		return "test3_get";
	}
	
	@RequestMapping(value="/test3",method=RequestMethod.POST)
	public String test3_post() {
		return "test3_post";
	}
	
	@GetMapping("/test4")
	public String test4_get() {
		return "test4";
	}
	
	@PostMapping("/test4")
	public String test4_post() {
		return "test4";
	}
	
	@GetMapping("/test5")
	public String test5_get() {
		return "test5";
	}
	
	@PostMapping("/test5")
	public String test5_post() {
		return "test5";
	}
	
	@RequestMapping(value="/test6", method= {RequestMethod.GET, RequestMethod.POST})
	public String test6() {
		return "test6";
	}
}
