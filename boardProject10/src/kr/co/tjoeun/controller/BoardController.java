package kr.co.tjoeun.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.BoardService;

// 여기서 나오는 RequestMapping은 접두사이다
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;

	@GetMapping("/main")
	public String boardMain(@RequestParam("board_info_idx") int board_info_idx,Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		//BoardService의 getBoardInfoName() 호출해서 게시판 이름 가져오기 - 카테고리
		String boardInfoName = boardService.getBoardInfoName(board_info_idx);
		model.addAttribute("boardInfoName", boardInfoName);
		//해당 카테고리의 글목록 갖고오기
		//List로 받아도됨
		ArrayList<ContentBean> contentList = boardService.getContentList(board_info_idx);
		
		//DB로 부터 받아온 게시글 리스트(ArrayList 객체)를 requestScope에 contentList 라는 이름으로 올린다
		model.addAttribute("contentList", contentList);
		return "board/main";
	}
	
	@GetMapping("/read")
	public String boardRead(@RequestParam("content_idx") int content_idx,
			@RequestParam("board_info_idx") int board_info_idx,Model model) {
		
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		ContentBean readContentBean = boardService.getContentInfo(content_idx);
		model.addAttribute("readContentBean", readContentBean);
		
		model.addAttribute("loginUserBean", loginUserBean);
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
			Model model) {
		model.addAttribute("board_info_idx", board_info_idx);
		model.addAttribute("content_idx", content_idx);
		modifyContentBean = boardService.getContentInfo(content_idx);
		modifyContentBean.setContent_idx(content_idx);
		modifyContentBean.setContent_board_idx(board_info_idx);
		model.addAttribute("modifyContentBean", modifyContentBean);

		
		return "board/modify";
	}
	
	@PostMapping("/modify_procedure")
	public String modifyProcedure(@Valid @ModelAttribute("modifyContentBean") ContentBean modifyContentBean, BindingResult result) {
		if(result.hasErrors()) {
			return "board/modify";
		}
		boardService.modifyContentInfo(modifyContentBean);
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
