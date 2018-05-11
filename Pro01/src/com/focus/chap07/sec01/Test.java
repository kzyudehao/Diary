package com.focus.chap07.sec01;

public class Test {
	public static void main(String[] args) {
		Student stu = new Student();
		
		//通过获取类，进而获取包名
		System.out.println(stu.getClass().getName());
	}
}

