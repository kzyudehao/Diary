package com.focus.chap05.sec01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSimpleDateFormat {
	
	
	/**
	 * 将日期对象格式化为指定格式的日期字符串
	 * @param date		传入的日期对象
	 * @param format	格式字符串
	 * @return			返回日期字符串
	 */
	public static String formatDate(Date date,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String result ="";
		if(date!=null){
			result = sdf.format(date);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		/*Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);
		System.out.println(time);*/
		
		String t =formatDate(new Date(),"yyyy-MM-dd HH:mm:ss");
		System.out.println(t);
		
		
	}
}
