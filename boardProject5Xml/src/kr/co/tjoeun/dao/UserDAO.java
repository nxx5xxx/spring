package kr.co.tjoeun.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.UserBean;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		//네임스페이스.네임스페이스내에서사용할문구id
		String user_name = sqlSessionTemplate.selectOne("user.checkUserIdExist",user_id);
		return user_name;
		
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		
		sqlSessionTemplate.insert("user.addUserInfo", joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean tmpLoginJoinUserBean) {
		UserBean userBean = sqlSessionTemplate.selectOne("user.getLoginUserInfo",tmpLoginJoinUserBean);
		return userBean;
	}
}
