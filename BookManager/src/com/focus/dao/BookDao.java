package com.focus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.focus.model.Book;
import com.focus.util.StringUtil;

/**
 * 图书Dao
 * @author root
 *
 */
public class BookDao {
	
	/**
	 * 添加图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int addBook(Connection con,Book book) throws Exception{
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setInt(5, book.getBookTypeId());
		ps.setString(6, book.getBookDesc());
		
		return ps.executeUpdate();
	}
	
	/**
	 * 图书查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet listBook(Connection con,Book book) throws Exception{
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from t_book b,t_booktype bt where b.bookTypeId = bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and bookName like'%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and author like'%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=0 && book.getBookTypeId()!=-1){
			sb.append(" and bookTypeId ="+book.getId());
		}
		
		
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		return rs;
	}
	
	/**
	 * 图书修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int updateBook(Connection con,Book book) throws Exception{
		String sql =  "update t_book set bookName = ?,author=?,sex=?,price=?,bookTypeId=?,bookDesc=? where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setInt(5, book.getBookTypeId());
		ps.setString(6, book.getBookDesc());
		ps.setInt(7, book.getId());
		return ps.executeUpdate();
	}
	
	/**
	 * 删除书籍
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBook(Connection con,int id) throws Exception{
		String sql="delete from t_book where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
	
}
