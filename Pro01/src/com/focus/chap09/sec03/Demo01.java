package com.focus.chap09.sec03;

public class Demo01 implements Runnable {

	@Override
	public void run() {
		
		for(int i=0;i<10;i++){
			 Thread t1 = Thread.currentThread();
			System.out.println(t1.getName()+":"+i);
		}
	}
	
	public static void main(String[] args) {
		Demo01 d1 = new Demo01();
		new Thread(d1).start();
		new Thread(d1).start();
		new Thread(d1,"线程3").start();
		
	}
}
