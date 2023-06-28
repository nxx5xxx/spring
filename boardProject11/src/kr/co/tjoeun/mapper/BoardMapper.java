package kr.co.tjoeun.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import kr.co.tjoeun.bean.ContentBean;

public interface BoardMapper {
	
	//현재 sequence값 갖고오기
	//여기서 content_seq.nextval 는 db에 넣을뿐이지 content_idx 들어가는게 아니라 서 이것을하면
	// writeContentBean이 있는곳에 content_idx 가 들어간다
	//그래서 values에 #{content_idx}를하면  writeContentBean에 넣은 SELECT content_seq.nextval FROM DUAL 을 사용할수 있다
	@SelectKey(statement = "SELECT content_seq.nextval FROM DUAL",
			keyProperty="content_idx",before = true, resultType=int.class)
	@Insert("insert into content_table(content_idx, content_subject ,content_text ,content_file ,content_writer_idx,"
			+ "content_board_idx ,content_date) values(#{content_idx},#{content_subject},#{content_text},"
			+ "#{content_file, jdbcType=VARCHAR},#{content_writer_idx},#{content_board_idx},default)")
	void addContentInfo(ContentBean writeContentBean);

	//게시판 index로 게시판 이름 갖고오기(조회하기) - 카테고리
	@Select("select board_info_name from board_info_table where board_info_idx=#{board_info_idx}")
	String getBoardInfoName(int board_info_idx);
	
	//해당 카테고리 게시글 목록 갖고오기
	@Select("select content_idx,content_subject,user_name as content_writer_name,"
			+ "TO_CHAR(content_date,'YYYY-MM-DD') as content_date from content_table,"
			+ "user_table where content_writer_idx = user_idx and content_board_idx = #{content_board_idx} "
			+ "order by content_idx desc")
	ArrayList<ContentBean> getContentList(int board_info_idx,RowBounds rowBounds);

	// 상세페이지에 출력할 데이터 갖고오기
	// 작성자(이름)user_name, 작성날자content_date, 제목content_subject, 내용 content_text, 첨부이미지content_file
	@Select("select user_name as content_writer_name,TO_CHAR(content_date,'YYYY-MM-DD') as content_date,"
			+ "content_subject,content_text,content_file,content_writer_idx from content_table,"
			+ "user_table where content_writer_idx = user_idx and content_idx = #{content_idx}")
	ContentBean getContentInfo(int content_idx);
	
	//상세페이지(게시판 글 수정)
	//여기서 jdbcType=VARCHAR를 넣는것은 null값일경우 오류를 최소화 하기위해 넣은것이다
	@Update("update content_table set content_subject = #{content_subject} ,"
			+ "content_text = #{content_text}, content_file = #{content_file, jdbcType=VARCHAR} where content_idx=#{content_idx}")
	void modifyContentInfo(ContentBean modifyContentBean);
	
	//게시글 삭제하기
	@Delete("delete from content_table where content_idx = #{content_idx}")
	void deleteContentInfo(int content_idx);
	
	//게시글 전체 개수 갖고오기
	@Select("select count(*) from content_table where content_board_idx=#{content_board_idx}")
	int getContentCnt(int content_board_idx);
}

