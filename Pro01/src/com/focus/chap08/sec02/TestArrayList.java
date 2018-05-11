package com.focus.chap08.sec02;

import java.util.ArrayList;

public class TestArrayList {
	
	public static void printArrayList(ArrayList<String> arrayList){
		System.out.print("当前的集合元素：");
		
		for(int i = 0;i<arrayList.size();i++){
			System.out.print(arrayList.get(i) +' ');
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("张三");
		arrayList.add("李四");
		arrayList.add("王五");
		printArrayList(arrayList);
		
	}
}
