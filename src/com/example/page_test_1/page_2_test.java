package com.example.page_test_1;

import info.androidhive.slidingmenu.R;

import java.io.FileNotFoundException;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class page_2_test extends Activity 
{
   private ImageView mImg;
   private DisplayMetrics mPhone;
   private final static int CAMERA = 66 ;
   private final static int PHOTO = 99 ;
        
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.page_2_test);
      
    //photo button
      Button button1=(Button)findViewById(R.id.button1);
                
    mPhone = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(mPhone);
            
      mImg = (ImageView) findViewById(R.id.img);
      Button mCamera = (Button) findViewById(R.id.camera);
      Button mPhoto = (Button) findViewById(R.id.photo);
      
      
		button1.setOnClickListener(new Button.OnClickListener(){
		public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(page_2_test.this, page3.class);
			startActivity(intent); 
			page_2_test.this.finish(); 
		}}
		);
                
      mCamera.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View v) 
         {
         //嚙踝�嚙踝蕭鞊ｇ蕭嚙踐����寡��嚙踝蕭�對蕭嚙踝�嚙踝蕭�抬蕭嚙賢�D嚙賤�謆蕭�哨蕭嚙賣嚙踝蕭��startActivityForResult���蕭�畫questCode嚙質嚙踝蕭瞉�嚙踝蕭蹎冪嚙踝��望�澗��綽嚙踝蕭豯佗蕭�嚙踝蕭�拆�嚙賢
        	 //nActivityResult
         ContentValues value = new ContentValues();
         value.put(Media.MIME_TYPE, "image/jpeg");                                      
         Uri uri= getContentResolver().insert(Media.EXTERNAL_CONTENT_URI,
                                              value); 
         Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
         intent.putExtra(MediaStore.EXTRA_OUTPUT, uri.getPath());  
         startActivityForResult(intent, CAMERA);      
         }
      });
                
      mPhoto.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View v) 
         {
         //嚙踝�嚙踝蕭鞎�嚙質�嚙踝蕭�蕭嚙踝��tartActivityForResult���蕭�畫questCode嚙質嚙踝蕭瞉�嚙踝蕭蹎冪�綜筐蹓蕭鞎蕭�綽嚙踝蕭豯佗蕭��蕭�裳ActivityResult
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(intent, PHOTO);
         }
      });
   }
   
   
   
   
        
   //嚙踝��望�澗�嚙踐�蹓蕭謘潘蕭嚙踝嚙踝蕭瞉����嚙�   
   @Override 
   protected void onActivityResult(int requestCode, int resultCode,Intent data)
   {
      //嚙踝�equestCode嚙賣�謘蕭�秋�嚙賜硃嚙踝蕭賹���嚙踝蕭�蕭嚙質��蕭�綜�嚙賣�嚙賢��對蕭data��蹌要ull
      if ((requestCode == CAMERA || requestCode == PHOTO ) && data != null)
      {
         //嚙踐□嚙踝蕭�蕭�嚙線ri
         Uri uri = data.getData();
         ContentResolver cr = this.getContentResolver();
                      
         try
         {
         //�蕭嚙踝蕭�蕭�嚙踝蕭�冪Bitmap
         Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));

         //嚙賣�謘蕭�蕭嚙賜捂撣蕭�穿蕭嚙踝蹌哨蕭皜賂蕭��蕭��
         //ScalePic嚙賣�謘蕭謘橘蕭嚙質�蹓選蕭�蛛�穿蕭嚙�     
         if(bitmap.getWidth()>bitmap.getHeight())ScalePic(bitmap,
                                                          mPhone.heightPixels);
         else ScalePic(bitmap,mPhone.widthPixels);
         } 
         catch (FileNotFoundException e)
         {
         }
      }
                
      super.onActivityResult(requestCode, resultCode, data);
   }
        
   private void ScalePic(Bitmap bitmap,int phone)
   {
      //�格��蕭嚙踐�頨恬蕭嚙�  
	   float mScale = 1 ;
                
      //��嚙踝蕭謘橘蕭��瞍脫�啾�嚙踝�嚙賣��撞嚙踝嚙賡�潸嚙賣�嚙踝蕭銵�蕭嚙賣����抬蕭嚙踝�蕭隞ageView嚙踝蕭
      if(bitmap.getWidth() > phone )
      {
         //嚙賣�謘�澗��伍�嚙�        
    	  mScale = (float)phone/(float)bitmap.getWidth();
                      
         Matrix mMat = new Matrix() ;
         mMat.setScale(mScale, mScale);
                          
         Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap,
                                                   0,
                                                   0,
                                                   bitmap.getWidth(),
                                                   bitmap.getHeight(),
                                                   mMat,
                                                   false);
         mImg.setImageBitmap(mScaleBitmap);
      }
   else mImg.setImageBitmap(bitmap);
   }
}