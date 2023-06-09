package kr.co.tjoeun.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tjoeun.beans.TestBean1;

@Controller
public class TestController {
	
	//HttpServletRequest를 주입받음
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		//HttpServletRequest의 저장객체는 Model이아닌 req~.setAttribute를 사용
		//setAttribute : data를 requestScope라는 메모리 영역으로 저장함
		request.setAttribute("data1", "더조은 아카데미");
		
		//redirect : browser에게 server쪽으로  어떤 요청(request)을 하라고 명령함
		return "redirect:/result1";
	}
	@GetMapping("/test1_1")
	public String test1_1(HttpServletRequest request) {
		//HttpServletRequest의 저장객체는 Model이아닌 req~.setAttribute를 사용
		//setAttribute : data를 requestScope라는 메모리 영역으로 저장함
		request.setAttribute("data1", "더조은 아카데미");
		
		//forward : browser가 흐름이 변경되는것을 인식하지 못하고
		//   	  : 주소가 변경되지 않는다(test1_1 이라는 주소가 유지됨)
		//		  : HttpServletRequest는 소멸되지 않는다(메모리 상에서 유지된다)
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(HttpServletRequest request) {
		//getAttribute : data를 requestScope라는 메모리 영역으로 가져옴
		//하지만 redirect로 전송한거라 request데이터가 소멸되어서 null값으로 받아옴
		String data1 =(String) request.getAttribute("data1"); //오브젝트 형태로 올라오기때문에 스트링으로 형변환해줘야함
		System.out.printf("data1 : %s\n",data1);
		return "result1";
	}
	
	
	// Model 객체를 주입받음
	@GetMapping("/test2")
	public String test2(Model model) {
		//	model.addAttribute("data2", "자바웹") 를 사용해서 data를 메모리에 올리면
		//  model객체에 올라가는게 아니라 HttpServletRequest객체에 저장되는것이다
		//  EL태그는 request객체에서 뽑아오는것이라 EL로는 뽑아올 수 있지만
		// 아래 model.getAttribute의 값은 null이 되는것을 확인 할 수 있다
		model.addAttribute("data2", "자바웹");
		return "forward:/result2";
	}
	
	@GetMapping("/result2")
	public String result2(Model model,HttpServletRequest request) {
		String data2 = (String)model.getAttribute("data2");
		System.out.printf("data2 : %s\n" ,data2);
		String data2_req = (String)request.getAttribute("data2");
		System.out.println("data2 : "+data2_req);
		return "result2";
	}
	
	@GetMapping("/test3")
	public ModelAndView test3(ModelAndView mv) {
		// ModelAndView 객체를 사용하여 data를 메모리에 올리면
		// requestScope 영역에서 HttpServletRequest 객체에 저장됨
		mv.addObject("data3", "스프링프로젝트");
		mv.setViewName("forward:/result3");
		
		return mv;
	}
	
	@GetMapping("/result3")
	public String result3(HttpServletRequest request) {
		String data3 = (String)request.getAttribute("data3");
		System.out.println("data3 : "+ data3);
		return "result3";
	}
	
	@GetMapping("/testBean1")
	public String testBean1(Model model) {
		TestBean1 bean1 = new TestBean1();
		bean1.setData1("스프링");
		bean1.setData2("웹개발");
		
		model.addAttribute("bean1", bean1);
		
		return "forward:/result4";
	}
	
	@GetMapping("/result4")
	public String result4(HttpServletRequest request) {
		TestBean1 bean1 = (TestBean1)request.getAttribute("bean1");//Object타입으로 받아지므로 TestBean1으로 형변환
		System.out.println("bean1.data1 : "+bean1.getData1());
		System.out.println("bean1.data2 : "+bean1.getData2());
		return "result4";
	}
	
	// 객체 자체를 주입받는것
	//이렇게 하면 메모리에 모델어트리뷰트 어노테이션을 넣지않으면 testBean1으로 메모리에 올라간다
	@GetMapping("/testBean1_1")
	public String testBean1_1(@ModelAttribute("bean1") TestBean1 bean1) {
		bean1.setData1("자바개발자");
		bean1.setData2("파이썬개발자");


		return "testBean1_1";
	}
	@GetMapping("/testBean1_2")
	public String testBean1_2(@ModelAttribute("bean1") TestBean1 bean1) {
		bean1.setData1("자바개발자");
		bean1.setData2("파이썬개발자");
		
		
		return "forward:/result5";
	}
	
	@GetMapping("/result5")
	public String result5(HttpServletRequest request) {
		TestBean1 bean1 = (TestBean1)request.getAttribute("bean1"); 
		System.out.println("bean1.getData1 : " +bean1.getData1());
		System.out.println("bean1.getData2 : " +bean1.getData2());
		return "result5";
	}
}
