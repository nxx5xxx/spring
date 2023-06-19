package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController2 {

	@GetMapping("/exception2")
	public String exception1(Model model) {
		ArrayList<String> list1 = null;
		list1.add("객체가없으니까 널포인터 익셉션 에러가 날것이다");
		return "exception2";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException() {
		return "nullpointer_exception";
	}
}
