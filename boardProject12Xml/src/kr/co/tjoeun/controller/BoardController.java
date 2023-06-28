package kr.co.tjoeun.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.PageBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.BoardService;

// 여기서 나오는 RequestMapping은 접두사이다
@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;

	@GetMapping("/main")
	public String boardMain(@RequestParam("board_info_idx") int board_info_idx,Model model,
			@RequestParam(value="page", defaultValue="1") int page) {
		model.addAttribute("board_info_idx", board_info_idx);
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);
		model.addAttribute("boardInfoName", boardInfoName);
		
		//List<ContentBean> contentList = boardService.getContentList(board_info_idx);
		//받아온대로 List로 ㅎㅐ도 실행된다 아래건 어레이리스트로 할시에도 작동하나 실험해본것
		ArrayList<ContentBean> contentList = new ArrayList<>(boardService.getContentList(board_info_idx,page));
		//DB로 부터 받아온 게시글 리스트(ArrayList 객체)를 requestScope에 contentList 라는 이름으로 올린다
		model.addAttribute("contentList", contentList);
		
		PageBean pageBean = boardService.getContentCnt(board_info_idx, page);
		model.addAttribute("pageBean", pageBean);
		
		model.addAttribute("page", page);
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead(@RequestParam("content_idx") int content_idx,
			@RequestParam("board_info_idx") int board_info_idx,Model model,
			@RequestParam("page") int page) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		ContentBean readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean", readContentBean);
		model.addAttribute("loginUserBean", loginUserBean);

		model.addAttribute("page", page);
		return "board/read";
	}
	@GetMapping("/write")
	public String boardWrite(@ModelAttribute("writeContentBean") ContentBean writeContentBean,
							@RequestParam("board_info_idx") int board_info_idx) {
		writeContentBean.setContent_board_idx(board_info_idx);
		return "board/write";
	}
	
	@PostMapping("/write_procedure")
	public String write_procedure(@Valid @ModelAttribute("writeContentBean") ContentBean writeContentBean,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return  "board/write";
		}
		boardService.addContentInfo(writeContentBean);
		return "board/write_success";
	}
	
	@GetMapping("/modify")
	public String boardModify(@RequestParam("content_idx") int content_idx,
			@RequestParam("board_info_idx") int board_info_idx,
			@ModelAttribute("modifyContentBean") ContentBean modifyContentBean,
			@RequestParam("page") int page,
			Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		
	    ContentBean tmpContentBean = boardService.getContentInfo(content_idx);
		
		modifyContentBean.setContent_writer_name(tmpContentBean.getContent_writer_name());
		modifyContentBean.setContent_date(tmpContentBean.getContent_date());
		modifyContentBean.setContent_subject(tmpContentBean.getContent_subject());
		modifyContentBean.setContent_text(tmpContentBean.getContent_text());
		modifyContentBean.setContent_file(tmpContentBean.getContent_file());
		modifyContentBean.setContent_writer_idx(tmpContentBean.getContent_writer_idx());
		modifyContentBean.setContent_board_idx(board_info_idx);
		modifyContentBean.setContent_idx(content_idx);

		model.addAttribute("page", page);
		
		return "board/modify";
	}
	
	@PostMapping("/modify_procedure")
	public String modifyProcedure(@Valid @ModelAttribute("modifyContentBean") ContentBean modifyContentBean, BindingResult result,@RequestParam("page") int page,Model model) {
		if(result.hasErrors()) {
			return "board/modify";
		}
		boardService.modifyContentInfo(modifyContentBean);
		
		model.addAttribute("page", page);
		return "board/modify_success";
	}
	
	@GetMapping("/delete")
	public String boardDelte(@RequestParam("content_idx") int content_idx,@RequestParam("board_info_idx") int board_info_idx,Model model) {
		boardService.deleteContentInfo(content_idx);
		model.addAttribute("board_info_idx", board_info_idx);
		return "board/delete";
	}
	@GetMapping("/not_writer")
	public String notWriter() {
		return "board/not_writer";
	}
}
