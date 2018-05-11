package com.focus.chap07.sec04;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
	public static void main(String[] args) {
		 Class<?> c = null;
		
		try {
			c =Class.forName("com.focus.chap07.sec04.Student");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Object obj = c.newInstance();
			 Field fd = c.getDeclaredField("name");
			 fd.setAccessible(true);
			 fd.set(obj, "朱刘");
			 System.out.println("name:"+fd.get(obj));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
