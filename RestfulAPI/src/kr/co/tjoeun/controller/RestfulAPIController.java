package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.tjoeun.beans.TestBean;

@RestController
public class RestfulAPIController {

	@GetMapping("/rest_controller")
	public ResponseEntity<ArrayList<TestBean>> rest_controller() {
		TestBean testBean1 = new TestBean("강아지",123,3.14,false);
		TestBean testBean2 = new TestBean("고양이",456,6.25,true);
		TestBean testBean3 = new TestBean("사자",789,8.15,false);
		
		ArrayList<TestBean> list1 = new ArrayList<>();
		list1.add(testBean1);
		list1.add(testBean2);
		list1.add(testBean3);
		
		//리스트와 http상태코드(ex: http500 404error 등등)
		// 결과데이터, 상태코드 라고 보면됨
		ResponseEntity<ArrayList<TestBean>> entity = new ResponseEntity<>(list1,HttpStatus.OK );
		
		return entity;
	}
	
	@GetMapping("/rest_controller2")
	public String rest_controller2() {
		return "<h2 style='color:red'>rest_controller1234<h2>";
	}
}
