package kr.co.tjoeun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.BeanData;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(BeanData bean) {
		bean.setData1("spring framework");
		return "test1";
	}
	@GetMapping("/test2")
	public String test2(BeanData bean) {
		bean.setData1("spring framework");
		bean.setData2("Web Application");
		return "test2";
	}
	@GetMapping("/test3")
	public String test3(BeanData bean) {
		bean.setData1("spring framework");
		bean.setData2("Web Application");
		bean.setData3("데이터3");
		return "test3";
	}
	@GetMapping("/test4")
	public String test4(BeanData bean) {
		bean.setData1("spring framework");
		bean.setData2("Web Application");
		bean.setData3("데이터3");
		bean.setData4("동해물과 백 두산이 마 르고 닳 도록 하 느님이 보 우하사 우 리 ㄴㅏ라 망 세 무 궁화 삼 천리 화 려 가 앙 산 대 한 사람 대 한으로 길 이 보전 하 세");
		return "test4";
	}
}
