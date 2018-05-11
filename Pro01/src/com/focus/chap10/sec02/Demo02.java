package com.focus.chap10.sec02;

import java.io.File;

public class Demo02 {
	public static void main(String[] args) {
		
		File f = new File("c://java目录");
		boolean a = f.mkdir();
		
		if(a){
			System.out.println("目录创建成功");
		}else{
			System.out.println("目录创建失败");
		}
		
	}
}
