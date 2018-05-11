package com.focus.chap09.sec01;

public class Eat extends Thread {
	
	@Override
	public void run() {
		try {
			for(int i=0;i<=100;i++){
				Thread.sleep(1000);
				System.out.println("吃饭！！");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
