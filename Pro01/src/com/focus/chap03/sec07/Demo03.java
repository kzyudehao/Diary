package com.focus.chap03.sec07;

public class Demo03 {
	/**
	 * 静态代码块
	 */
	static{
		System.out.println("静态代码块");
	}
	
	public Demo03(){
		System.out.println("构造方法一");
	}
	
	public Demo03(int i){
		System.out.println("构造方法二");
	}
	
	public Demo03(int i,int j){
		System.out.println("构造方法三");
	}
	
	public static void main(String[] args) {
		new Demo03();
		new Demo03(1);
		new Demo03(1,2);
	}


}
