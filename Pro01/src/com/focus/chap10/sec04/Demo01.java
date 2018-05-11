package com.focus.chap10.sec04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo01 {
	
	/**
	 * 缓冲方式
	 * @throws Exception
	 */
	public static void bufferedStream() throws Exception{
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("c://数据安全1.docx"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("c://复制的数据安全1.docx"));
		int temp =0;
		long startTime = System.currentTimeMillis();
		while((temp=bis.read())!=-1){
			bos.write(temp);
		}
		bis.close();
		bos.close();
		long endTime = System.currentTimeMillis();
		System.out.println("缓冲流方式消耗的时间："+(endTime-startTime));
		
	}
	
	/**
	 * 非缓冲方式
	 * @throws Exception
	 */
	public static void stream() throws Exception{
		InputStream is = new FileInputStream("c://数据安全.docx");
		OutputStream os = new FileOutputStream("c://复制的数据安全.docx");
		int temp =0;
		long startTime = System.currentTimeMillis();
		while((temp=is.read())!=-1){
			os.write(temp);
		}
		is.close();
		os.close();
		long endTime = System.currentTimeMillis();
		System.out.println("非缓冲流方式消耗的时间："+(endTime-startTime));
		
	}
	
	public static void main(String[] args) throws Exception {
		//stream();
		bufferedStream();
	}
}
