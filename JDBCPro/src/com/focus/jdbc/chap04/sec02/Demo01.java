package com.focus.jdbc.chap04.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.focus.jdbc.model.Book;
import com.focus.jdbc.util.DbUtil;

public class Demo01 {
	private static DbUtil dbUtil = new DbUtil();
	
	private static int addBook(Book book) throws Exception{
		
		Connection con = dbUtil.getCon();
		String sql = "insert into t_book values(null,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,book.getBookName());
		ps.setFloat(2,book.getPrice());
		ps.setString(3,book.getAuthor());
		ps.setInt(4,book.getBookType());
		int result = ps.executeUpdate();
		dbUtil.close(ps, con);
		return result;
		
	}
	 
	public static void main(String[] args) throws Exception {
		Book book = new Book("夜夜思君不见君",189,"无名氏",1);
		int result = addBook(book);
		if(result ==1){
			System.out.println("添加数据成功！");
		}else{
			System.out.println("添加数据失败！");
		}
	}
}
