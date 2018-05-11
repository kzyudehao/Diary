package com.focus.chap07.sec03;

import java.lang.reflect.Constructor;

public class Test1 {
	public static void main(String[] args) {
		Class<?> c = null;
		try {
			c = Class.forName("com.focus.chap07.sec03.Student");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Constructor<?> cons[] = c.getConstructors();
		
		for(Constructor<?> con:cons){
			System.out.println("构造方法为："+con);
		}
		
		
		
		
	}
}
