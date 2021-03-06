package com.xp.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xp.dao.DiaryDao;
import com.xp.dao.DiaryTypeDao;
import com.xp.model.DiaryType;
import com.xp.util.DbUtil;
import com.xp.util.StringUtil;

public class DiaryTypeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil = new DbUtil();
	DiaryTypeDao diaryTypeDao = new DiaryTypeDao();
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
		if("list".equals(action)){
			this.diaryTypeList(request, response);
		}else if("preSave".equals(action)){
			this.diaryTypePreSave(request, response);
		}else if("save".equals(action)){
			this.diaryTypeSave(request, response);
		}else if("delete".equals(action)){
			this.diaryTypeDelete(request, response);
		}
		
	}
	
	/**
	 * 日志类别列表页面处理
	 * @param request
	 * @param response
	 */
	private void diaryTypeList(HttpServletRequest request, HttpServletResponse response){
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			List<DiaryType> diaryTypeList = diaryTypeDao.getDiaryTypeList(con);
			request.setAttribute("diaryTypeList", diaryTypeList);
			request.setAttribute("mainPage", "diaryType/typeList.jsp");	//
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
	
	private void diaryTypePreSave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String diaryTypeId = request.getParameter("diaryTypeId");
		if(StringUtil.isNotEmpty(diaryTypeId)){
			Connection con = null;
			try {
				con = dbUtil.getCon();
				DiaryType diaryType = diaryTypeDao.diaryTypeShow(con, diaryTypeId);
				request.setAttribute("diaryType", diaryType);
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
		request.setAttribute("mainPage", "diaryType/typeSvae.jsp");	//
		request.getRequestDispatcher("mainTemp.jsp").forward(request, response);//服务器内部转发
	}
	
	private void diaryTypeSave(HttpServletRequest request, HttpServletResponse response){
		String diaryTypeId = request.getParameter("diaryTypeId");
		String typeName = request.getParameter("typeName");
		DiaryType diaryType = new DiaryType(typeName);
		if(StringUtil.isNotEmpty(diaryTypeId)){
			diaryType.setDiaryTypeId(Integer.parseInt(diaryTypeId));
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int saveNum = 0;
			if(StringUtil.isNotEmpty(diaryTypeId)){
				saveNum= diaryTypeDao.diaryTypeUpdate(con, diaryType);
			}else{
				saveNum = diaryTypeDao.diaryTypeAdd(con, diaryType);
			}
			
			if(saveNum>0){
				request.getRequestDispatcher("diaryType?action=list").forward(request, response);//服务器内部转发
			}else{
				request.setAttribute("diaryType", diaryType);
				request.setAttribute("error", "存储类别信息失败");
				request.setAttribute("mainPage", "diaryType/typeSvae.jsp");	//
				request.getRequestDispatcher("mainTemp.jsp").forward(request, response);//服务器内部转发
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
	
	private void diaryTypeDelete(HttpServletRequest request, HttpServletResponse response){
		
		String diaryTypeId = request.getParameter("diaryTypeId");
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			if(StringUtil.isNotEmpty(diaryTypeId)){
				if(diaryDao.existDiaryWithTypeId(con, diaryTypeId)){	//日志含有被删除的类别
					request.setAttribute("error", "已有日志包含该类别，不能删除该类别");
				}else{
					diaryTypeDao.diaryTypeDelete(con, diaryTypeId);
				}
				request.getRequestDispatcher("diaryType?action=list").forward(request, response);//服务器内部转发
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
