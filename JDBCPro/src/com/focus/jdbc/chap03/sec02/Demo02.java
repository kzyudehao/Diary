package com.focus.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.focus.jdbc.model.Book;
import com.focus.jdbc.util.DbUtil;
/**
 * 添加图书
 * @author root
 *
 */
public class Demo02 {
	private static DbUtil dbUtil = new DbUtil();
	
	private static int addBook2(Book book) throws Exception{
		Connection con = dbUtil.getCon();
		Statement st = con.createStatement();
		String sql = "insert into t_book values(null,'"+book.getBookName()+"',"+book.getPrice()+",'"+book.getAuthor()+"',"+book.getBookType()+");";
		int result = st.executeUpdate(sql);
		dbUtil.close(st, con);
		return result;
	}
	
	private static int addBook(String bookName,float price,String author,int bookType) throws Exception{
		Connection con = dbUtil.getCon();
		Statement st = con.createStatement();
		String sql = "insert into t_book values(null,'"+bookName+"',"+price+",'"+author+"',"+bookType+");";
		int result = st.executeUpdate(sql);
		dbUtil.close(st, con);
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		//addBook("愿得一心人", 188, "白首", 1);
		
		Book book = new Book("思君成疾，药石无医",178,"佚名",1);
		int result = addBook2(book);
		if(result==1){
			System.out.println("数据添加成功！");
		}else{
			System.out.println("数据添加失败！");
		}
		
	}
}
