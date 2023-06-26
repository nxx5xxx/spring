package kr.co.tjoeun.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	//loginUserBean : 서버가 실행될때 Session Scope에 생성한 UserBean객체
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean; 
	
	public boolean checkUserIdExist(String user_id) {
		String user_name = userDAO.checkUserIdExist(user_id);
		if(user_name == null) {
			return true;
		}else {
			return false;
		}
		//return userDAO.checkUserIdExist(user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userDAO.addUserInfo(joinUserBean);
	}
	
	//로그인처리
	public void getLoginUserInfo(UserBean tmpLoginJoinUserBean) {
		UserBean tmpLoginJoinUserBean2 = userDAO.getLoginUserInfo(tmpLoginJoinUserBean);
		System.out.println("UserService : "+tmpLoginJoinUserBean2);
		if(tmpLoginJoinUserBean2 != null) {
			//로그인이 성공적으로 됏을시
			// DB에서 갖고온 값이 null 아 아니라면
			loginUserBean.setUser_id(tmpLoginJoinUserBean2.getUser_id());
			loginUserBean.setUser_name(tmpLoginJoinUserBean2.getUser_name());
			//로그인 상태인지 아닌지 여부를 저장하는 멤버변수
			loginUserBean.setUserLogin(true);
		}
		//return loginUserBean;//tmpLoginJoinUserBean2
	}
	
	//내정보수정
	public void getModifyUserInfo(UserBean modifyUserBean) {
			UserBean tmpModifyUserBean = userDAO.getModifyUserInfo(loginUserBean.getUser_idx());
			//아래 두 구문을 안해도 잘 갖고오긴하는데 이걸 왜 하는지 모르겠음
			// tmpModifyUserBean이 갖고있는 값을 스프링이 자동으로 생성해서 파라메터로 전달해준
			// modifyUserBean 객체의 멤버변수 user_id,user_name에 저장한다
			modifyUserBean.setUser_id(tmpModifyUserBean.getUser_id());
			modifyUserBean.setUser_name(tmpModifyUserBean.getUser_name());
			modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
			//return tmpModifyUserBean;
		
	}
	
	//수정확인
	public void modifyUserInfo(UserBean modifyUserBean) {
		// Session Scope에 있는 loginUserBean의 idx를
		//컨트롤러에서 (스프링이) 생성한 modifyUserBean 객체에 idx를 할당한다
		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());
		//수정할 사용자의 idx를 서비스의 modifyUserInfo()메소드로 넘겨준다
		userDAO.modifyUserInfo(modifyUserBean);
	}
	
}
