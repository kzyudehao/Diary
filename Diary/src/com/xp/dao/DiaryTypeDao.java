package com.xp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.xp.model.DiaryType;

public class DiaryTypeDao {
	
	
	
	/**
	 * 获取日志类型统计列表
	 * @param con
	 * @return
	 */
	public List<DiaryType> getDiaryTypeCountList(Connection con) throws Exception{
		List<DiaryType> diaryTypeCountList = new ArrayList<DiaryType>();
		String sql = "SELECT diaryTypeId,typeName,COUNT(diaryId) as diaryTypeCount FROM t_diary RIGHT JOIN t_diarytype ON t_diary.typeId=t_diarytype.diaryTypeId GROUP BY typeName;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			DiaryType diaryType = new DiaryType();
			diaryType.setDiaryTypeId(rs.getInt("diaryTypeId"));
			diaryType.setTypeName(rs.getString("typeName"));
			diaryType.setDiaryTypeCount(rs.getInt("diaryTypeCount"));
			diaryTypeCountList.add(diaryType);
		}
		
		return diaryTypeCountList;
	}
	
	/**
	 * 获取日志类别完整列表
	 * @param con
	 * @return
	 * @throws Exception
	 */
	public List<DiaryType> getDiaryTypeList(Connection con)throws Exception{
		List<DiaryType> diaryTypeList = new ArrayList<DiaryType>();
		String sql = "select * from t_diaryType ";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			DiaryType diaryType = new DiaryType();
			diaryType.setDiaryTypeId(rs.getInt("diaryTypeId"));
			diaryType.setTypeName(rs.getString("typeName"));
			diaryTypeList.add(diaryType);
		}
		return diaryTypeList;
	}
	
	/**
	 * 添加日志类别
	 * @param con
	 * @param diaryTypeName
	 * @return
	 * @throws Exception
	 */
	public int diaryTypeAdd(Connection con,DiaryType diaryType) throws Exception{
		String sql="insert into t_diarytype value(null,?)";
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, diaryType.getTypeName());
		return ps.executeUpdate();
	}
	
	/**
	 * 修改日志类别
	 * @param con
	 * @param diaryType
	 * @return
	 * @throws Exception
	 */
	public int diaryTypeUpdate(Connection con,DiaryType diaryType)throws Exception{
		
		String sql="update t_diarytype set typeName =? where diaryTypeId = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, diaryType.getTypeName());
		ps.setInt(2, diaryType.getDiaryTypeId());
		return ps.executeUpdate();
	}
	
	/**
	 * 修改日志类别前，通过类别编码获取完整日志类别对象
	 * @param con
	 * @param diaryTypeId
	 * @return
	 * @throws Exception
	 */
	public DiaryType diaryTypeShow(Connection con,String diaryTypeId)throws Exception{
		
		String sql="select * from t_diarytype where diaryTypeId = ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, diaryTypeId);
		ResultSet rs = ps.executeQuery();
		DiaryType diaryType = new DiaryType();
		if(rs.next()){
			diaryType.setDiaryTypeId(rs.getInt("diaryTypeId"));
			diaryType.setTypeName(rs.getString("typeName"));
		}
		return diaryType;
	}
	
	/**
	 * 删除日志类别
	 * @param con
	 * @param diaryTypeId
	 * @return
	 * @throws Exception
	 */
	public int diaryTypeDelete(Connection con,String diaryTypeId) throws Exception{
		String sql = "delete from t_diaryType where diaryTypeId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, diaryTypeId);
		return ps.executeUpdate();
	}
}
