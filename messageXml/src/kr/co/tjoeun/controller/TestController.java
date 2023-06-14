package kr.co.tjoeun.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	//ReloadableResourceBundleMessageSource 객체를 주입받음
	@Autowired
	ReloadableResourceBundleMessageSource res;
	
	@GetMapping("/test1")
	public String test1() {
		String name1 = res.getMessage("student1.name1", null,null);
		String name2 = res.getMessage("student2.name2", null,null);
		System.out.println(name1);
		System.out.println(name2);
		return "test1";
	}
	@GetMapping("/sample1")
	public String sample1() {
		String name1 = res.getMessage("student1.name1", null,null);
		String name2 = res.getMessage("student2.name2", null,null);
		System.out.println(name1);
		System.out.println(name2);
		return "sample1";
	}
}