package kr.co.tjoeun.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.ContentBean;
import kr.co.tjoeun.bean.UserBean;
import kr.co.tjoeun.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;

	//xml방식은 자동주입돼서 이거 안해도된다
//	public CheckWriterInterceptor(UserBean loginUserBean,BoardService boardService) {
//		this.loginUserBean = loginUserBean;
//		this.boardService = boardService;
//	}
//	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int content_idx = Integer.parseInt(request.getParameter("content_idx"));
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/board/not_writer");
			//리턴이 false일경우 쭈우우욱 진행안함
			return false;
		}
		return true;
	}
	
}
