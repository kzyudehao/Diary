package com.focus.jdbc.chap02.sec03;

public class Demo01 {
	private static String jdbcName = "com.mysql.jdbc.Driver";
	
	public static void main(String[] args) {
		try {
			Class.forName(jdbcName);
			System.out.println("驱动加载成功！！！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动加载失败！！！");
		}
	}
}
