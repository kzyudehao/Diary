package com.focus.chap03.sec07;

public class Demo01 {
	public static void main(String[] args) {
		int a = 1;
		
		{
			a = 2;
			System.out.println("普通代码块！！");
		}
		
		System.out.println("a="+a);
	}
}
