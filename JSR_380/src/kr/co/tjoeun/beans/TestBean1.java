package kr.co.tjoeun.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.Negative;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;


@Data
public class TestBean1 {
	
	@NotEmpty
	private String data1;
	
	@NotBlank
	private String data2;
	
	@Positive
	private int data3;
	
	@PositiveOrZero
	private int data4;
	
	@Negative
	private int data5;
	
	@NegativeOrZero
	private int data6;
	
	@Email
	@NotBlank
	private String data7;
	
	
	// 기본 생성자에서 나오는값 설정하기
	public TestBean1() {
		this.data1 = "노공백";
		this.data2 = "노공백2";
		this.data3 = 1;
		this.data4 = 0;
		this.data5 = -1;
		
	}
	
}
