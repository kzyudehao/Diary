package com.xp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	
	
	public DbUtil() {
		super();
	}
	
	PropertiesUtil propertiesUtil = new PropertiesUtil();

	/*private String dbUrl = "jdbc:mysql://localhost:3306/db_diary";
	private String dbUser ="root";
	private String password ="123456";
	private String jdbcName="com.mysql.jdbc.Driver";*/
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		
		Class.forName(propertiesUtil.getValue("jdbcName"));
		Connection con =DriverManager.getConnection(propertiesUtil.getValue("dbUrl"), propertiesUtil.getValue("dbUser"), propertiesUtil.getValue("password"));
		
		return con;
	}
	
	
	/**
	 * 关闭数据库连接
	 * @param con
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	
	public static void main(String[] args) {
		
		DbUtil dbUtil = new DbUtil();
		try {
			Connection con = dbUtil.getCon();
			System.out.println("数据库连接成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接成功");
		}
		
	}
}
