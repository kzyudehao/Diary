package com.focus.chap07.sec01;

import java.lang.reflect.Constructor;

public class Test4 {
	public static void main(String[] args) {
		Class<?> c =null;
		try {
			c = Class.forName("com.focus.chap07.sec01.Student");
			System.out.println(c.getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Student s = null;
		Constructor<?>[]  cons = c.getConstructors();
		try {
			s= (Student) cons[1].newInstance("李四",18);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(s.toString());
	}
}
