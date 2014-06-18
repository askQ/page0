package com.example.util;

import java.security.MessageDigest;

public class Tool {
	
	private static String sessionid ;
	
	//設定 or 讀取 sessionid 用函式
	public static String getSessionid() {
		return sessionid;
	}

	public static void setSessionid(String sessionid) {
		Tool.sessionid = sessionid;
	}

	//MD5 加密函式 , 回傳 16 進位字串
	public static String md5(String str) {				
		MessageDigest md5;
		String res = null ;		
		try {			
			byte[] bytesOfMessage = str.getBytes("utf-8");			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			//get the md5 result
			byte[] thedigest = md.digest(bytesOfMessage);
			
			StringBuilder hexString = new StringBuilder() ;			
			for (int i=0;i<thedigest.length;i++) {
				//reslove byte the least two byte and translate to hex String
	    		hexString.append(Integer.toHexString( thedigest[i]  & 0xff ) );
	    	}			
			return hexString.toString() ;			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	

}
