package com.focus.chap03.sec08;

public class Demo02 {
	public static void main(String[] args) {
		String name1 = "张三";
		String name2 = new String("张三");
		String name3 = name2;	//传递引用，指向同一个内存块
		
		//	"=="比较的是引用,地址是否指向一致
		System.out.println("name1==name2:"+(name1==name2));
		System.out.println("name1==name3:"+(name1==name3));
		System.out.println("name2==name3:"+(name2==name3));
		
		// "equals"比较的是具体的内容
		System.out.println("name1.equals(name2):"+(name1.equals(name2)));
		System.out.println("name1.equals(name3):"+(name1.equals(name3)));
		System.out.println("name2.equals(name3):"+(name2.equals(name3)));
		
	}
}
