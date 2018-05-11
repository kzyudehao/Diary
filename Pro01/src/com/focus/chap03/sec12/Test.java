package com.focus.chap03.sec12;

public class Test implements A{

	@Override
	public void a() {
		System.out.println("实现方法a");
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.a();
		System.out.println(Test.TITLE);
	}
	
}
