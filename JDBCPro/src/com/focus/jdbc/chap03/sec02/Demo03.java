package com.focus.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.focus.jdbc.model.Book;
import com.focus.jdbc.util.DbUtil;

public class Demo03 {
	
	private static DbUtil dbUtil = new DbUtil();
	
	
	/**
	 * 更新图书数据
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updateBook(Book book) throws Exception{
		Connection con = dbUtil.getCon();
		Statement st = con.createStatement();
		String sql = "update t_book "
				+ "set bookName ='"+book.getBookName()+"',"
						+ "price="+book.getPrice()+","
								+ "author='"+book.getAuthor()+"',"
										+ "bookTypeId="+book.getBookType()+" where id ="+book.getId();
		int result = st.executeUpdate(sql);
		dbUtil.close(st, con);
		return result;
	}
	public static void main(String[] args) throws Exception {
		Book book = new Book(110012,"情不知所起，一往而深",188,"无名氏",1);
		int result = updateBook(book);
		
		if(result ==1){
			System.out.println("语句修改成功！");
		}else{
			System.out.println("语句修改失败！");
		}
	}
}
