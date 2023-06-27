package kr.co.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.BoardInfoBean;

@Repository
public class TopMenuDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	//카테고리 리스트
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList= sqlSessionTemplate.selectList("topmenu.getTopMenuList");
		return topMenuList;
	}
}
