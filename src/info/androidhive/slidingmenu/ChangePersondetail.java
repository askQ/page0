package info.androidhive.slidingmenu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;

import org.json.JSONObject;

import com.example.api.API_1;
import com.example.api.API_1.OnFailListener;
import com.example.api.API_1.OnSuccessListener;
import com.example.bean.MemberInfoRequestBean;
import com.example.bean.MemberInfoResponseBean;
import com.example.page_test_1.page_test_1_1;
import com.example.util.Tool;
import com.google.gson.Gson;

import android.R.string;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;




public class ChangePersondetail extends Activity {
	
	ImageView photo;
	private Button change;
	private Button submit;
	private TextView UserId;
	private TextView password1;
	private TextView mail1;
	private TextView birthtime1;
	private TextView sex1;
	private TextView name1;
	
	Bitmap bitmap ;
	private DisplayMetrics mPhone;

	
	public ChangePersondetail(){}
	
	  public void onCreate(Bundle savedInstanceState) {
		  	  

	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.fragment_changeperson);
	
			mPhone = new DisplayMetrics();
			getWindowManager().getDefaultDisplay().getMetrics(mPhone);
	        
	
			//photo of asker
			photo =(ImageView) findViewById(R.id.img);	
			//photo.setimg(...) ;
			
			        
			    
			//取得TextView对象
			UserId = (TextView) findViewById(R.id.UserId);
			password1 = (TextView) findViewById(R.id.password);
			mail1 = (TextView) findViewById(R.id.mail);
			birthtime1 = (TextView) findViewById(R.id.age);
			sex1 = (TextView) findViewById(R.id.sex);
			name1 = (TextView) findViewById(R.id.name);
			//取得启动该Activity的Intent对象
			Intent intent =getIntent();
			
			
			/*取出Intent中附加的数据*/
			
			Uri picuri = intent.getParcelableExtra("picuri") ;	
			
		    ContentResolver cr = this.getContentResolver();
		    
		    try {		    	
				bitmap = BitmapFactory.decodeStream(cr.openInputStream(picuri));								
				
				 if(bitmap.getWidth()>bitmap.getHeight()) {
					 Tool.scalePic(photo,bitmap,mPhone.heightPixels);
		         }                                                          
		         else {
		        	 Tool.scalePic(photo,bitmap,mPhone.widthPixels);
		         }
				
				photo.setImageBitmap(bitmap);
				
			} catch (Exception e) {				 
				e.printStackTrace();
			}
						
			final String password = intent.getStringExtra("password");
			final String mail = intent.getStringExtra("mail");
			final String birthtime = intent.getStringExtra("birthtime");
			final String sex = intent.getStringExtra("sex");
			final String name = intent.getStringExtra("name");
		
			
			password1.setText(password);
			mail1.setText(mail);
			birthtime1.setText(birthtime);
			sex1.setText(sex);
			name1.setText(name);
		        
		        
	        change=(Button) findViewById(R.id.button6);
	        change.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(ChangePersondetail.this, ChangePersondetail_1.class);
					startActivity(intent);
				}}
			);
	        
	        submit = (Button)findViewById(R.id.button7) ;
	        
	        submit.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					
					API_1 api = new API_1() ;
					
					MemberInfoRequestBean bean = new MemberInfoRequestBean() ;
					bean.setSessionid(Tool.getSessionid());
					
					if(!"".equals(password.trim())) {
						bean.setPassword(Tool.md5(password));
					}
					
					if(!"".equals(mail.trim())) {
						bean.setEmail(mail);
					}
					
					if(!"".equals(birthtime.trim())) {
						bean.setBirthtime(birthtime);
					}
					
					if(!"".equals(sex.trim())) {
						bean.setSex(Tool.getSexNum(sex));
					}
					
					if(!"".equals(name.trim())) {
						bean.setName(name);
					}
					
					if(bitmap!=null) {
						bean.setPic( Tool.encode_to_base64(bitmap) );
						bean.setExtension("jpg"); 
					}
					
					api.setOnSuccessListener(new OnSuccessListener() {
						//回傳成功之處理
						@Override
						public void onSucess(JSONObject result) {
							Toast.makeText(ChangePersondetail.this,"更新成功", Toast.LENGTH_LONG).show();
						}								
					});
					
					api.setOnFailListener(new OnFailListener(){
						//回傳失敗之處理
						@Override
						public void onFail(String errorMsg) {							
							Toast.makeText(ChangePersondetail.this,"更新失敗", Toast.LENGTH_LONG).show(); 
						}					
					}) ;
					
					api.edit_info(bean) ; 
					
					Intent intent = new Intent();
					intent.setClass(ChangePersondetail.this,Page4_MainActivity.class);					
					startActivity(intent);
					
				}}
			);
        
    }
	  
	  
	
}



