package com.focus.chap03.sec08;

public class Demo09 {
	
	public static void main(String[] args) {
		String str = " aB232 23 &*( s2 ";
		String newStr = str.trim();
		System.out.println(newStr);
		
		int yw = 0;	//统计英文字符个数，初始为0
		int kg=0;	//统计空格字符个数，初始为0
		int sz=0;	//统计数字字符个数，初始为0
		int qt=0;	//统计其他字符个数，初始为0
		
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
				yw++;
			}else if(c ==' '){
				kg++;
			}else if(c>='0'&&c<='9'){
				sz++;
			}else{
				qt++;
			}
		}
		
		System.out.println("英文字符数为："+yw);
		System.out.println("空格字符数为："+kg);
		System.out.println("数字字符数为："+sz);
		System.out.println("其他字符数为："+qt);
		
		
	}
}
