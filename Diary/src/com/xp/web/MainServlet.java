package com.xp.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xp.dao.DiaryDao;
import com.xp.dao.DiaryTypeDao;
import com.xp.model.Diary;
import com.xp.model.DiaryType;
import com.xp.model.PageBean;
import com.xp.util.DbUtil;
import com.xp.util.PropertiesUtil;
import com.xp.util.StringUtil;

public class MainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DbUtil dbUtil = new DbUtil();
	DiaryDao diaryDao = new DiaryDao();
	DiaryTypeDao diaryTypeDao = new DiaryTypeDao(); 
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String page = request.getParameter("page");	//当前页
		String s_diaryTypeId = request.getParameter("s_diaryTypeId");
		String s_releaseDateStr = request.getParameter("s_releaseDateStr");
		String s_title = request.getParameter("s_title");
		String all = request.getParameter("all");
		
		if(StringUtil.isEmpty(page)){
			page="1";
		}
		
		Connection con = null;
		PropertiesUtil propertiesUtil = new PropertiesUtil();
		Diary s_diary= new Diary();
		PageBean pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(propertiesUtil.getValue("pageSize")));
		try {
			HttpSession session = request.getSession();
			
			if("true".equals(all)){
				//搜索框判断
				if(StringUtil.isNotEmpty(s_title)){
					s_diary.setTitle(s_title);
				}
				session.setAttribute("s_title", s_title);
				session.removeAttribute("s_releaseDateStr");
				session.removeAttribute("s_diaryTypeId");
				
				
			}else{
				
				//日志类别选择判断
				if(StringUtil.isNotEmpty(s_diaryTypeId)){
					s_diary.setTypeId(Integer.parseInt(s_diaryTypeId));
					session.setAttribute("s_diaryTypeId", s_diaryTypeId);
					session.removeAttribute("s_releaseDateStr");
					session.removeAttribute("s_title");
				}
				//日期类别选择判断
				if(StringUtil.isNotEmpty(s_releaseDateStr)){
					s_releaseDateStr = new String(s_releaseDateStr.getBytes("ISO-8859-1"),"UTF-8");	//前后端传输转码
					s_diary.setReleaseDateStr(s_releaseDateStr);
					session.setAttribute("s_releaseDateStr", s_releaseDateStr);
					session.removeAttribute("s_diaryTypeId");
					session.removeAttribute("s_title");
				}
				if(StringUtil.isEmpty(s_diaryTypeId)){
					Object o=session.getAttribute("s_diaryTypeId");
					if(o!=null){
						s_diary.setTypeId(Integer.parseInt((String)o));
					}
				}
				if(StringUtil.isEmpty(s_releaseDateStr)){
					Object o=session.getAttribute("s_releaseDateStr");
					if(o!=null){
						s_diary.setReleaseDateStr((String)o);
					}
				}
				
				if(StringUtil.isEmpty(s_title)){
					Object o=session.getAttribute("s_title");
					if(o!=null){
						s_diary.setTitle((String)o);
					}
				}
			}
			
			
			con = dbUtil.getCon();
			List<Diary> diaryList = diaryDao.getDiary(con,pageBean,s_diary);
			request.setAttribute("diaryList", diaryList);
			
			List<DiaryType> diaryTypeCountList = diaryTypeDao.getDiaryTypeCountList(con);	//获取日志类别统计列表
			
			session.setAttribute("diaryTypeCountList", diaryTypeCountList);
			
			List<Diary> diaryCountList = diaryDao.getDiaryCountList(con);					//获取日志日期统计列表
			session.setAttribute("diaryCountList", diaryCountList);
			
		
			
			int totalNum = diaryDao.getDiaryCount(con,s_diary);			//查询的总记录数
			String pageCode = this.getPageCode(totalNum, Integer.parseInt(page), Integer.parseInt(propertiesUtil.getValue("pageSize")));
			request.setAttribute("pageCode", pageCode);
			request.setAttribute("mainPage", "diary/diaryList.jsp");	//
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
	
	private String getPageCode(int totalNum,int currentPage,int pageSize){
		
		int totalPage = totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;	//总页数
		
		StringBuffer sb = new StringBuffer();
		//首页
		sb.append("<li><a href='main?page=1'>首页</a></li>");
		//上一页
		if(currentPage ==1){
			sb.append("<li class ='disabled'><a href='#'>上一页</a></li>");
		}else{
			sb.append("<li><a href='main?page="+(currentPage-1)+"'>上一页</a></li>");
		}
		
		//中间显示5页
		for(int i =currentPage-2;i<=currentPage+2;i++){
			if(i<1 || i>totalPage){
				continue;
			}
			if(i==currentPage){
				sb.append("<li class ='active'><a href='#'>"+i+"</a></li>");
			}else{
				sb.append("<li><a href='main?page="+i+"'>"+i+"</a></li>");
			}
		}
		
		
		//下一页
		if(currentPage ==totalPage){
			sb.append("<li class ='disabled'><a href='#'>下一页</a></li>");
		}else{
			sb.append("<li><a href='main?page="+(currentPage+1)+"'>下一页</a></li>");
		}
		
		//尾页
		sb.append("<li><a href='main?page="+totalPage+"'>尾页</a></li>");
		
		return sb.toString();
	}

	
	
}
