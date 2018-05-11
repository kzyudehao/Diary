package com.focus.chap09.sec02;

public class ThreadTest extends Thread{
	private String threadName;

	public ThreadTest(String threadName) {
		super();
		this.threadName = threadName;
	}

	@Override
	public void run() {
		int baozi = 1;
		while(baozi<=10){
			
			System.out.println(threadName+"吃包子!!!");
			baozi++;
		}
	}
	
	public static void main(String[] args) {
		ThreadTest thread1 = new ThreadTest("张三线程");
		ThreadTest thread2 = new ThreadTest("李四线程");
		try {
			thread1.sleep(1000);
			thread2.sleep(1000);
			
			thread1.start();
			thread2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
