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
		
		//현재 validatiion 이 적용되는 bean 의 이름을 얻어옴
		String beanName = errors.getObjectName();
		
//		아래 validation은 beanName 이 joinUserBean인 객체에 대한 것 이므로
//		beanName.equals("joinUserBean")일 때만 적용되어야 한다
//		즉, beanName이 tmpLoginjoinUserBean인 경우에 적용되면 오류가 발생한다
//		이러한 이유로 if(beanName.equals("joinUserBean")) 로 설정해줌
		if(beanName.equals("joinUserBean") || beanName.equals("modifyUserBean")) {
			if(userBean.getUser_pw().equals(userBean.getUser_pw2())==false) {
				//에러호출
				//errors.rejectValue("멤버필드","지정할에러코드")
				//이것을 에러프로퍼티스에서 사용가능하다
				errors.rejectValue("user_pw", "NotEquals");
			}
		}
		
		if(beanName.equals("joinUserBean")){
			//아이디가 DB에 이미 존재하는 경우 false반환이 되는데 false일경우 
			if(userBean.isUserIdExist()==false) {
				errors.rejectValue("user_id", "DontCheckuserIdExist");
			}
		}
		
	}
	
	
}
