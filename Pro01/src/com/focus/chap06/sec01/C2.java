package com.focus.chap06.sec01;

public class C2 {
	private String b;
	
	public C2(String b) {
		super();
		this.b = b;
	}

	public String getA() {
		return b;
	}

	public void setA(String b) {
		this.b = b;
	}
	
	public void print(){
		System.out.println("b的数据类型为："+b.getClass().getName());
	}
}
