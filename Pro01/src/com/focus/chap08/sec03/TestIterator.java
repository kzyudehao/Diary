package com.focus.chap08.sec03;

import java.util.Iterator;
import java.util.LinkedList;

public class TestIterator {

	public static void main(String[] args) {
		LinkedList<Student> list = new LinkedList<Student>();
		list.add(new Student("张三",18));
		list.add(new Student("李四",19));
		list.add(new Student("王五",20));

		for(Student s:list){
			System.out.println(s.toString());
		}

		
	}
}
