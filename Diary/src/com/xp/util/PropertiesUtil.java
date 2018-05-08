package com.xp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	/**
	 * 通过键获取值
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		
		Properties pro = new Properties();
		
		//将文件导入输入流
		InputStream is = new PropertiesUtil().getClass().getResourceAsStream("/diary.properties");
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (String) pro.get(key);
	}
	
}
