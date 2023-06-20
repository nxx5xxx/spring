package kr.co.tjoeun.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.BoardInfoBean;
import kr.co.tjoeun.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	/*
	 * interceptor 에서는 Bean을 자동으로 주입 받지 못한다
	 * 생성자의 parameter 에서 TopMenuService topMenuService 객체를 주입받아서
	 * 멤버번수로 선언한 TopMenuService topMenuService 에 전달함
	*/
	
//	Autowired
//	private TopMenuService topMenuService;
	  private TopMenuService topMenuService;
	  
	  public TopMenuInterceptor(TopMenuService topMenuService) {
		this.topMenuService = topMenuService;
	  }
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		//return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}
	
	
}
