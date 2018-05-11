package com.focus.chap03.sec11;

public abstract class People {
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void say(){
		System.out.println("我的名字叫："+this.getName());
	}
	
	public abstract void profession();
}
