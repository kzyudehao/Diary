package com.focus.chap04.sec05;

public class TestCostomException {
	public static void test() throws CostomException{
		throw new CostomException("自定义异常");
	}
	
	 public static void main(String[] args) {
		try {
			test();
		} catch (CostomException e) {
			e.printStackTrace();
		}
	}
	
}
