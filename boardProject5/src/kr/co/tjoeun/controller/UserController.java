package kr.co.tjoeun.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.UserService;
import kr.co.tjoeun.validator.UserValidator;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 서버가 실행될때 세션스코프에 생성한 userbean객체
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("tmpLoginJoinUserBean") UserBean userBean,
			@RequestParam(value="fail", defaultValue="false") boolean fail,
			Model model) {
		model.addAttribute("fail",fail);
		
		return "user/login";
	}
	
	@PostMapping("/login_procedure")
	public String loginProcedure(@Valid @ModelAttribute("tmpLoginJoinUserBean") UserBean tmpLoginJoinUserBean, BindingResult result) {	
		if(result.hasErrors()) {
			return "user/login";
		}
		//로그인 성공한 경우 처리하는 부분
		userService.getLoginUserInfo(tmpLoginJoinUserBean);
		//boolean loginCheck  =  userService.getLoginUserInfo(tmpLoginJoinUserBean).isUserLogin()
		System.out.println(loginUserBean.isUserLogin());
		if(loginUserBean.isUserLogin() == true) {
			System.out.println("로그인성공");
			return "user/login_success";
		}else {
			System.out.println("로그인실패");
			return "user/login_fail";
		}
		
		
	}
	
	@GetMapping("/join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {
		return "user/join";
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
	
	
	@GetMapping("/modify")
	public String modify() {
		return "user/modify";
	}
	@GetMapping("/logout")
	public String logout() {
		return "user/logout";
	}
	

	
	
	//커스텀한 발리데이터를 등록하기
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		UserValidator userValidator = new UserValidator();
		binder.addValidators(userValidator);
	}
	

}
