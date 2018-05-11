package com.focus.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.focus.jdbc.util.DbUtil;

public class Demo01 {
	public static void main(String[] args) throws Exception {
		DbUtil dbUtil = new DbUtil();
		String sql = "insert into t_book values(null,'聽風雨',128,'小樓',1)";
		Connection con = dbUtil.getCon();
		Statement st = con.createStatement();
		int result = st.executeUpdate(sql);		//返回結果為所影響行數
		System.out.println("操作结果："+result+"数据");
		st.close();
		con.close();
	}
}
