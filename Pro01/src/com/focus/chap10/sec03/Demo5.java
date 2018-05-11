package com.focus.chap10.sec03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
/**
 * 追加写入
 * @author root
 *
 */
public class Demo5 {
	public static void main(String[] args) throws Exception {
		
		File file = new File("c://测试文件.txt");
		OutputStream os = new FileOutputStream(file);
		String str = "山有木兮木有枝，心悦君兮君不知";
		byte b[] = str.getBytes();
		os.write(b);
		
	}
}
