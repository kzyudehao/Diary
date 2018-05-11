package com.focus.chap07.sec01;

public class Test2 {
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("com.focus.chap07.sec01.Student");
			System.out.println(c.getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
