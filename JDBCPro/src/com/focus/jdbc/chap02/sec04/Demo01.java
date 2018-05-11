package com.focus.jdbc.chap02.sec04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo01 {
	//数据库地址
	private static String dbUrl= "jdbc:mysql://localhost:3306/db_book";
	//数据库用户名
	private static String dbUserName= "root";
	//数据库密码
	private static String dbPassword= "123456";
	//驱动名称
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	public static void main(String[] args) {
		//加载驱动
		try {
			Class.forName(jdbcName);
			System.out.println("加载驱动成功！！");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("加载驱动失败！！");
		}
		
		//建立数据库连接
		Connection con = null;		//导入java.sql接口
		try {
			//获取数据库连接
			DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
			System.out.println("数据库连接成功！！");
			System.out.println("可进行数据库操作！！");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();				//关闭连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
