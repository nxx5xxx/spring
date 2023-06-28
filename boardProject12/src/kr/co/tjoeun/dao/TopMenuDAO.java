package kr.co.tjoeun.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.BoardInfoBean;
import kr.co.tjoeun.mapper.TopMenuMapper;

@Repository
public class TopMenuDAO {
	
	@Autowired
	private TopMenuMapper topMenuMapper;// = new TopMenuMapper();

	
	//카테고리 리스트
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList= topMenuMapper.getTopMenuList();
		return topMenuList;
	}
}
