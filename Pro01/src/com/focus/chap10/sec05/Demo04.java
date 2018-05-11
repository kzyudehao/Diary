package com.focus.chap10.sec05;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Demo04 {
	public static void main(String[] args) throws Exception {
		
		File file = new File("c://测试文件.txt");
		Writer wr = new FileWriter(file,true);	//设置追加写入
		wr.write("\r\n"+"念君成疾，药石无医");
		wr.close();
	}
}
