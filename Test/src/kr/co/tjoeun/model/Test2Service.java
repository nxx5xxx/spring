package kr.co.tjoeun.model;

import javax.servlet.http.HttpServletRequest;

public class Test2Service {

		public static int minus(HttpServletRequest request) {
			
			//보통서비스에서 사용
			String strNumber3 = request.getParameter("number3"); //문자열로 넘어오기때문에 ""를써서 받는것 즉 문자열이라는것임이것도
			String strNumber4 = request.getParameter("number4");
			int result2 = 0;
			if(strNumber3 != null) {
			int num3 = Integer.parseInt(strNumber3);
			int num4 = Integer.parseInt(strNumber4);
				result2 = num3 - num4;
			}
			return result2;
		}
}
