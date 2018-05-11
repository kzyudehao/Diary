package com.focus.jdbc.chap05.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.focus.jdbc.model.Book;
import com.focus.jdbc.util.DbUtil;

public class Demo01 {
	private static DbUtil dbUtil = new DbUtil();

	/**
	 * 遍历数据库表
	 * 
	 * @throws Exception
	 */
	private static void bookList() throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1); // 获取第一列的值 id
			String bookName = rs.getString(2);
			float price = rs.getFloat(3);
			String author = rs.getString(4);
			int bookTypeId = rs.getInt(5);
			System.out
					.println("id:" + id + "图书名称：" + bookName + "图书价格：" + price + "作者：" + author + "图书类型：" + bookTypeId);
			System.out.println("===================================================");
		}

	}

	private static void bookList2() throws Exception {
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id"); // 获取第一列的值 id
			String bookName = rs.getString("bookName");
			float price = rs.getFloat("price");
			String author = rs.getString("author");
			int bookTypeId = rs.getInt("bookTypeId");
			System.out
					.println("id:" + id + "图书名称：" + bookName + "图书价格：" + price + "作者：" + author + "图书类型：" + bookTypeId);
			System.out.println("===================================================");
		}
	}

	private static List bookList3() throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		Connection con = dbUtil.getCon();
		String sql = "select * from t_book";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id"); // 获取第一列的值 id
			String bookName = rs.getString("bookName");
			float price = rs.getFloat("price");
			String author = rs.getString("author");
			int bookTypeId = rs.getInt("bookTypeId");
			Book book = new Book(id, bookName, price, author, bookTypeId);
			bookList.add(book);
		}
		return bookList;
	}

	public static void main(String[] args) throws Exception {
		// bookList();
		//bookList2();
		
		List<Book> bookList = bookList3();
		for(Book book:bookList){
			System.out.println(book);
		}
		
	}
}
