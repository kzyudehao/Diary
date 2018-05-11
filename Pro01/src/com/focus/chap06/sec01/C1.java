package com.focus.chap06.sec01;

public class C1 {
	private Integer a;

	public C1(Integer a) {
		super();
		this.a = a;
	}

	public Integer getI() {
		return a;
	}

	public void setI(Integer a) {
		this.a = a;
	}
	
	public void print(){
		System.out.println("a的类型是："+a.getClass().getName());
	}
	
}
