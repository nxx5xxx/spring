package kr.co.tjoeun.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	//loginUserBean : 서버가 실행될때 Session Scope에 생성한 UserBean객체
	@Resource(name = "loginUserBean")
	@Lazy
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
}