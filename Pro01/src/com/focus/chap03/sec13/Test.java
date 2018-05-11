package com.focus.chap03.sec13;

public class Test {
	public static void main(String[] args) {
		//父类引用指向子类对象，父类对象可调用子类方法
		Animal animal = new Dog();
		animal.say();
		
		//更换实现
		animal =new Cat();
		animal.say();
		
	}
}
