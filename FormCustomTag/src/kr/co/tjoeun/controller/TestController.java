package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import kr.co.tjoeun.beans.UserInfoBean;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(UserInfoBean bean) {
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");
		return "test1";
	}
	
	//form커스텀태그 이용해서 받기
	@GetMapping("/test2")
	public String test2(UserInfoBean bean) {
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");		
		return "test2";
	}
	
	@GetMapping("/test3")
	public String test3(@ModelAttribute("bb") UserInfoBean bean) {
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");		
		return "test3";
	}
	
	//객체를 주입하지않고 모델을 쓰는방법 ( 모델을 직접 생성 ) 
	@GetMapping("/test4")
	public String test4(Model model) {
		UserInfoBean bean = new UserInfoBean(); //위에서는 이 과정을 스프링이 자동으로 해준것임
		bean.setUserName("강아지");
		bean.setUserId("spring");
		bean.setUserPw("1234");
		bean.setUserPostCode("10074");
		bean.setUserAddress1("경기도 고양시");
		bean.setUserAddress2("일산구 장항2동");		
		model.addAttribute("bb", bean);
		return "test4";
	}
}
