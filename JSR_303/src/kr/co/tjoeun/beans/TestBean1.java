package kr.co.tjoeun.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TestBean1 {
	@AssertTrue
	private boolean data1;
	
	@AssertFalse
	private boolean data2;
	
	@Max(100)
	@Min(10)
	private int data3;
	
	@Max(100)
	@Min(10)
	private String data4;
	
	@DecimalMax(value="100", inclusive=false)
	@DecimalMin(value="10", inclusive=false)
	private int data5;
	
	@Null
	private String data6; 
	
	@NotNull
	private String data7;
	
	@Digits(integer=3, fraction = 3)
	private String data8;
	
	@Size(min=2, max=10)
	private String data9;
	
	@Pattern(regexp="[a-zA-Z]*")
	private String data10;
	
	
	//생성자
	//기본 상태를 바꿀 수 있다
	public TestBean1() {
		this.data1 = true;
		this.data2 = false;
		this.data3 = 37;
		this.data4 = "50";
		this.data6 = null;
		this.data7 = "check2";
		this.data8 = "123.123";
		this.data9 = "으라라";
	}

	public boolean isData1() {
		return data1;
	}

	public void setData1(boolean data1) {
		this.data1 = data1;
	}

	public boolean isData2() {
		return data2;
	}

	public void setData2(boolean data2) {
		this.data2 = data2;
	}

	public int getData3() {
		return data3;
	}

	public void setData3(int data3) {
		this.data3 = data3;
	}

	public String getData4() {
		return data4;
	}

	public void setData4(String data4) {
		this.data4 = data4;
	}

	public int getData5() {
		return data5;
	}

	public void setData5(int data5) {
		this.data5 = data5;
	}

	public String getData6() {
		return data6;
	}

	public void setData6(String data6) {
		this.data6 = data6;
	}

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

	public String getData9() {
		return data9;
	}

	public void setData9(String data9) {
		this.data9 = data9;
	}

	public String getData10() {
		return data10;
	}

	public void setData10(String data10) {
		this.data10 = data10;
	}
	
	
	
	
	
}
