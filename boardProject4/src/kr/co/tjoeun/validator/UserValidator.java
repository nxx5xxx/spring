package kr.co.tjoeun.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.tjoeun.bean.UserBean;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		//리버싱 클래스의 정보를 갖고오기
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserBean userBean = (UserBean)target;
		
		if(userBean.getUser_pw().equals(userBean.getUser_pw2())==false) {
			//에러호출
			//errors.rejectValue("멤버필드","지정할에러코드")
			//이것을 에러프로퍼티스에서 사용가능하다
			errors.rejectValue("user_pw", "NotEquals");
		}
		
		//아이디가 DB에 이미 존재하는 경우 false반환이 되는데 false일경우 
		if(userBean.isUserIdExist()==false) {
			errors.rejectValue("user_id", "DontCheckuserIdExist");
		}
	}
	
	
}
