package com.focus.chap08.sec02;

import java.util.LinkedList;

public class TestLinkList {
	
	public static void printLinkList(LinkedList<String> linkedList){
		System.out.print("当前集合元素为:");
		
		for(int i = 0;i<linkedList.size();i++){
			System.out.print(linkedList.get(i)+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add("张三");
		linkedList.add("李四");
		linkedList.add("王五");
		linkedList.add("张三");
		
		printLinkList(linkedList);
		
		
	}
}
