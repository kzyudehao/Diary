package com.focus.chap10.sec03;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * 按文件大小读入
 * @author root
 *
 */
public class Demo01 {
	public static void main(String[] args) throws Exception {
		
		File file = new File("c://测试文件.txt");
		int len = (int) file.length();
		InputStream is = new FileInputStream(file);
		
		byte[] b= new byte[len];
		is.read(b);
		is.close();
		
		System.out.println("读取到的文件内容为："+new String(b));
	}
}
