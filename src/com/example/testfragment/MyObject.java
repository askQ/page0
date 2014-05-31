package com.example.testfragment;

import java.io.Serializable;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class MyObject  implements Serializable{
	String  titleFromEdittext;
    String UriFroFramgnet;
    String DetailFromEdittext;
	/*
	 this object to save  some property  that you get from fragment 
	 */
	public MyObject(String titleFrom, String DetailFrom,String Urifrom) {
		 titleFromEdittext=titleFrom;
		 UriFroFramgnet=Urifrom;
		 DetailFromEdittext=DetailFrom;
	}/*
	//以下是為了Parcelable兒家的
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}*/
}
