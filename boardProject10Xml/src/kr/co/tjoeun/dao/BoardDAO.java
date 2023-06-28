package kr.co.tjoeun.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.tjoeun.bean.ContentBean;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void addContentInfo(ContentBean writeContentBean) {
		sqlSessionTemplate.insert("board.addContentInfo", writeContentBean);
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return sqlSessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx){
		return sqlSessionTemplate.selectList("board.getContentList" , board_info_idx);
	}
	public ContentBean getContentInfo(int content_idx) {
		return sqlSessionTemplate.selectOne("board.getContentInfo",content_idx);
	}
	
	//게시글 업데이트
	public void modifyContentInfo(ContentBean modifyContentBean) {
		sqlSessionTemplate.update("board.modifyContentInfo", modifyContentBean);
	}
	
	//게시글 삭제
	public void deleteContentInfo(int content_idx) {
		sqlSessionTemplate.delete("board.deleteContentInfo", content_idx);
	}
}
