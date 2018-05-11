package com.focus.chap03.sec14;

public class People {
	private String name;
	
	
	
	@Override
	public String toString() {
		return this.getName();
	}

	public People(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public static void main(String[] args) {
		People people = new People("张三");
		System.out.println(people);
		System.out.println(people.toString());
	}
	
}
