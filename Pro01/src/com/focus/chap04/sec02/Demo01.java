package com.focus.chap04.sec02;

public class Demo01 {
	public static void main(String[] args) {
		String str = "123a";
		try{
			int i = Integer.valueOf(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("继续执行");
		
	}
}
