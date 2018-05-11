package com.focus.jdbc.chap04.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.focus.jdbc.model.Book;
import com.focus.jdbc.util.DbUtil;
import com.mysql.jdbc.UpdatableResultSet;

public class Demo01 {
	private static DbUtil dbUtil = new DbUtil();
	
	private static int updateBook(Book book) throws Exception{
		
		Connection con = dbUtil.getCon();
		String sql = "update t_book set bookName =?,price=?,author=?,bookTypeId=? where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1,book.getBookName() );
		ps.setFloat(2,book.getPrice());
		ps.setString(3,book.getAuthor());
		ps.setInt(4,book.getBookType());
		ps.setInt(5,book.getId());
		int result =ps.executeUpdate();
		dbUtil.close(ps, con);				//关闭
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		Book book = new Book(110011,"思君成疾，药石无医",189,"佚名",1);
		int result = updateBook(book);
		if(result ==1){
			System.out.println("修改数据成功！");
		}else{
			System.out.println("修改数据失败！");
		}
	}
}
