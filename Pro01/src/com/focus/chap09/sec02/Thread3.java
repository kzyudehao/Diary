package com.focus.chap09.sec02;

public class Thread3 implements Runnable{
	private String threadName;
	private int baoZi = 1;

	public Thread3(String threadName) {
		super();
		this.threadName = threadName;
	}

	@Override
	public synchronized void run() {
		
		while(baoZi<=10){
			System.out.println(threadName+"吃第"+baoZi+"个包子!!!");
			baoZi++;
		}
	}
	
	public static void main(String[] args) {
		Thread3 thread1 = new Thread3("分身张三线程");
		
		
		Thread t11 = new Thread(thread1);
		Thread t22 = new Thread(thread1);
		Thread t33 = new Thread(thread1);
		
		t11.start();
		t22.start();
		t33.start();
		
		
	}
}
