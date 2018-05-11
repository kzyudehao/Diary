package com.focus.jdbc.chap09.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.focus.jdbc.util.DbUtil2;

public class Demo01 {
	private static DbUtil2 dbUtil = new DbUtil2();
	
	/**
	 * 转出
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void outCount(Connection con ,String accountName,int account) throws Exception{
		String sql = "update t_account set accountBalance = accountBalance-? where accountName = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, account);
		ps.setString(2, accountName);
		ps.executeUpdate();
	}
	
	/**
	 * 转入
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void inCount(Connection con ,String accountName,int account) throws Exception{
		String sql = "update t_account set accountBalance = accountBalance+? where accountName = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, account);
		ps.setString(2, accountName);
		ps.executeUpdate();
	}
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = dbUtil.getCon();
			con.setAutoCommit(false);	//关闭事务自动提交
			
			System.out.println("张三开始向李四转账！");
			int account = 500;
			outCount(con, "张三", account);
			inCount(con, "李四", account);
			System.out.println("转账成功！");
		} catch (Exception e) {
			try {
				con.rollback();		//异常时回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.commit();		//提交事务
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}