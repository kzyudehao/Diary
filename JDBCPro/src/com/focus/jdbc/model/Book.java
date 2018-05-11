package com.focus.jdbc.model;

import java.io.File;

public class Book {
	private int id;
	private String bookName;
	private float price;
	private String author;

	private int bookType;
	private File context;
	private File pic;
	
	
	public Book(String bookName, float price, String author, int bookType, File context, File pic) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookType = bookType;
		this.context = context;
		this.pic = pic;
	}
	public File getPic() {
		return pic;
	}
	public void setPic(File pic) {
		this.pic = pic;
	}
	public File getContext() {
		return context;
	}
	public void setContext(File context) {
		this.context = context;
	}
	
	
	
	
	public Book(String bookName, float price, String author, int bookType, File context) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookType = bookType;
		this.context = context;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", price=" + price + ", author=" + author + ", bookType="
				+ bookType + "]";
	}
	public Book(int id, String bookName, float price, String author, int bookType) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookType = bookType;
	}
	public Book(String bookName, float price, String author, int bookType) {
		super();
		this.bookName = bookName;
		this.price = price;
		this.author = author;
		this.bookType = bookType;
	}
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookType() {
		return bookType;
	}
	public void setBookType(int bookType) {
		this.bookType = bookType;
	}
	
	
}
