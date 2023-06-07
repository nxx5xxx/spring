package kr.co.tjoeun.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tjoeun.beans.BeanData;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(BeanData bean) {
		bean.setData1("더좋은학원");
		return "test1";
	}
	
	@PostMapping("/send")
	public ModelAndView sendData(BeanData bean) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bean", bean);
		mv.setViewName("result");

		/* 
		 *  mv.setViewName("~~"); ->포워드방식
		 *  
		 *  mv.setViewName("redirect:/notice/List.do?num=1"); -> 리다이랙트방식
		 */
		
		return mv;
	}
}
