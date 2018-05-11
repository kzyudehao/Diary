package com.focus.chap08.sec04;

import java.util.HashSet;
import java.util.Iterator;

public class TestHashSet {
	public static void main(String[] args) {
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("111");
		hs.add("222");
		hs.add("333");
		hs.add("121");
		
		Iterator<String> it = hs.iterator();
		
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		
		
	}
}
