/* origual data show in edittext account,password,mail,birth,sex,name
 *                      textview sexual dateText
 * 
 * 
 * 
 * */

package info.androidhive.slidingmenu;

import info.androidhive.slidingmenu.R;

import java.io.FileNotFoundException;
import java.util.Calendar;

import com.example.page_test_1.page_2_test;
import com.example.util.Tool;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
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
import android.util.Log;
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

public class ChangePersondetail_1 extends Activity 
{
   
   private ImageView mImg;
   Calendar calendar;
   DatePickerDialog datePickerDialog;
   int mYear, mMonth, mDay;
   private DisplayMetrics mPhone;
   private final static int CAMERA = 66 ;
   private final static int PHOTO = 99 ;
   private Button change;
   private EditText password;
   private EditText mail;
   private EditText name;
   
   Uri picuri ;
         
   TextView dateText ;
   
   private String sex ;
        
   @Override
   protected void onCreate(Bundle savedInstanceState) 
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_changeperson_1);
     
      password = (EditText) findViewById(R.id.password);
      mail = (EditText) findViewById(R.id.mail);
      name = (EditText) findViewById(R.id.name);
      change = (Button) findViewById(R.id.button7);
      dateText = (TextView)findViewById(R.id.dateText);
      mImg = (ImageView) findViewById(R.id.img) ;
  ////it isi for birthday!!      
      calendar = Calendar.getInstance();
      mYear = calendar.get(Calendar.YEAR);
      mMonth = calendar.get(Calendar.MONTH);
      mDay = calendar.get(Calendar.DAY_OF_MONTH);
      Button dateButton = (Button)findViewById(R.id.button_date);
      dateButton.setOnClickListener(new OnClickListener(){
          @Override
          public void onClick(View view) {
              showDialog(0);
              datePickerDialog.updateDate(mYear, mMonth, mDay);
          }
          
      });
                
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
           //   Toast.makeText(this, "您選擇"+adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
        	  sex = adapterView.getSelectedItem().toString() ; 
          }
          public void onNothingSelected(AdapterView arg0) {
            //  Toast.makeText(page_2_test.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
          }
      });
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
        	  
          String s_password = password.getText().toString();
          String s_mail = mail.getText().toString();
          String s_birthtime = dateText.getText().toString();
          String s_sex = sex ;
          String s_name = name.getText().toString();
                    
          
          //创建Intent对象，参数分别为上下文，要跳转的Activity类
          Intent intent = new Intent(ChangePersondetail_1.this, ChangePersondetail.class);
          //将要传递的值附加到Intent对象
          intent.putExtra("password",s_password);
          intent.putExtra("mail",s_mail);
          intent.putExtra("birthtime",s_birthtime);
          intent.putExtra("sex",s_sex);
          intent.putExtra("name",s_name);
          intent.putExtra("picuri",picuri) ;
                   
          
          //启动该Intent对象，实现跳转
          startActivity(intent);
          
          
          }
  });
   }
   
   
   
   
        
   //嚙踝��望�澗�嚙踐�蹓蕭謘潘蕭嚙踝嚙踝蕭瞉����嚙� 
   @Override 
   protected void onActivityResult(int requestCode, int resultCode,Intent data)
   {
      
      if ((requestCode == CAMERA || requestCode == PHOTO ) && data != null)
      {
         
         Uri uri = data.getData();
         ContentResolver cr = this.getContentResolver();
                      
         try
         {
	         Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
	           
	         if(bitmap.getWidth()>bitmap.getHeight()) {
	        	 Tool.scalePic(mImg,bitmap,mPhone.heightPixels);
	         }                                                          
	         else {
	        	 Tool.scalePic(mImg,bitmap,mPhone.widthPixels);
	         }
	         
	         picuri = uri ;
	         
         } 
         catch (FileNotFoundException e)
         {
         }
      }
                
      super.onActivityResult(requestCode, resultCode, data);
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
       return String.valueOf(year) + "/"
       + String.valueOf(monthOfYear + 1) + "/"
       + String.valueOf(dayOfMonth);
   }
}
