package com.focus.jdbc.chap06.sec02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.focus.jdbc.model.Book;
import com.focus.jdbc.util.DbUtil;

public class Demo2 {

	private static DbUtil dbUtil = new DbUtil();

	private static int addBook(Book book) throws Exception {

		Connection con = dbUtil.getCon();
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setFloat(2, book.getPrice());
		ps.setString(3, book.getAuthor());
		ps.setInt(4, book.getBookType());
		File context = book.getContext();	//获取文本文件
		InputStream is = new FileInputStream(context);
		
		ps.setAsciiStream(5, is, (int)context.length());	
		/*mysql的jar中没有ps.setBinaryStream(int,InputStream,long)的方法(只有最后一个参数为int的)，而sql包有long的，file.length也是long型，所以编译不报错，运行报错。 
		知道原因就很好解决了，只需要加一个强转 
		ps.setCharacterStream(2, reader, (int)file.length());就ok啦，*/
		
		File pic = book.getPic();	//获取图片文件
		InputStream is2 = new FileInputStream(pic);
		ps.setBlob(6, is2, pic.length());
		
		int result = ps.executeUpdate();
		dbUtil.close(ps, con);
		return result;

	}
	
	private static void getBook(int id) throws Exception {

		Connection con = dbUtil.getCon();
		String sql = "select * from t_book where id =?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			String bookName = rs.getString("bookName");
			float price = rs.getFloat("price");
			String author = rs.getString("author");
			int bookTypeId = rs.getInt("bookTypeId");
			//获取文本内容
			Clob c = rs.getClob("context");
			String context = c.getSubString(1, (int) c.length());
			//获取图片内容
			Blob b = rs.getBlob("pic");
			byte[] bs = b.getBytes(1, (int) b.length());
			FileOutputStream fos = new FileOutputStream("d:/pic2.jpg");
			fos.write(bs);
			fos.close();
			
			System.out.println("图书id:"+id);
			System.out.println("图书名称："+bookName);
			System.out.println("图书价格："+price);
			System.out.println("图书作者："+author);
			System.out.println("图书类型："+bookTypeId);
			System.out.println("图书简介："+context);
			
		}
	}

	public static void main(String[] args) throws Exception {
	/*	File context = new File("c:/helloWorld.txt");
		File pic = new File("c:/pic1.jpg");
		Book book = new Book("心悦君兮君不知", 188, "佚名", 1, context,pic);
		int result = addBook(book);
		if(result==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}*/
		
		getBook(110018);
		
	}
}