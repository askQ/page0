package com.example.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;

public class Tool {
	
	private static String sessionid ;
	
	//設定 or 讀取 sessionid 用函式
	public static String getSessionid() {
		return sessionid;
	}

	public static void setSessionid(String sessionid) {
		Tool.sessionid = sessionid;
	}
	
	
	//調整圖片大小函式
	public static void scalePic(ImageView mImg,Bitmap bitmap,int phone) {
		
		float mScale = 1 ;	            
  
		if(bitmap.getWidth() > phone )  {
			Matrix mMat = new Matrix() ;
			mMat.setScale(mScale, mScale) ;
			Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),mMat,false);
			mImg.setImageBitmap(mScaleBitmap);
		}
		else {
			mImg.setImageBitmap(bitmap);
		}
		
	}
	
	//取得性別代號函式
	public static String getSexNum(String data) {		
		if("BOY".equals(data.toUpperCase())) {
			return "01" ;
		}
		else if("GIRL".equals(data.toUpperCase())) {
			return "02" ;
		}
		return null ;
	}
	
	
	//傳入圖片網址，回傳圖檔的 Bitmap , 須搭配 Handler or AsyncTask 使用
	public static Bitmap get_bitmap(String picurl) {
		
		Bitmap bitmap = null ;
		
		try {
			
			URL url = new URL(picurl);
			URLConnection conn = url.openConnection();
			
			HttpURLConnection httpConn = (HttpURLConnection)conn;
	        httpConn.setRequestMethod("GET");
	        httpConn.connect();

	        if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
	            InputStream inputStream = httpConn.getInputStream();

	            bitmap = BitmapFactory.decodeStream(inputStream);
	            inputStream.close();	            
	        }
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return bitmap ;
		
	}
	
	
	//傳入Bitmap參數 , 回傳JPG格式的Base64編碼結果
	public static String encode_to_base64(Bitmap bitmap){
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream() ;
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,bos) ;
        
        //get img btye array
        byte [] b_data = bos.toByteArray() ;
        
        //encode byte array to base64 format 
        byte [] new_data = Base64.encode(b_data, Base64.DEFAULT) ;
        
        StringBuilder buffer = new StringBuilder() ;
        
        //get byte data from base64 array , and save as char format 
        for(int i=0 ; i<new_data.length ; i++) {
        	buffer.append((char)new_data[i]) ;
        }
        
        return buffer.toString() ;
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
