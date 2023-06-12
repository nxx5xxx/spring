package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

//루트앱에서 인식이아닌 여기 자체에서 인식하게 하는것
//byType
@Component
@ApplicationScope
public class TestBean3 {
	private String data5;
	private String data6;
	public String getData5() {
		return data5;
	}
	public void setData5(String data5) {
		this.data5 = data5;
	}
	public String getData6() {
		return data6;
	}
	public void setData6(String data6) {
		this.data6 = data6;
	}
	
}
