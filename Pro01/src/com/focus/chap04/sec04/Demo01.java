package com.focus.chap04.sec04;

public class Demo01 {
	public static void testRuntimeException() throws RuntimeException {
		throw new RuntimeException("运行时异常，可以不try...catch");
	}
	
	public static void testException() throws Exception{
		throw new Exception("Exception异常");
	}
	
	public static void main(String[] args) {
		
		try {
			testException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		testRuntimeException();
		
		
	}
	
}
