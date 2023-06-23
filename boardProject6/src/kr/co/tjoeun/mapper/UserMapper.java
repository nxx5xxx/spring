package kr.co.tjoeun.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.tjoeun.bean.UserBean;

public interface UserMapper {
	@Select("select user_name from user_table where user_id = #{user_id}")
	String checkUserIdExist(String user_id);
	// ${user_id} 이것때문에 () 안에 집어넣어준것
	
	@Insert("insert into user_table values(user_seq.nextval,#{user_name},#{user_id},#{user_pw})")
	void addUserInfo(UserBean joinUserBean);
	
	//로그인
	@Select("select * from user_table where user_id = #{user_id} and user_pw =#{user_pw}")
	UserBean getLoginUserInfo(UserBean tmpLoginJoinUserBean);
	
	//마이페이지수정
	@Select("select user_id, user_name from user_table where user_idx = #{user_idx}")
	UserBean getModifyUserInfo(int user_idx);
}
