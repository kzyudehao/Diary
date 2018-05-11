package com.focus.chap03.sec09;

public class Animal {
	private String name;
	private int age;
	
	
	/**
	 * 无参父类构造方法
	 */
	
	public Animal() {
		System.out.println("无参父类构造方法");
	}
	/**
	 * 有参数父类构造方法
	 * @param name
	 * @param age
	 */
	public Animal(String name, int age) {
		System.out.println("有参父类构造方法");
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void say(){
		System.out.println("我是一只动物，我的名字叫"+this.getName()+",我的年龄是"+this.getAge());
	}
	
}
