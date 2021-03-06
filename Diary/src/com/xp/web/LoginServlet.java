package com.xp.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xp.dao.UserDao;
import com.xp.model.User;
import com.xp.util.DbUtil;


public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DbUtil dbUtil = new DbUtil();
	UserDao userDao = new UserDao();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");		//记住密码
		HttpSession session = request.getSession();
		
		
		Connection con = null;
		User user = new User(userName, password);
		
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.checkID(con, user);
			if(currentUser!=null){
				if("remember-me".equals(remember)){
					rememberMe(userName, password, response);
				}
				session.setAttribute("currentUser", currentUser);	//回复前端信息
				request.getRequestDispatcher("main").forward(request, response);	//登录成功，请求/main
				System.out.println("成功");
			}else{
				request.setAttribute("user", user);					//回传前端
				request.setAttribute("error", "用户名或密码错误");		//回传前端
				request.getRequestDispatcher("login.jsp").forward(request, response);//服务器内部转发
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 记住密码方法
	 * @param userName
	 * @param password
	 * @param response
	 */
	public void rememberMe(String userName ,String password,HttpServletResponse response){
		
		Cookie user = new Cookie("user",userName+"-"+password);	
		user.setMaxAge(1*60*60*24*7); 				//设置cookie有效期
		response.addCookie(user);
		
	}
	
	
}
