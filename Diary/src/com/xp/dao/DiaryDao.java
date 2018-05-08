package com.xp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xp.model.Diary;
import com.xp.model.PageBean;
import com.xp.util.DateUtil;
import com.xp.util.StringUtil;

public class DiaryDao {
	
	/**
	 * 查询所有日志
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public List<Diary> getDiary(Connection con,PageBean pageBean,Diary s_diary) throws Exception{
		
		List<Diary> diaryList = new ArrayList<Diary>();
		StringBuffer sb = new StringBuffer("select * from t_diary t1,t_diarytype t2 where t1.typeId = t2.diaryTypeId ");
		if(s_diary.getTitle()!=null){
			sb.append(" and t1.title like '%"+s_diary.getTitle()+"%'");
		}
		
		if(s_diary.getTypeId()!=-1){
			sb.append(" and t1.typeId='"+s_diary.getTypeId()+"'");
		}
		if(StringUtil.isNotEmpty(s_diary.getReleaseDateStr())){
			
			sb.append(" and DATE_FORMAT(t1.releaseDate,'%Y年%m月')='"+s_diary.getReleaseDateStr()+"'");
		}
		
		sb.append("order by t1.releaseDate desc ");
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getPageSize());
		}
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Diary diary = new Diary();
			diary.setDiaryId(rs.getInt("diaryId"));
			diary.setTitle(rs.getString("title"));
			diary.setContent(rs.getString("content"));
			diary.setReleaseDate(DateUtil.formatString(rs.getString("releaseDate"), "yyyy-MM-dd HH:mm:ss"));
			diaryList.add(diary);
		}
		return diaryList;
		
	}
	
	/**
	 * 按日志类型统计记录数
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public int getDiaryCount(Connection con,Diary s_diary) throws Exception{
		StringBuffer sb = new StringBuffer("select count(*) as total from t_diary t1,t_diarytype t2 where t1.typeId = t2.diaryTypeId ");
		
		if(s_diary.getTitle()!=null){
			sb.append(" and t1.title like '%"+s_diary.getTitle()+"%'");
		}
		
		if(s_diary.getTypeId()!=-1){
			sb.append(" and t1.typeId='"+s_diary.getTypeId()+"'");
		}
		if(StringUtil.isNotEmpty(s_diary.getReleaseDateStr())){
			sb.append(" and DATE_FORMAT(t1.releaseDate,'%Y年%m月')='"+s_diary.getReleaseDateStr()+"'");
		}
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	
	/**
	 * 按创建日期统计日志数
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public List<Diary> getDiaryCountList(Connection con) throws Exception{
		List<Diary> diaryCountList = new ArrayList<Diary>();
		String sql = "SELECT DATE_FORMAT(releaseDate,'%Y年%m月') AS releaseDateStr,COUNT(*) AS diaryCount FROM t_diary GROUP BY DATE_FORMAT(releaseDate,'%Y年%m月') ORDER BY DATE_FORMAT(releaseDate,'%Y年%m月') DESC";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Diary diary = new Diary();
			diary.setReleaseDateStr(rs.getString("releaseDateStr"));
			diary.setDiaryCount(rs.getInt("diaryCount"));
			diaryCountList.add(diary);
		}
		
		return diaryCountList;
	}
	
	public Diary getDiaryInfo(Connection con,String diaryId) throws Exception{
		Diary diary = new Diary();
		StringBuffer sb = new StringBuffer("select * from t_diary t1,t_diarytype t2 where t1.typeId = t2.diaryTypeId and t1.diaryId=?");
		PreparedStatement ps = con.prepareStatement(sb.toString());
		ps.setString(1, diaryId);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			diary.setDiaryId(rs.getInt("diaryId"));
			diary.setTitle(rs.getString("title"));
			diary.setContent(rs.getString("content"));
			diary.setTypeId(rs.getInt("typeId"));
			diary.setReleaseDate(DateUtil.formatString(rs.getString("releaseDate"),"yyyy-MM-dd HH:ss:mm"));
			diary.setTypeName(rs.getString("typeName"));
		}
		return diary;
		
	}
	
	
}