package com.focus.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class DbUtil2 {
	//数据库地址
	private static String dbUrl= "jdbc:mysql://localhost:3306/db_bank";
	//数据库用户名
	private static String dbUserName= "root";
	//数据库密码
	private static String dbPassword= "123456";
	//驱动名称
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con =DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	public static void close(Statement st ,Connection con) throws Exception{
		if(st!=null){
			st.close();
		}
		if(con!=null){
			con.close();
		}
	}
	
	public void close(PreparedStatement ps ,Connection con) throws Exception{
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
	}
}
