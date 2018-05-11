package com.focus.chap07.sec01;

public class Test3 {
	public static void main(String[] args) {
		Class<?> c =null;
		try {
			c = Class.forName("com.focus.chap07.sec01.Student");
			System.out.println(c.getName());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Student s = null;
		try {
			s= (Student) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		s.setName("张三");
		s.setAge(30);
		System.out.println(s.toString());
		
		
	}
}
