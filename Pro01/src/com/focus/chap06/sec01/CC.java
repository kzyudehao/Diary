package com.focus.chap06.sec01;

public class CC<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public CC(T t) {
		super();
		this.t = t;
	}
	
	public void print(){
		System.out.println("t的类型是："+t.getClass().toString());
	}
}
