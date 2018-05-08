package com.xp.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xp.dao.DiaryDao;
import com.xp.model.Diary;
import com.xp.util.DbUtil;

public class DiaryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil = new DbUtil();
	DiaryDao diaryDao = new DiaryDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		if("show".equals(action)){
			this.showDiary(request, response);
		}
		
		
	}
	
	private void showDiary(HttpServletRequest request, HttpServletResponse response){
		
		Connection con = null;
		String diaryId = request.getParameter("diaryId");
		try {
			con = dbUtil.getCon();
			Diary diary = diaryDao.getDiaryInfo(con, diaryId);
			request.setAttribute("diary", diary);
			request.setAttribute("mainPage", "diary/diaryShow.jsp");	//
			request.getRequestDispatcher("mainTemp.jsp").forward(request, response);//服务器内部转发
			
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
}
