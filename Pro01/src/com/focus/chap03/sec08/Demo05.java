package com.focus.chap03.sec08;

public class Demo05 {

	public static void main(String[] args) {
		String name = "张三";
		char ming = name.charAt(1);
		System.out.println(ming);
		
		String str = "我是中国人";
		for(int i=0;i<str.length();i++){
			System.out.println(str.charAt(i));
		}
	}
}
