package kr.co.tjoeun.beans;

import java.util.Arrays;

public class BeansData {
	private int num1;
	private int num2;
	private int[] number;
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int[] getNumber() {
		return number;
	}
	public void setNumber(int[] number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "BeansData [num1=" + num1 + ", num2=" + num2 + ", number=" + Arrays.toString(number) + "]";
	}
	
	
	
}
