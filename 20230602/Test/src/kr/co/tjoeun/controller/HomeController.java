package kr.co.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.tjoeun.model.Test2Service;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("*.mvc")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// 요청한 주소(url)를 가져옴
		String url = request.getRequestURI();
		System.out.println(url);		
		// view 로 사용하는 jsp
		String viewName = null;			
				
		if(url.contains("main.mvc")) {
			// System.out.println("main 요청");			
			viewName = "main.jsp";
		}else if(url.contains("test1.mvc")) {
			// System.out.println("test1 요청");
			// parameter 추출하기
			String strNumber1 = request.getParameter("number1");
			String strNumber2 = request.getParameter("number2");
			
			int number1 = Integer.parseInt(strNumber1);
			int number2 = Integer.parseInt(strNumber2);
			
			int result = number1 + number2;
			
			// 메모리에 result 라는 이름(변수)으로 
			// 바로 위에 있는 result 변수에
			// 할당된 값을 올림  <-- test1.jsp 에서 이 값을 인식함
			request.setAttribute("result", result);			
			
			viewName = "test1.jsp";
			
			
		}else if(url.contains("test2.mvc")) {
			// System.out.println("test2 요청");	
			// System.out.println("test1 요청");
			// parameter 추출하기
			
			int result = Test2Service.minus(request);
			
			// 메모리에 result 라는 이름(변수)으로 
			// 바로 위에 있는 result 변수에
			// 할당된 값을 올림  <-- test2.jsp 에서 이 값을 인식함
			request.setAttribute("result", result);			
			
			viewName = "test2.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewName);
		dis.forward(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
