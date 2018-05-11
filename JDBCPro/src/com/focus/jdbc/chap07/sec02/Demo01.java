package com.focus.jdbc.chap07.sec02;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.focus.jdbc.util.DbUtil;

public class Demo01 {
	private static DbUtil dbUtil = new DbUtil();
	
	private static String getBookNameById(int id) throws Exception{
		Connection con = dbUtil.getCon();
		String sql = "{call pro_getBookName(?,?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(1, id);
		cs.registerOutParameter(2, Types.VARCHAR);
		cs.execute();
		String bookName = cs.getString("bName");		//变量名为存储过程中输出变量名称
		dbUtil.close(cs, con);
		
		return bookName;
	}
	
	public static void main(String[] args) throws Exception {
		String bookName = getBookNameById(110011);
		System.out.println("图书名称是："+bookName);
		
	}
}
