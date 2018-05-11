package com.focus.chap03.sec09;

public class Cat extends Animal{
	/**
	 * 子类无参构造方法
	 */
	public Cat(){
		System.out.println("子类猫无参构造方法");
	}
	
	public Cat(String name,int age){
			super(name,age);
			System.out.println("子类有参构造方法");
	}
	
	public void say(){
		System.out.println("我是一只猫，我的名字叫"+this.getName()+",我的年龄是"+this.getAge());
	}
	
	public static void main(String[] args) {
		Cat cat =new Cat("mimi",2);
		/*cat.setName("mimi");
		cat.setAge(2);*/
		cat.say();
	}
}
