package kr.co.tjoeun.beans;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

//루트앱에서 인식이아닌 여기 자체에서 인식하게 하는것
//byName
@Component(value="applicationBean4")
@ApplicationScope
public class TestBean4 {
	private String data7;
	private String data8;
	public String getData7() {
		return data7;
	}
	public void setData7(String data7) {
		this.data7 = data7;
	}
	public String getData8() {
		return data8;
	}
	public void setData8(String data8) {
		this.data8 = data8;
	}
	
	
}
