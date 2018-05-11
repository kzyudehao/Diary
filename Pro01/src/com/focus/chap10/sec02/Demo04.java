package com.focus.chap10.sec02;

import java.io.File;

public class Demo04 {
	
	public static void fileList(File file){
		if(file!=null){
			if(file.isDirectory()){	//是目录
				System.out.println(file); 	//打印目录
				File[] files = file.listFiles();
				if(files!=null){
					for(int i=0;i<files.length;i++){
						fileList(files[i]);
					}
				}
			}else{					
				System.out.println(file);//是文件,直接打印
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		File f = new File("E://TSearch_V5.9_XiTongZhiJia");
		fileList(f);
		
		
		
		
	}
}
