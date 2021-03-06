package com.xp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xp.model.User;
import com.xp.util.MD5Util;
import com.xp.util.PropertiesUtil;

public class UserDao {

	/**
	 * 登录账户验证
	 * 
	 * @param con
	 * @param user
	 * @return
	 */
	public User checkID(Connection con, User user) throws Exception{
		User resultUser = null;
		String sql = "select * from t_user where userName =? and password=? ";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, MD5Util.enCoderPwdMd5(user.getPassword()));
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			resultUser = new User();
			int userId = rs.getInt("userId");
			String userName = rs.getString("userName");
			String password = rs.getString("password");
			
			resultUser.setUserId(userId);
			resultUser.setUserName(userName);
			resultUser.setPassword(password);
			resultUser.setNickName(rs.getString("nickName"));
			resultUser.setImageName(propertiesUtil.getValue("imageFile")+rs.getString("imageName"));
			resultUser.setMood(rs.getString("mood"));
		}
		return resultUser;
	}
	
	public int userUpdate(Connection con ,User user) throws Exception{
		String sql ="update t_user set nickName = ?,imageName=?,mood=? where userId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getNickName());
		ps.setString(2, user.getImageName());
		ps.setString(3, user.getMood());
		ps.setInt(4, user.getUserId());
		return ps.executeUpdate();
		
	}
}
