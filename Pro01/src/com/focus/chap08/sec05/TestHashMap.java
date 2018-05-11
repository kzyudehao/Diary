package com.focus.chap08.sec05;

import java.util.HashMap;
import java.util.Iterator;

public class TestHashMap {
	public static void main(String[] args) {
		
		HashMap<String,Student> hm = new HashMap<String,Student>();
		hm.put("1号", new Student("张三",18));
		hm.put("2号", new Student("李四",19));
		hm.put("3号", new Student("王五",20));
		
		Student s = hm.get("1号");
		System.out.println(s.toString());
		
		 Iterator<String> it = hm.keySet().iterator();
		 while(it.hasNext()){
			 String str = it.next();
			 Student student = hm.get(str);
			 System.out.println(student.toString());
		 }
		
	}
}
