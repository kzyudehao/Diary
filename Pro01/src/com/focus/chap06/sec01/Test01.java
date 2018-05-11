package com.focus.chap06.sec01;

public class Test01 {
	public static void main(String[] args) {
		
		CC<Integer> i1 = new CC<Integer>(1);
		i1.print();
		System.out.println("i1的值为："+i1.getT());
		
		CC<String> s1 = new CC<String>("泛型so cool~");
		s1.print();
		System.out.println("s1的值为："+s1.getT());
	}
}
