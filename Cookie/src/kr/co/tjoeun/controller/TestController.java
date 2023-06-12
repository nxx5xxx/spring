package kr.co.tjoeun.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("/save_cookie")
	public String saveCookie(HttpServletResponse response) {
		
		try {
			//한글인 경우 저장할 문자열을 encoding 해야한다
			String str1 = URLEncoder.encode("강아지","UTF-8");
			String str2 = URLEncoder.encode("고양이","UTF-8");
			
			Cookie ck1 = new Cookie("data1",str1); //쿠키는 키과 값
			Cookie ck2 = new Cookie("data2",str2);
			
			//시간을 정함 - 초단위
			ck1.setMaxAge(60*60*24*365); //=1년
			ck2.setMaxAge(60*60*24*365); //=1년
			
			response.addCookie(ck1);
			response.addCookie(ck2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "save_cookie";
	}
	
	@GetMapping("/load_cookie")
	public String loadCookie(HttpServletRequest request) {
		try {
			Cookie[] cks = request.getCookies();
			for(Cookie data : cks) {
				String str1 = URLDecoder.decode(data.getValue(),"UTF-8");
				if(data.getName().equals("data1")) {
					System.out.println(str1);
				}else if(data.getName().equals("data2")) {
					System.out.println(str1);
				}
			}
		} catch (Exception e) {

		}
		return "load_cookie";
	}
	@GetMapping("/load_cookie2")
	public String loadCookie2(@CookieValue("data1") String cookie1,
						@CookieValue("data2") String cookie2) {

		System.out.println("cookie1 : "+cookie1);
		System.out.println("cookie2 : "+cookie2);
		
		return "load_cookie2";
	}
}
