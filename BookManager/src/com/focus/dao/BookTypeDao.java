package com.focus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.focus.model.BookType;
import com.focus.util.StringUtil;

public class BookTypeDao {
	
	/**
	 * 添加图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int addBookType(Connection con ,BookType bookType) throws Exception{
		String sql = "insert into t_booktype values(null,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		int result = ps.executeUpdate();
		return result;
	}
	
	/**
	 * 模糊查询图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet listBookType(Connection con ,BookType bookType) throws Exception{
		StringBuilder sql = new StringBuilder("select * from t_booktype");
		ResultSet resultSet = null;
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
			sql.append(" and bookTypeName like'%"+bookType.getBookTypeName()+"%'");
		}
		
		PreparedStatement ps = con.prepareStatement(sql.toString().replaceFirst("and", "where"));
		resultSet =ps.executeQuery();
		return resultSet;
	}
	
	/**
	 * 修改图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int updataBookType(Connection con ,BookType bookType) throws Exception{
		String sql = "update t_booktype set bookTypeName =?,bookTypeDesc=? where id=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		ps.setInt(3, bookType.getId());
		
		return ps.executeUpdate();
	}
	
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteBookType(Connection con ,int id) throws Exception{
		String sql = "delete from t_booktype where id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeUpdate();
	}
}
