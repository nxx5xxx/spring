package kr.co.tjoeun.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.tjoeun.beans.TestBean1;
import kr.co.tjoeun.beans.TestBean2;
import kr.co.tjoeun.beans.TestBean3;
import kr.co.tjoeun.beans.TestBean4;

@Controller
public class TestController {
	
	//Lazy는 서버가 올라갔을때 객체를생성하는게 아닌 요청을 받을때 생성해라 라는 의미
	/*
	 * xml설정 방식으로 했을때
	 * scope="request" 인 경우에는
	 * @Lazy를 사용해야 요청이 들어올 때만 bean 객체가 주입된다
	*/
	@Autowired
	@Lazy
	TestBean1 testBean1;
	//RootAppContext에서 new TestBean1()을 호출해주는것
	//Autowired를 하면
	//testBean1이라는 객체의 타입을 바로 정의해줌
	//안썻을때는 TestBean1 testBean1 = new TestBean1(); 해야함
	//이것을 타입으로 주입받는방식이라한다
	//생성자로 주입받는방식과 타입으로 주입받는 방식이있음
	
	@Resource(name="testBean2")
	@Lazy
	TestBean2 testBean2;
	
	
	//RootAppcontext에서 할당하지않고 클래스파일에서 한것이다	
	@Autowired
	@Lazy
	TestBean3 testBean3;
	
	
	//컴포넌트에 밸류에 할당한 문자열이랑 name에 있는 문자열이랑 맞아야 할당된다 
	//RootAppcontext에서 할당하지않고 클래스파일에서 한것이다
	@Resource(name="testBean4")
	@Lazy
	TestBean4 testBean4;
	
	
	//RootAppontext에서 요청한다는것이 여기서보이는 String testBean1()이것을 뜻함
	@GetMapping("testBean1")
	public String testBean1() {
		testBean1.setData1("자바웹");//Autowired를 했기때문에 set,get등 바로바로 사용이 가능한것이다
		testBean1.setData2("프레임워크");
		
		testBean2.setData3("파이썬");//Resource를 했기때문에 set,get등 바로바로 사용이 가능한것이다
		testBean2.setData4("데이터분석");	
		
		testBean3.setData5("서블릿");
		testBean3.setData6("JSP");
		
		testBean4.setData7("프론트");
		testBean4.setData8("자바스크립트");
		
		//forwarding : 새로운 요청이 발생하지 않음
		return "forward:/result1";
	}
	
	@GetMapping("/result1")
	public String result1(Model model) {
		System.out.println("testBean1.data1 : "+testBean1.getData1());
		System.out.println("testBean1.data2 : "+testBean1.getData2());

		System.out.println("testBean2.data3 : "+testBean2.getData3());
		System.out.println("testBean2.data4 : "+testBean2.getData4());
		
		System.out.println("testBean3.data5 : "+testBean3.getData5());
		System.out.println("testBean3.data6 : "+testBean3.getData6());
		
		System.out.println("testBean4.data7 : "+testBean4.getData7());
		System.out.println("testBean4.data8 : "+testBean4.getData8());
		
		model.addAttribute("testBean1", testBean1);
		model.addAttribute("testBean3", testBean3);
		model.addAttribute("testBean4", testBean4);
		//model.addAttribute("testBean2", testBean2); -- xml방식에서 byName은 이걸 생략해줘도된다
		//생략안할시 javax.servlet.ServletException: java.lang.StackOverflowError 가뜰것이다
		/*
		 * xml방식으로 설정할 때에 한해서
		 * root-context.xml에서
		 * 		<bean class="kr.co.tjoeun.beans.TestBean2" scope="request" id="testBean2"/>
		 * 에서 scope="request" id="testBean2" 이 두 설정을 같이 하면
		 * 자동으로 주입도 되고 , request scope 로딩도 자동으로 된다
		 * 
		 * 
		 */
		
		return "result1";
	}
}
