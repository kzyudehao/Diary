package com.focus.chap03.sec08;

public class Test04 {
	public static void main(String[] args) {
		
		String str = "1,3,5,7,9";
		
		
		for(int i=0;i<str.length();i++){
			char arr[] = new char[str.length()];
			char c = str.charAt(i);
			if(c>='1'&&c<='9'){
				//System.out.println(c);
				arr[i]=c;
			}
			for(char j:arr){
				System.out.print(j);
			}
		}
		
		
		
		
	}
}
