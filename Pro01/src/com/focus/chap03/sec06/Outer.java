package com.focus.chap03.sec06;
/**
 * 外部类
 * @author root
 *
 */
public class Outer {
	private int a = 1;
	/**
	 * 内部类
	 * @author root
	 *
	 */
	class Inner{
		public void show(){
			System.out.println(a);//可以方便的使用外部的属性
		}
	}
	
	public void show(){
		Inner inner = new Inner();
		inner.show();
	}
	
	public static void main(String[] args){
		Outer outer = new Outer();
		outer.show();
	}
	
}
