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
import com.xp.util.StringUtil;

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
		}else if("preSave".equals(action)){
			this.diaryPreSave(request, response);
		}else if("save".equals(action)){
			this.diarySave(request, response);
		}else if("delete".equals(action)){
			this.diaryDelete(request, response);
		}
		
		
	}
	
	/**
	 * 查看日志详情方法
	 * @param request
	 * @param response
	 */
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
	
	/**
	 *主页--写日志选项跳转页面
	 * @param request
	 * @param response
	 */
	private void diaryPreSave(HttpServletRequest request, HttpServletResponse response) {
		String diaryId = request.getParameter("diaryId");
		Connection con = null;
		try {
			if(StringUtil.isNotEmpty(diaryId)){
				con = dbUtil.getCon();
				Diary diary = diaryDao.getDiaryInfo(con, diaryId);
				request.setAttribute("diary", diary);
			}
			request.setAttribute("mainPage", "diary/diarySvae.jsp");	//
			request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
			
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
	
	private void diarySave(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		Diary diary = new Diary(title, content, typeId);
		Connection con =null;
		
			
		try {
			con = dbUtil.getCon();
			int saveSum = diaryDao.addDiary(con, diary);
			if(saveSum>0){
				request.getRequestDispatcher("main?all=true").forward(request, response);//服务器内部转发
			}else{
				request.setAttribute("diary", diary);
				request.setAttribute("error", "添加日志失败！！");
				request.setAttribute("mainPage", "diary/diarySvae.jsp");	//
				request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
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
	

	private void diaryDelete(HttpServletRequest request, HttpServletResponse response) {

		String diaryId = request.getParameter("diaryId");

		Connection con =null;
		try {
			con = dbUtil.getCon();
			int saveSum = diaryDao.deleteDiary(con, diaryId);
			if(saveSum>0){
				request.getRequestDispatcher("main?all=true").forward(request, response);//服务器内部转发
			}else{
				request.setAttribute("error", "删除日志失败！！");
				request.setAttribute("mainPage", "diary/diarySvae.jsp");	//
				request.getRequestDispatcher("mainTemp.jsp").forward(request, response);
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

}