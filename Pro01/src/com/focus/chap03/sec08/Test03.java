package com.focus.chap03.sec08;
/**
 * 实现字符串反转
 * @author root
 *
 */
public class Test03 {
	public static void main(String[] args) {
		
		String str = "abcdefg";
		
		String newStr = "";
		for(int i=0;i<str.length();i++){
			
			newStr = str.charAt(i)+newStr;
			
		}
		System.out.println(newStr);
	}
}
