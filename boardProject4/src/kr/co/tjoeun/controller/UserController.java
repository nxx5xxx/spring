package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.UserService;
import kr.co.tjoeun.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
	}
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	
	@PostMapping("/join_procedure")
	public String join_procedure(@Valid  @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {
		// BindingResult는  발리데이트 결과
		if(result.hasErrors()) {
			//발리데이트(유효성검사) 통과 못할시
			return "user/join";
		}
		userService.addUserInfo(joinUserBean);
		//System.out.println(bean.getUser_id());
		
		return "user/join_success";
	}
	
	//커스텀한 발리데이터를 등록하기
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator userValidator = new UserValidator();
		binder.addValidators(userValidator);
	}
	

}
