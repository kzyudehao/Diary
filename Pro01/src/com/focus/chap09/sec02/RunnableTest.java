package com.focus.chap09.sec02;

public class RunnableTest implements Runnable{
	private String threadName;

	public RunnableTest(String threadName) {
		super();
		this.threadName = threadName;
	}

	@Override
	public void run() {
		int baozi = 1;
		while(baozi<=10){
			
			System.out.println(threadName+"吃第"+baozi+"个包子!!!");
			baozi++;
		}
	}
	
	public static void main(String[] args) {
		RunnableTest thread1 = new RunnableTest("张三线程");
		RunnableTest thread2 = new RunnableTest("李四线程");
		
		Thread t11 = new Thread(thread1);
		Thread t22 = new Thread(thread2);
		
		try {
			t11.sleep(1000);
			t22.sleep(1000);
			t11.start();
			t22.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
