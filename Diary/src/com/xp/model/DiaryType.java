package com.xp.model;

public class DiaryType {
	
	private int diaryTypeId;
	private String typeName;
	private int diaryTypeCount;
	
	
	public int getDiaryTypeId() {
		return diaryTypeId;
	}
	public void setDiaryTypeId(int diaryTypeId) {
		this.diaryTypeId = diaryTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getDiaryTypeCount() {
		return diaryTypeCount;
	}
	public void setDiaryTypeCount(int diaryTypeCount) {
		this.diaryTypeCount = diaryTypeCount;
	}
	public DiaryType(String typeName) {
		super();
		this.typeName = typeName;
	}
	public DiaryType() {
		super();
	}
	
	
}
