package com.xp.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5Util {
	
	public static String enCoderPwdMd5(String str) throws Exception{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64 = new BASE64Encoder();
		return base64.encode(md5.digest(str.getBytes("utf-8")));
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(enCoderPwdMd5("123456"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
