package com.xp.model;

import java.util.Date;

public class Diary {
	
	private int diaryId;
	private String title;
	private String content;
	private int typeId=-1;
	private Date releaseDate;
	private String releaseDateStr;
	private int diaryCount;
	private String TypeName;
	
	
	
	public Diary(String title, String content, int typeId) {
		super();
		this.title = title;
		this.content = content;
		this.typeId = typeId;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public String getReleaseDateStr() {
		return releaseDateStr;
	}
	public void setReleaseDateStr(String releaseDateStr) {
		this.releaseDateStr = releaseDateStr;
	}
	public int getDiaryCount() {
		return diaryCount;
	}
	public void setDiaryCount(int count) {
		this.diaryCount = count;
	}
	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Diary(int diaryId, String title, String content, int typeId,
			Date releaseDate) {
		super();
		this.diaryId = diaryId;
		this.title = title;
		this.content = content;
		this.typeId = typeId;
		this.releaseDate = releaseDate;
	}
	
	public Diary() {
		super();
	}
	
	
	
}
