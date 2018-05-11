package com.focus.chap03.sec08;

public class Demo03 {
	public static void main(String[] args) {
		//name1,name2指向的是同一个对象
		String name1 = "张三";
		String name2 = "张三";
		
		//name3指向一个新的实例对象
		String name3 = new String("张三");
		String name4 = new String("张三");
		
		System.out.println("name1==name2:"+(name1==name2));
		System.out.println("name3==name4:"+(name3==name4));
	}
}
