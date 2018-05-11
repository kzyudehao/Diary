package com.focus.model;
/**
 * 图书类对象
 * @author root
 *
 */
public class Book {
	private int id;
	private String bookName;
	private String author;
	private String sex;
	private float price;
	private int bookTypeId;
	private String bookDesc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String bookName, String author, String sex, float price, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
	}
	public Book(String bookName, String author, int bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}
	public Book(int id, String bookName, String author, String sex, float price, int bookTypeId, String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}

	
	
	
}
