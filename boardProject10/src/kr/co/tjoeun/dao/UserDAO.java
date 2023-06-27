package kr.co.tjoeun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.mapper.UserMapper;

@Repository
public class UserDAO {

	@Autowired
	private UserMapper userMapper;
	
	public String checkUserIdExist(String user_id) {
		String user_name = userMapper.checkUserIdExist(user_id);
		return user_name;	
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean tmpLoginJoinUserBean) {
		UserBean userBean = userMapper.getLoginUserInfo(tmpLoginJoinUserBean);
		return userBean;
	}
	
	public UserBean getModifyUserInfo(int user_idx) {
		UserBean userBean = userMapper.getModifyUserInfo(user_idx);
		return userBean;
		
	}
	
	public void modifyUserInfo(UserBean modifyUserBean) {
		userMapper.modifyUserInfo(modifyUserBean);
	}
}
