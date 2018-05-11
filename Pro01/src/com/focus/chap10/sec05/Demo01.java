package com.focus.chap10.sec05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Demo01 {
	public static void main(String[] args) throws Exception {
		
		File file = new File("c://测试文件.txt");
		Reader reader = new FileReader(file);
		char c[] = new char[1024];
		int len = reader.read(c);
		reader.close();
		
		System.out.println("读取的文件内容为："+new String(c,0,len));
		
		
	}
}
