package com.example.page_test_1;

import info.androidhive.slidingmenu.R;

import java.io.FileNotFoundException;
import java.util.Calendar;

import org.json.JSONObject;

import com.example.api.API_1;
import com.example.api.API_1.OnFailListener;
import com.example.api.API_1.OnSuccessListener;
import com.example.bean.AuthResponseBean;
import com.example.bean.MemberInfoRequestBean;
import com.example.page_test_1.Page_test_1.AsteriskPasswordTransformationMethod;
import com.example.util.Tool;
import com.google.gson.Gson;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
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
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class page_2_test extends Activity 
{
   Button dateButton;
   Calendar calendar;
   int mYear, mMonth, mDay;
   TextView dateText;
   DatePickerDialog datePickerDialog;
   ImageView mImg;
   DisplayMetrics mPhone;
   
   final static int CAMERA = 66 ;
   final static int PHOTO = 99 ;
   
   final static String BOY = "01" ;
   final static String GIRL = "02" ;
   final static String DEFAULT_IMG_FORMAT = "jpg" ;
   
   //儲存性別
   String sex  ;   
   //儲存個人圖片的圖示
   String pic = null ;   
   
   
   ProgressDialog progressDialog ;
   EditText AskerAccount,Askerpassword,Askername,Email,Askerpassword2;    
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.page_2_test);
      Email = (EditText)findViewById(R.id.PersonName) ;
      AskerAccount=(EditText)findViewById(R.id.editText_account);
      Askerpassword=(EditText)findViewById(R.id.editText_password);
      Askerpassword2=(EditText)findViewById(R.id.editText_password_2);
      Askername = (EditText)findViewById(R.id.name_edit);
      Askerpassword.setTransformationMethod(new AsteriskPasswordTransformationMethod());
      Askerpassword2.setTransformationMethod(new AsteriskPasswordTransformationMethod());
      
	//initial ProgressDialog
	progressDialog = new ProgressDialog(this) ;
	progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
	//progressDialog.setCancelable(false);
      
      
////it isi for birthday!!      
      calendar = Calendar.getInstance();
      mYear = calendar.get(Calendar.YEAR);
      mMonth = calendar.get(Calendar.MONTH);
      mDay = calendar.get(Calendar.DAY_OF_MONTH);
      dateText = (TextView)findViewById(R.id.dateText);
      dateButton = (Button)findViewById(R.id.button_date);
      dateButton.setOnClickListener(new OnClickListener(){
          @Override
          public void onClick(View view) {
              showDialog(0);
              datePickerDialog.updateDate(mYear, mMonth, mDay);
          }
          
      });
      
     //photo button
      Button button1=(Button)findViewById(R.id.button1);
                
    mPhone = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(mPhone);
            
      mImg = (ImageView) findViewById(R.id.img);
      Button mCamera = (Button) findViewById(R.id.camera);
      Button mPhoto = (Button) findViewById(R.id.photo);
      
      
      button1.setOnClickListener(new Button.OnClickListener(){
  		public void onClick(View arg0) {
  			
  			//這邊安插登入API的呼叫 , 準備註冊使用的 bean
  			MemberInfoRequestBean bean = new MemberInfoRequestBean() ; 			
  			
  			bean.setAccount(AskerAccount.getText().toString());  			  	  			
  			bean.setPassword( Tool.md5(  Askerpassword.getText().toString() )  );
  			bean.setName(Askername.getText().toString());
  			bean.setEmail(Email.getText().toString());
  			bean.setBirthtime(dateText.getText().toString());
  			bean.setSex(sex);
  			
  			progressDialog.setTitle("註冊");
  			progressDialog.setMessage("處理中");
  			
  			//判斷是否有圖片資料需要上傳
  			if(pic!=null) {
  				bean.setExtension(DEFAULT_IMG_FORMAT);
  				bean.setPic(pic);
  				progressDialog.setMessage("上傳圖片需等待較多時間,處理中...");
  			}			
  						
  			API_1 api = new API_1() ;
  			
  			api.setOnSuccessListener(new OnSuccessListener() {
  				//回傳成功之處理
  				@Override
  				public void onSucess(JSONObject result) {
  					
  					//解析結果並寫入 sessionid
  					Gson gson = new Gson();						
  					AuthResponseBean bean = gson.fromJson(result.toString(), AuthResponseBean.class) ;						
  					Tool.setSessionid(bean.getSessionid()) ;					
  										
  					progressDialog.dismiss() ;
  					
  					//take out the information user send in
  					Intent intent = new Intent();
  					intent.setClass(page_2_test.this, page3.class);
  					startActivity(intent); 
  					page_2_test.this.finish();
  				}								
  			});
  			
  			api.setOnFailListener(new OnFailListener(){
  				//回傳失敗之處理
  				@Override
  				public void onFail(String errorMsg) {
  					progressDialog.dismiss() ;
  					Toast.makeText(page_2_test.this,"註冊失敗", Toast.LENGTH_LONG).show(); 
  				}					
  			}) ;
  			
  			
  			api.register(bean);
  			
  			
  			progressDialog.show();			
  						
   
  		}}
  		);
/////it is for sexual
	 Spinner spinner = (Spinner) findViewById(R.id.spinnner);
        //建立一個ArrayAdapter物件，並放置下拉選單的內容
     ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,new String[]{"Boy","Girl"});
        //設定下拉選單的樣式
     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     spinner.setAdapter(adapter);
     
        //設定項目被選取之後的動作
     spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
         public void onItemSelected(AdapterView adapterView, View view, int position, long id){
             Toast.makeText(page_2_test.this, "您選擇"+adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
             
             if("Boy".equals(adapterView.getSelectedItem().toString())) {
            	 sex = BOY ;
             }
             else if("Girl".equals(adapterView.getSelectedItem().toString())) {
            	 sex = GIRL ;
             }
             
         }
         public void onNothingSelected(AdapterView arg0) {
             Toast.makeText(page_2_test.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();             
         }
     });
     
      mCamera.setOnClickListener(new OnClickListener()
      {
         @Override
         public void onClick(View v) 
         {
         //嚙踝�嚙踝蕭鞊ｇ蕭嚙踐����寡��嚙踝蕭�對蕭嚙踝�嚙踝蕭�抬蕭嚙賢�D嚙賤�謆蕭�哨蕭嚙賣嚙踝蕭��startActivityForResult���蕭�畫questCode嚙質嚙踝蕭瞉�嚙踝蕭蹎冪嚙踝��望�澗��綽嚙踝蕭豯佗蕭�嚙踝蕭�拆�嚙賢
        	 //nActivityResult
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
         //嚙踝�嚙踝蕭鞎�嚙質�嚙踝蕭�蕭嚙踝��tartActivityForResult���蕭�畫questCode嚙質嚙踝蕭瞉�嚙踝蕭蹎冪�綜筐蹓蕭鞎蕭�綽嚙踝蕭豯佗蕭��蕭�裳ActivityResult
         Intent intent = new Intent();
         intent.setType("image/*");
         intent.setAction(Intent.ACTION_GET_CONTENT);
         startActivityForResult(intent, PHOTO);
         }
      });
   }
   
   
   
   
        
   //嚙踝��望�澗�嚙踐�蹓蕭謘潘蕭嚙踝嚙踝蕭瞉����嚙�   
   @Override 
   protected void onActivityResult(int requestCode, int resultCode,Intent data)
   {
      //嚙踝�equestCode嚙賣�謘蕭�秋�嚙賜硃嚙踝蕭賹���嚙踝蕭�蕭嚙質��蕭�綜�嚙賣�嚙賢��對蕭data��蹌要ull
      if ((requestCode == CAMERA || requestCode == PHOTO ) && data != null)
      {
         //嚙踐□嚙踝蕭�蕭�嚙線ri
         Uri uri = data.getData();
         ContentResolver cr = this.getContentResolver();
                      
         try
         {
	         //bitmap the pthto 
	         Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
	
	         //嚙賣�謘蕭�蕭嚙賜捂撣蕭�穿蕭嚙踝蹌哨蕭皜賂蕭��蕭��
	         //ScalePic嚙賣�謘蕭謘橘蕭嚙質�蹓選蕭�蛛�穿蕭嚙�     
	         if(bitmap.getWidth()>bitmap.getHeight()) {
	        	 ScalePic(bitmap,mPhone.heightPixels);
	         }        	 
	         else {
	        	 ScalePic(bitmap,mPhone.widthPixels);
	         }
	         
	         pic = Tool.encode_to_base64(bitmap) ;
	         
         } 
         catch (FileNotFoundException e)
         {
         }
      }
                
      super.onActivityResult(requestCode, resultCode, data);
   }
        
   private void ScalePic(Bitmap bitmap,int phone)
   {
      //�格��蕭嚙踐�頨恬蕭嚙�  
	   float mScale = 1 ;
                
      //��嚙踝蕭謘橘蕭��瞍脫�啾�嚙踝�嚙賣��撞嚙踝嚙賡�潸嚙賣�嚙踝蕭銵�蕭嚙賣����抬蕭嚙踝�蕭隞ageView嚙踝蕭
      if(bitmap.getWidth() > phone )
      {
         //嚙賣�謘�澗��伍�嚙�        
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
   @Override
   protected Dialog onCreateDialog(int id) {
       datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month,
                   int day) {
               mYear = year;
               mMonth = month;
               mDay = day;
               dateText.setText(setDateFormat(year,month,day)); 
           }
           
       }, mYear,mMonth, mDay);
       
       return datePickerDialog;
   }
   
   private String setDateFormat(int year,int monthOfYear,int dayOfMonth){
       return String.valueOf(year) + "-"
       + String.valueOf(monthOfYear + 1) + "-"
       + String.valueOf(dayOfMonth);
   }
 //this func is to set the password edittext to show in ****
 	public class AsteriskPasswordTransformationMethod extends PasswordTransformationMethod {
 	    @Override
 	    public CharSequence getTransformation(CharSequence source, View view) {
 	        return new PasswordCharSequence(source);
 	    }

 	    private class PasswordCharSequence implements CharSequence {
 	        private CharSequence mSource;
 	        public PasswordCharSequence(CharSequence source) {
 	            mSource = source; // Store char sequence
 	        }
 	        public char charAt(int index) {
 	            return '*'; // This is the important part
 	        }
 	        public int length() {
 	            return mSource.length(); // Return default
 	        }
 	        public CharSequence subSequence(int start, int end) {
 	            return mSource.subSequence(start, end); // Return default
 	        }
 	    }
 	};
}


