package kr.co.tjoeun.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.tjoeun.beans.BeansData;

@Controller
public class TestController {

	@GetMapping("/test1")//앞의String이 키 뒤에 String이 value 
	public String test1Get(@RequestParam Map<String,String> map) {
		//map으로 데이터를 받아옴
		//그 맵에서 num1이라는 키에 있는 값을 strNum1에 대입해줌
		String strNum1 = map.get("num1");
		String strNum2 = map.get("num2");
		System.out.printf("num1 : %s\n" , strNum1);
		System.out.printf("num2 : %s\n" , strNum2);
		
		//이름이 같은 number라는 데이터는 한개만 받아올수있음을 나타냄
		String strNumber = map.get("number");
		System.out.println("number : "+strNumber);
		
		return "result";
	}
	
	//같은이름의 데이터가 두개일경우 리스트로 받는법
	@GetMapping("/test2")//맵으로 받을땐 데이터의 변수명은 <String,~> 에 대입돼 맵명은 마음대로 기입가능하지만 
						//리스트로 받을땐 리스트명과 데이터의 변수명이 같아야한다
	public String test2Get(@RequestParam Map<String,String> map, @RequestParam List<String> number) {
		String mapNum1 = map.get("num1");
		String mapNum2 = map.get("num2");
		System.out.printf("num1 : %s\n" , mapNum1);
		System.out.printf("num2 : %s\n" , mapNum2);
		
		//이름이 같은 number라는 데이터는 한개만 받아올수있음을 나타냄
		String mapNumber = map.get("number");
		System.out.println("number : "+mapNumber);
		
		System.out.println("-------------------------");
		System.out.println(number);
		//같은이름의 데이터가 두개일경우 리스트로 받는법
		for(String strNumber : number) {
			System.out.println(strNumber);
		}
		
		return "result";
	}
		
		@GetMapping("/test3_1") //형변환을 하며 받아오기 
								//제네릭으로는 형변환이 불가능함을 알수있다
		public String test3Get(@RequestParam Map<String,Integer> map, @RequestParam List<Integer> number) {
			int mapNum1 = map.get("num1");
			int mapNum2 = map.get("num2");
			System.out.printf("num1 : %s\n" , mapNum1);
			System.out.printf("num2 : %s\n" , mapNum2);
			
			//이름이 같은 number라는 데이터는 한개만 받아올수있음을 나타냄
			int mapNumber = map.get("number");
			System.out.println("number : "+mapNumber);
			
			System.out.println("-------------------------");
			System.out.println(number);
			//같은이름의 데이터가 두개일경우 리스트로 받는법
			for(int intNumber : number) {
				System.out.println(intNumber);
			}
			
			return "result";
	}
		
			@GetMapping("/test3_2") //형변환을 하며 받아오기 
			public String test3_2Get(@RequestParam Map<String,String> map, @RequestParam List<String> number) {
			int mapNum1 = Integer.parseInt(map.get("num1"));
			int mapNum2 = Integer.parseInt(map.get("num2"));
			System.out.printf("num1 : %s\n" , mapNum1);
			System.out.printf("num2 : %s\n" , mapNum2);
			
			//이름이 같은 number라는 데이터는 한개만 받아올수있음을 나타냄
			int mapNumber = Integer.parseInt(map.get("number"));
			System.out.println("number : "+mapNumber);
			
			System.out.println("-------------------------");
			System.out.println(number);
			//같은이름의 데이터가 두개일경우 리스트로 받는법
			for(String intNumber : number) {
			System.out.println(intNumber);
			}
			
			return "result";
			}
			
		@GetMapping("/test4")
		public String test4Get(@ModelAttribute BeansData bean1) {
			System.out.println("num1 : " + bean1.getNum1());
			System.out.println("num2 : " + bean1.getNum2());
			System.out.println(bean1.getNumber().toString());
			for(int data : bean1.getNumber()) {
				System.out.println("number : "+data);
			}
			
			return "result";
		}
		@GetMapping("/test4_2")
		public String test4Get2(@ModelAttribute BeansData bean1
								,@ModelAttribute BeansData bean2
								,@ModelAttribute BeansData bean3) {
			System.out.println("--BeansData--");
			System.out.println("bean1.num1 : " + bean1.getNum1());
			System.out.println("bean1.num2 : " + bean1.getNum2());
			System.out.println(bean1.getNumber().toString());
			for(int data : bean1.getNumber()) {
				System.out.println("bean2.number : "+data);
			}
			
			
			System.out.println("--BeansData2--");
			System.out.println("bean2.num1 : " + bean2.getNum1());
			System.out.println("bean2.num2 : " + bean2.getNum2());
			for(int data : bean2.getNumber()) {
				System.out.println("bean2.number : "+data);
			}
			
			System.out.println("--BeansData3--");
			System.out.println("bean3.num1 : " + bean3.getNum1());
			System.out.println("bean3.num2 : " + bean3.getNum2());
			for(int data : bean3.getNumber()) {
				System.out.println("bean3.number : "+data);
			}
			
			return "result";
		}
		
		@GetMapping("/test5")
		public String test5Get(BeansData bean1,BeansData bean2,BeansData bean3) {
			System.out.println("--BeansData--");
			System.out.println("bean1.num1 : " + bean1.getNum1());
			System.out.println("bean1.num2 : " + bean1.getNum2());
			System.out.println(bean1.getNumber().toString());
			for(int data : bean1.getNumber()) {
			System.out.println("bean2.number : "+data);
			}
			
			
			System.out.println("--BeansData2--");
			System.out.println("bean2.num1 : " + bean2.getNum1());
			System.out.println("bean2.num2 : " + bean2.getNum2());
			for(int data : bean2.getNumber()) {
			System.out.println("bean2.number : "+data);
			}
			
			System.out.println("--BeansData3--");
			System.out.println("bean3.num1 : " + bean3.getNum1());
			System.out.println("bean3.num2 : " + bean3.getNum2());
			for(int data : bean3.getNumber()) {
			System.out.println("bean3.number : "+data);
			}
			
			//구 for문을 사용할때
			for(int i=0; i<bean3.getNumber().length;i++) {
				System.out.println(bean3.getNumber()[i]);
			}

			return "result";
		}
}
