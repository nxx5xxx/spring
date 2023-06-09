package kr.co.tjoeun.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.tjoeun.beans.BeanData;
import kr.co.tjoeun.beans.BeanKeyValue;

@Controller
public class TestController {
	
	@GetMapping("/test1")
	public String test1(BeanData bean, Model model) {
		bean.setData1("더좋은학원");
		bean.setData2("자바웹개발과정");
		bean.setData3("풀스택개발자과정");
		bean.setData4("자바웹개발자과정");//bean.setData4("item3"); 키값 또는 밸류값 무엇을적어도 알아서 path에서 잡아준다
		
		String[] dataArray1 = {"데이터분석","풀스택개발자과정","자바웹개발과정"};
		model.addAttribute("dataArray1", dataArray1);
		
		ArrayList<String> dataList1 = new ArrayList<String>();
		dataList1.add("데이터분석과정");
		dataList1.add("풀스택개발자과정");
		dataList1.add("자바웹개발자과정");
		model.addAttribute("dataList1",dataList1);
		
		BeanKeyValue key_bean1 = new BeanKeyValue();
		BeanKeyValue key_bean2 = new BeanKeyValue();
		BeanKeyValue key_bean3 = new BeanKeyValue();
		BeanKeyValue key_bean4 = new BeanKeyValue();
		BeanKeyValue key_bean5 = new BeanKeyValue();
		
		key_bean1.setKey("item1");
		key_bean1.setValue("데이터분석");
		
		key_bean2.setKey("item2");
		key_bean2.setValue("풀스택개발자과정");
		
		key_bean3.setKey("item3");
		key_bean3.setValue("자바웹개발과정");
		
		key_bean4.setKey("item4");
		key_bean4.setValue("C언어과정");
		
		key_bean5.setKey("item5");
		key_bean5.setValue("Spring과정");
		
		ArrayList<BeanKeyValue> dataList2 = new ArrayList<>();
		dataList2.add(key_bean1);
		dataList2.add(key_bean2);
		dataList2.add(key_bean3);
		model.addAttribute("dataList2", dataList2);
		
		//ㅊㅔ크박스
		String[] checkList = {"C언어과정","Spring과정"};
		bean.setData5(checkList);
		
		bean.setData7(checkList);
		bean.setData8(checkList);
		
		
		//checkboxes에 들어가는 것
		bean.setData6(checkList);
		String[] dataArray2 = {"데이터분석","풀스택개발자과정","자바웹개발과정","C언어과정","Spring과정"};
		model.addAttribute("dataArray2", dataArray2);
		
		//data7
		ArrayList<String> dataList3 = new ArrayList<String>();
		dataList3.add("데이터분석과정");
		dataList3.add("C언어과정");
		dataList3.add("자바웹개발과정");
		dataList3.add("Spring과정");
		model.addAttribute("dataList3",dataList3);
		
		//data8
		
		ArrayList<BeanKeyValue> dataList4 = new ArrayList<>();
		dataList4.add(key_bean1);
		dataList4.add(key_bean2);
		dataList4.add(key_bean3);
		dataList4.add(key_bean4);
		dataList4.add(key_bean5);
		model.addAttribute("dataList4", dataList4);
		
		//data9
		bean.setData9("자바웹개발과정");



		//data10
		bean.setData10("자바웹개발과정");
		String[] dataArray3 = {"데이터분석","풀스택개발자과정","자바웹개발과정"};
		model.addAttribute("dataArray3", dataArray3);
		//data11
		bean.setData11("자바웹개발과정");
		ArrayList<String> dataList5 = new ArrayList<>();
		dataList5.add("데이터분석");
		dataList5.add("풀스택개발자과정");
		dataList5.add("자바웹개발과정");
		dataList5.add("C언어과정");
		model.addAttribute("dataList5", dataList5);
		
		//data12
		bean.setData12("자바웹개발과정");
		ArrayList<BeanKeyValue> dataList6 = new ArrayList<>();
		dataList6.add(key_bean1);
		dataList6.add(key_bean2);
		dataList6.add(key_bean3);
		dataList6.add(key_bean4);
		dataList6.add(key_bean5);
		model.addAttribute("dataList6", dataList6);
		
		
		return "test1";
	}
	
	@PostMapping("/send")
	public ModelAndView sendData(BeanData bean) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("bean", bean);
		mv.setViewName("result");

		/* 
		 *  mv.setViewName("~~"); ->포워드방식
		 *  
		 *  mv.setViewName("redirect:/notice/List.do?num=1"); -> 리다이랙트방식
		 */
		
		return mv;
	}
}
