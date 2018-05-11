package com.focus.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 数据库工具
 * @author root
 *
 */
public class DbUtil {
	
	private static String url = "jdbc:mysql://localhost:3306/db_book";	//数据库连接地址
	private static String dbUser = "root";								//数据库用户名
	private static String dbPassword = "123456";						//数据库密码
	private static String jdbcName = "com.mysql.jdbc.Driver";			//jdbc驱动名
	
	/**
	 * 创建数据库连接
	 * @return
	 * @throws Exception
	 */
	public static Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(url, dbUser, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception 
	 */
	public static void close(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
				
		
	}
	
}
