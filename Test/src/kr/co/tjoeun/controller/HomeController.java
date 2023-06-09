package kr.co.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tjoeun.model.Test2Service;


@WebServlet("*.mvc") //URL맵핑 - *.mvc는 .mvc가 들어가는 모든것
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		System.out.println("HomeController");
		
		//요청한 주소 url가져오기
		String uri = request.getRequestURI();
		
		//view 로 사용하는 jsp
		String viewName = null;
		
		
		//contains 포함하다
		if(uri.contains("main.mvc")) {
			System.out.println("main 요청");
			viewName = "main.jsp";
		}else if(uri.contains("test1.mvc")) {
			System.out.println("test1 요청");
			//데이터가 전송돼서 받는부분을 파라미터라고 한다 -- 파라미터를 추출한다고 표현함
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			//파라미터는 항상 스트링값으로 받아와진다 
			
			//메모리에 id라는 이름(변수)로 위에잇는 id변수에 할당된 값을 올림  <- test1.jsp에서 인식함
			request.setAttribute("id", id);
			request.setAttribute("pw", pw);
			viewName = "test1.jsp";
		}else if(uri.contains("test2.mvc")) {
			String strNumber3 = request.getParameter("number3");
			String strNumber4 = request.getParameter("number4");
			if(strNumber3 != null) {
			int result = Integer.parseInt(strNumber3)+Integer.parseInt(strNumber4);
			request.setAttribute("result", result);
			}
			
			int result2 = Test2Service.minus(request);
			request.setAttribute("result2", result2);
			
			System.out.println("test2요청");
			viewName = "test2.jsp";
		}
		
		System.out.println(uri);
		
		RequestDispatcher view  = request.getRequestDispatcher(viewName);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
