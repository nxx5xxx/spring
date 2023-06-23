package kr.co.tjoeun.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.tjoeun.bean.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{
	
	@Resource(name="loginUserBean")
	@Lazy
	private UserBean loginUserBean;

	//XML방식에선 자동주입받았기때문에 생성자할당 필요가 없다
//	public CheckLoginInterceptor(UserBean loginUserBean) {
//		this.loginUserBean = loginUserBean;
//	}
	
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
