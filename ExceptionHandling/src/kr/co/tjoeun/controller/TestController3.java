package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController3 {

	@GetMapping("/exception3")
	public String exception3(Model model) {
		ArrayList<String> list1 = null;
		list1.add("객체가없으니까 널포인터 익셉션 에러가 날것이다");
		return "exception3";
	}
	//NullpointerException이지만
	//이걸 처리할 예외처리가없기때문에 500페이지가뜬다
	@ExceptionHandler(ArrayIndexOutOfBoundsException.class)
	public String arrayException() {
		return "arrayException";
	}
}
