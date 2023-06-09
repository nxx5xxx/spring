package kr.co.tjoeun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TestController {
	@GetMapping("/test1")
	public String test1(HttpServletRequest request) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		System.out.println(number1);
		System.out.println(number2);
		//하나받을땐 getParameter지만 여러개받을땐 ParameterValues
		String numbers[] = request.getParameterValues("numbers");
		
		int index = 0;
		for(String data : numbers) {
			System.out.println("numbers["+index+"]"+data.toString());
			index +=1 ;
		}
		
		return "result";
	}
	
	@PostMapping("/test2")
	public String test2(HttpServletRequest request) {
		System.out.println(request.getParameter("number1"));
		System.out.println(request.getParameter("number2"));
		//하나받을땐 getParameter지만 여러개받을땐 ParameterValues
		String numbers[] = request.getParameterValues("numbers");
		
		int index = 0;
		if(numbers !=null) {
			for(String data : numbers) {
				System.out.println("numbers["+index+"]"+data.toString());
				index +=1 ;
			}
		}
		
		return "result";
	}
	
	@GetMapping("/test3")
	public String test3(WebRequest request) {
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		System.out.println(number1);
		System.out.println(number2);
		//하나받을땐 getParameter지만 여러개받을땐 ParameterValues
		String numbers[] = request.getParameterValues("numbers");
		
		int index = 0;
		for(String data : numbers) {
			System.out.println("numbers["+index+"]"+data.toString());
			index +=1 ;
		}
		
		return "result";
	}
	
	@GetMapping("/test4/{num1}/{num2}/{num3}")
	public String test4(@PathVariable String num1,@PathVariable String num2,@PathVariable String num3) {
		System.out.println("num1 : " +num1);
		System.out.println("num2 : " +num2);
		System.out.println("num3 : " +num3);
		return "result";
	}
	
	@GetMapping("/test5/{num1}/{num2}/{num3}/{num4}")
	public String test5(@PathVariable int num1,@PathVariable int num2,@PathVariable int num3,@PathVariable int num4) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num3 : "+num3);
		System.out.println("num4 : "+num4);
		int sum = num1+num2+num3+num4;
		System.out.println("합계 : " + sum);
		return "result";
	}
	
	@GetMapping("/test6")
	public String test6(@RequestParam int num1,@RequestParam int num2, @RequestParam int[] nums) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		int sum  = num1+num2+nums[0]+nums[1];
		for(Integer data : nums) {
			System.out.println("nums : "+data);
		}
		System.out.println("합계 : "+sum);
		return "result";
	}
	
	//넘어오는이름과 파라메터 이름을 다르게 하고싶을때
	@GetMapping("/test7")
	public String test7(@RequestParam(value="num1") int number1,@RequestParam(value="num2") int number2, @RequestParam(value="nums") int numbers[]) {
		System.out.println("number1 : "+number1);
		System.out.println("number2 : "+number2);
		int sum  = number1+number2+numbers[0]+numbers[1];
		for(Integer data : numbers) {
			System.out.println("nums : "+data);
		}
		System.out.println("합계 : "+sum);
		return "result";
	}
	
	// 요청에서 넘긴 값을 받지않을때는 문제가 없음
	@GetMapping("/test8")
	public String test8(@RequestParam int num1, @RequestParam int[] nums) {
		System.out.println("num1 : "+num1);
		int sum  = num1+nums[0]+nums[1];
		for(Integer data : nums) {
			System.out.println("nums : "+data);
		}
		System.out.println("합계 : "+sum);
		return "result";
	}
	
	// 넘어오지 않은 값 (num3를 받는경우)
	@GetMapping("/test9")
	public String test9(@RequestParam int num1,@RequestParam int num2,@RequestParam int num3, @RequestParam int[] nums) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num3 : "+num3);
		int sum  = num1+num2+num3+nums[0]+nums[1];
		for(Integer data : nums) {
			System.out.println("nums : "+data);
		}
		System.out.println("합계 : "+sum);
		return "result";
	}
	
	// required false로 처리하는경우 넘어오지 않은 값 (num3를 받는경우)을 받아  null로 ㄴㅏ타내줌
	// @RequestParam(required=false) int num3
	// ㄴ 일단 null 값으로 받은 다음 int type으로 형변환 하려고 함 <-- 오류발생
	// @RequestParam(required=false) String num4 <--null을 주입받음
	@GetMapping("/test10")
	public String test10(@RequestParam int num1,@RequestParam int num2,/*@RequestParam(required=false) int num3,*/@RequestParam(required=false) String num4,@RequestParam int[] nums) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		//System.out.println("num3 : "+num3);
		System.out.println("num4 : "+num4);
		
		for(Integer data : nums) {
			System.out.println("nums : "+data);
		}
		/*
		 * int sum = num1+num2+num3+nums[0]+nums[1]; System.out.println("합계 : "+sum);
		 */
		return "result";
	}
	
	//defaultValue
	@GetMapping("/test11")
	public String test11(@RequestParam int num1,@RequestParam int num2,@RequestParam(defaultValue="0") int num3,@RequestParam int[] nums) {
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num3 : "+num3);
		
		for(Integer data : nums) {
			System.out.println("nums : "+data);
		}

		int sum = num1+num2+num3+nums[0]+nums[1]; 
		System.out.println("합계 : "+sum);

		return "result";
	}
	
	@RequestMapping(value="/test12", method= {RequestMethod.GET,RequestMethod.POST})
	public void test12(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String aa = request.getParameter("aa");
		String bb = request.getParameter("bb");
		request.setAttribute("aa", aa);
		request.setAttribute("bb", bb);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
		view.forward(request, response);
	}
	
}
