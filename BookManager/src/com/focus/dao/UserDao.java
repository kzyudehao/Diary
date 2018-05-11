package com.focus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.focus.model.User;
/**
 * 用户Dao类
 * @author root
 *
 */
public class UserDao {
	
	/**
	 * 用户登录验证
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(Connection con,User user) throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			resultUser = new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
	}
}
