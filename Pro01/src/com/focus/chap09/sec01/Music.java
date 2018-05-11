package com.focus.chap09.sec01;

public class Music extends Thread {


	@Override
	public void run() {
		
		try {
			for(int i=0;i<=100;i++){
				Thread.sleep(1000);
				System.out.println("听音乐！！");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
