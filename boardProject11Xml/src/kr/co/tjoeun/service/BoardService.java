package kr.co.tjoeun.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.PageBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.dao.BoardDAO;

@Service
@PropertySource("/WEB-INF/properties/option.properties")
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	//Session Scope에 있는 UserBean객체가 필요하다
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean; 
	
	//파일 업로드 경로
	@Value("${path.upload}")
	private String pathUpload;
	
	//페이지리스트값
	@Value("${page.listcnt}")
	private int pageListcnt;
	
	// 페이징 관련변수 : 페이지 버튼 개수
	@Value("${page.paginationcnt}")
	private int paginationCnt;
	
	//저장하는 메소드
	private String saveUploadFile(MultipartFile uploadFile) {
		String fileName = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
		try {
			uploadFile.transferTo(new File(pathUpload+"/"+fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public void addContentInfo(ContentBean writeContentBean) {
//		System.out.println(writeContentBean.getContent_subject());
//		System.out.println(writeContentBean.getContent_text());
//		System.out.println(writeContentBean.getUpload_file());
//		System.out.println(writeContentBean.getUpload_file().getOriginalFilename());
//		System.out.println(writeContentBean.getUpload_file().getName());
//		System.out.println(writeContentBean.getUpload_file().getSize());
		MultipartFile uploadFile = writeContentBean.getUpload_file();
		//파일이름
		if(uploadFile.getSize()>0) {
		String fileName = saveUploadFile(uploadFile);
		System.out.println("파일명" + fileName);
		writeContentBean.setContent_file(fileName);
		}
		//현재 로그인 상태인 사람이 작성자가 됨
		//작성자 인덱스번호(content_writer_idx)에
		//현재 로그인 상태인 사람(UserBean("loginUserBean"))의
		//user_idx를 할당한다

		writeContentBean.setContent_writer_idx(loginUserBean.getUser_idx());
		//Service에서 DAO(Repository) 에 있는 addContentInfo() 호출하기
		boardDAO.addContentInfo(writeContentBean);
		
	}
	
	public String getBoardInfoName(int board_info_idx) {
		return boardDAO.getBoardInfoName(board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx,int page){
		
		//페이징처리
		/*
		 * page		pagination number(이전과 다음사이의 숫자)
		 * 1	>	0 (start) <- (page -1) * pageListcnt
		 * 2	>	10
		 * 3	>	20
		*/
		int start = (page -1) * pageListcnt ;
		RowBounds rowBounds = new RowBounds(start , pageListcnt);
		
		return boardDAO.getContentList(board_info_idx,rowBounds);
	}
	public ContentBean getContentInfo(int content_idx) {
		return boardDAO.getContentInfo(content_idx);
	}
	//게시글 업데이트
	public void modifyContentInfo(ContentBean modifyContentBean) {
		MultipartFile upload_file = modifyContentBean.getUpload_file();
		if(upload_file.getSize()>0) {
			String file_name = saveUploadFile(upload_file);
			modifyContentBean.setContent_file(file_name);
		}
		boardDAO.modifyContentInfo(modifyContentBean);
	}
	
	//게시글 삭제
	public void deleteContentInfo(int content_idx) {
		boardDAO.deleteContentInfo(content_idx);
	}
	
	//게시글 전체개수
	//Controller로 부터 매개변수의 값을 받아와야함
	//pageListcnt : 페이지당 게시글의 개수
	//  paginationCnt : 페이지 버튼 개수
	public PageBean getContentCnt(int content_board_idx, int currentPage) {
		//전체페이지 개수
		int contentCnt = boardDAO.getContentCnt(content_board_idx);
		PageBean pageBean = new PageBean(contentCnt,currentPage,pageListcnt,paginationCnt);
		return pageBean;
	}
}
