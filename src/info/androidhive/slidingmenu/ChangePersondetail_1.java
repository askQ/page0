package info.androidhive.slidingmenu;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.view.View.OnClickListener;

public class ChangePersondetail_1 extends Activity 
{
   
   private ImageView mImg;
   private DisplayMetrics mPhone;
   private final static int CAMERA = 66 ;
   private final static int PHOTO = 99 ;
   private Button change;
   private EditText et1;
   private EditText et2;
   private EditText et3;
   private EditText et4;
   private EditText et5;
   private EditText et6;
   

        
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_changeperson_1);
      et1 = (EditText) findViewById(R.id.UserId);
      et2 = (EditText) findViewById(R.id.password);
      et3 = (EditText) findViewById(R.id.mail);
      et4 = (EditText) findViewById(R.id.age);
      et5 = (EditText) findViewById(R.id.sex);
      et6 = (EditText) findViewById(R.id.name);
      change = (Button) findViewById(R.id.button7);
      

                
      //�蕭嚙踝蕭�蕭�恬蕭嚙賣嚙�   
      mPhone = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(mPhone);
            
      mImg = (ImageView) findViewById(R.id.img);
      Button mCamera = (Button) findViewById(R.id.camera);
      Button mPhoto = (Button) findViewById(R.id.photo);
      
      //���

                
      mCamera.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View v) 
         {
         //嚙踝�嚙踝蕭鞊ｇ蕭嚙踐����寡��嚙踝蕭�對蕭嚙踝�嚙踝蕭�抬蕭嚙賢�D嚙賤�謆蕭�哨蕭嚙賣嚙踝蕭��startActivityForResult���蕭�畫questCode嚙質嚙踝蕭瞉�嚙踝蕭蹎冪嚙踝��望�澗��綽嚙踝蕭豯佗蕭�嚙踝蕭�拆�嚙賢nActivityResult
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
      
      
      change.setOnClickListener(new Button.OnClickListener() {
          
          @Override
          public void onClick(View arg0) {
                  /*取得输入框中的内容*/
          String et1Str = et1.getText().toString();
          String et2Str = et2.getText().toString();
          String et3Str = et3.getText().toString();
          String et4Str = et4.getText().toString();
          String et5Str = et5.getText().toString();
          String et6Str = et6.getText().toString();
          //创建Intent对象，参数分别为上下文，要跳转的Activity类
          Intent intent = new Intent(ChangePersondetail_1.this, ChangePersondetail.class);
          //将要传递的值附加到Intent对象
          intent.putExtra("et1", et1Str);
          intent.putExtra("et2", et2Str);
          intent.putExtra("et3", et3Str);
          intent.putExtra("et4", et4Str);
          intent.putExtra("et5", et5Str);
          intent.putExtra("et6", et6Str);
          //启动该Intent对象，实现跳转
          startActivity(intent);
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
         //嚙賣�謘�澗��伍�嚙�         mScale = (float)phone/(float)bitmap.getWidth();
                      
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