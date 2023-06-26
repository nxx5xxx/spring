package kr.co.tjoeun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.tjoeun.bean.BoardInfoBean;

public interface TopMenuMapper {
	
	@Select("select * from board_info_table order by board_info_idx asc")
	List<BoardInfoBean> getTopMenuList();
}
