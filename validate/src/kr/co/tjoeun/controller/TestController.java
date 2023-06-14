package kr.co.tjoeun.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	@GetMapping("/input_data")
	public String input_data() {
		return "input_data";
	}
	
	@PostMapping("/input_result")
	public String input_procedure(@Valid TestBean1 bean1, BindingResult result) {
		//모델어트리뷰트로 지정해주지않으면 testBean1으로 EL태그로받아야함
		System.out.println(bean1.getData1());
		System.out.println(bean1.getData2());
		
		System.out.println("BindingResult : "+result);
		
		if(result.hasErrors()) {
			//유효성 위반 결과 모두 가져오기
			for(ObjectError error : result.getAllErrors()) {
				System.out.println("에러메세지 : "+error.getDefaultMessage());
				System.out.println("에러코드 : "+error.getCode());
				System.out.println("object name : "+error.getObjectName());
				
				String[] errorCodes = error.getCodes();
				for(String code : errorCodes) {
					System.out.println(code);
				}
				if(errorCodes[0].equals("Size.testBean1.data1")) {
					System.out.println("data1 은 2~10 글자만 입력 할 수 있습니다");
				}else if(errorCodes[0].equals("Max.testBean1.data2")) {
					System.out.println("data2는 100이상의 값이 될 수 없습니다");
				}
				
				System.out.println("------------------------");
			}
			return "input_data";
		}
		
		return "input_success";
	}
}
