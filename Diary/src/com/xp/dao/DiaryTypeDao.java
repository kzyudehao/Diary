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
}
