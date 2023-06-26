package kr.co.tjoeun.service;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.tjoeun.bean.ContentBean;
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
}
