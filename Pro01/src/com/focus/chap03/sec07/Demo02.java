package com.focus.chap03.sec07;

public class Demo02 {
	
	/**
	 * 构造快
	 */
	{
		System.out.println("通用构造快");
	}
	
	public Demo02(){
		System.out.println("构造方法一");
	}
	
	public Demo02(int i){
		System.out.println("构造方法二");
	}
	
	public Demo02(int i,int j){
		System.out.println("构造方法三");
	}
	
	public static void main(String[] args) {
		new Demo02();
		new Demo02(1);
		new Demo02(1,2);
	}
	
}
