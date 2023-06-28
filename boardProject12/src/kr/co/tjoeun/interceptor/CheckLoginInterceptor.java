package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	//자바 방식에서는 interceptor 에서 bean이 자동 주입이 안된다
	// ServletAppContext에서 bean을 자동 주입 받아서
	// ServletAppContext에서 CheckLoginInterceptor 의 객체를 생성할때
	// CheckLoginInterceptor 생성자의 argument 로 넣어준다
	private UserBean loginUserBean;
	
	public CheckLoginInterceptor(UserBean loginUserBean) {
		this.loginUserBean = loginUserBean;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그아웃한 상태라면
		if(loginUserBean.isUserLogin()==false){
			//ContenxtPath를 얻어옴
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");
			return false;
		}
		// 로그인이 된 상태라면
		return true;
	}
}
