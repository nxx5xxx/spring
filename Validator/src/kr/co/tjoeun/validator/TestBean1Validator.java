package kr.co.tjoeun.validator;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.co.tjoeun.beans.TestBean1;

public class TestBean1Validator implements Validator{

	/*	
	 * 유혀성 검사할 data를 갖고있는 객체가 유효성 검사가 가능한지 확인한다
	 * 	*/
	@Override
	public boolean supports(Class<?> clazz) {
		
		return TestBean1.class.isAssignableFrom(clazz);
	}
	
	//유효성 검사하는 메소드
	
	//	public String inputProcedure(@Valid TestBean1 bean1,BindingResult result) {
	// 의 TestBean1이 target으로 지정되는것
	@Override
	public void validate(Object target, Errors errors) {
		//reject는 거부하다 라는 의미
		ValidationUtils.rejectIfEmpty(errors, "data2", "errors2");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "data3", "errors3");
		
	}

}
