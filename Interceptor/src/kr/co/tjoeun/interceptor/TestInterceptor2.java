package kr.co.tjoeun.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor2 extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor2 - preHandle");
		System.out.println("	Controller의 메소드가 호출되기 전에 자동으로 호출되는 메소드\r\n" + 
				"	이 메소드가 false를 반환하면 code의 흐름이 중단된다");
		return true;//HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TestInterceptor2 - postHandle");
		System.out.println("	Controller의 메소드의 수행이 완료되고\r\n" + 
				"	View 처리를 수행하기 전에 자동으로 호출되는 메소드");
		//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TestInterceptor2 - afterCompletion");
		System.out.println("	View 처리까지 완료되고 응답결과(response)가\r\n" + 
				"	Client의 browser로 전달되기 전에 자동으로 호출되는 메소드	");
		//HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	

}
