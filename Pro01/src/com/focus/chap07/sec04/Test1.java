package com.focus.chap07.sec04;

import java.lang.reflect.Method;

public class Test1 {
	public static void main(String[] args) {
		 Class<?> c = null;
		
		try {
			c =Class.forName("com.focus.chap07.sec04.Student");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Object obj = c.newInstance();
			//通过反射获取方法
			Method  m1 = obj.getClass().getMethod("setName", String.class);
			//调用方法
			m1.invoke(obj, "王五");
			
			Method m2 = obj.getClass().getMethod("getName");
			String name = (String) m2.invoke(obj);
			System.out.println("name=" +name);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
