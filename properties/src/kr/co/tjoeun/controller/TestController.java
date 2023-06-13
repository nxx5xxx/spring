package kr.co.tjoeun.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// \\는 /와 같은 의미이다
@Controller
//@PropertySources({
//@PropertySource("/WEB-INF/properties/data1.properties"),
//@PropertySource("/WEB-INF/properties/data2.properties")})
//	둘다 같은방식
//@PropertySource("/WEB-INF/properties/data1.properties")
//@PropertySource("/WEB-INF/properties/data2.properties")
// 또 다른방식
@PropertySource(value= {
		"/WEB-INF/properties/data1.properties",
		"/WEB-INF/properties/data2.properties"
		})
public class TestController {
	
	//WEB-INF\properties\data1.properties속에 있는 값 사용
	@Value("${student1.number1}")
	private int number1; //프로퍼티스에서 갖고와서 바로 할당된다

	@Value("${student1.name1}")
	private String name1;//변수명은 value이름과 같지 않아도 된다

	@Value("${student2.number2}")
	private int number2; 

	@Value("${student2.name2}")
	private String name2;
	
	@Value("${student3.number3}")
	private int number3; 

	@Value("${student3.name3}")
	private String name3;
	
	@Value("${student4.number4}")
	private int number4; 

	@Value("${student4.name4}")
	private String name4;
	
	@GetMapping("/test1")
	public String test1() {
		System.out.printf("student1.number1 : %d\n", number1);
		System.out.printf("student1.name1 : %s\n", name1);
		System.out.printf("student2.number2 : %d\n", number2);
		System.out.printf("student2.name2 : %s\n", name2);
		System.out.printf("student1.number3 : %d\n", number3);
		System.out.printf("student1.name3 : %s\n", name3);
		System.out.printf("student2.number4 : %d\n", number4);
		System.out.printf("student2.name4 : %s\n", name4);
		
		return "test1";
	}
}
