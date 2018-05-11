package com.focus.chap03.sec16;

public class Test {
	
	public void test(A a){
		a.say();
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.test(new B());
		
		test.test(new A(){

			@Override
			public void say() {
				System.out.println("匿名内部类a方法！！！");
			}
			
		});
	}
}
