/*account is the string account
 * password is the string password
 * there is 4 button button_login,button_regist,button_FBlogin,button_noname
 * there is 2 checkbox login_forever and remember me, @ the button of this activity
 * is the listener to detect whether the checkbox is selected or not
 * 
 * */

package com.example.page_test_1;

import java.security.MessageDigest;

import org.json.JSONObject;

import com.example.api.API_1;
import com.example.api.API_1.OnFailListener;
import com.example.api.API_1.OnSuccessListener;
import com.example.bean.AuthRequestBean;
import com.example.bean.AuthResponseBean;
import com.example.util.Tool;
import com.google.gson.Gson;

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Page_test_1 extends Activity {
	
	
	//save data resource and key
	private SharedPreferences sharedPref ;
	private static final String str_resource_key = "com.example.page_test_1.Page_test_1" ;
	private static final String str_login_ferver = "com.example.page_test_1.login_forver" ;
	private static final String str_remeber_me = "com.example.page_test_1.remerber_me" ;
	private static final String str_account = "com.example.page_test_1.account" ;
	private static final String str_password = "com.example.page_test_1.password" ;
	
	private static final String LOGIN_BY_APP = "01" ;
	
	
	public ProgressDialog progressDialog ;
	CheckBox login_forever,remember_me;
	public Button button_login,button_regist,button_FBlogin,button_noname;
	public EditText edittext_account,edittext_password;
	public TextView text;
	String account,password;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_test_1);
		
		
		//get resource 
		sharedPref = getSharedPreferences(str_resource_key, MODE_PRIVATE) ;
				
		
		edittext_account=(EditText)findViewById(R.id.edittext_account);
		edittext_password=(EditText)findViewById(R.id.edittext_password);
		edittext_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
		account=edittext_account.getText().toString();
		password=edittext_password.getText().toString();
		login_forever=(CheckBox)findViewById(R.id.checkBox1);
		remember_me=(CheckBox)findViewById(R.id.checkBox2);
		
		
		//initial ProgressDialog
		progressDialog = new ProgressDialog(this) ;
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		//progressDialog.setCancelable(false);
		
		//assign button
		button_regist=(Button)findViewById(R.id.button_regist);
		button_noname=(Button)findViewById(R.id.button_noname);
		button_FBlogin=(Button)findViewById(R.id.button_FBlogin);
		button_login=(Button)findViewById(R.id.button_login);		
		
		//嚙諄名嚙踝蕭嚙瞌嚙皚嚙踝蕭嚙編嚙璀嚙瘡嚙踝蕭嚙瘢嚙諄歹蕭嚙踝蕭|嚙談迎蕭嚙複伐蕭
		button_noname.setOnClickListener(new Button.OnClickListener(){
		public void onClick(View arg0) {
			Intent intent = new Intent();
			intent.setClass(Page_test_1.this, page_test_1_1.class);
			startActivity(intent); 
		//	Page_test_1.this.finish(); 
		}}
		);
		button_regist.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(Page_test_1.this, page_2_test.class);
				startActivity(intent); 
				Page_test_1.this.finish(); 
				
			}}
			);
		button_FBlogin.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				
			}}
			);
		
		button_login.setOnClickListener(new Button.OnClickListener(){			
			public void onClick(View arg0) {
				
				//這邊安插登入API的呼叫 , 準備登入使用的bean
				AuthRequestBean bean = new AuthRequestBean() ;				
				
				bean.setType(LOGIN_BY_APP);
				bean.setAccount(edittext_account.getText().toString());
				bean.setPassword(Tool.md5(edittext_password.getText().toString()));
				
				API_1 api = new API_1() ;
				
				api.setOnSuccessListener(new OnSuccessListener() {
					//回傳成功之處理
					@Override
					public void onSucess(JSONObject result) {
												
						//store info to resource
						SharedPreferences.Editor editor = sharedPref.edit();
						editor.putBoolean(str_login_ferver,login_forever.isChecked()) ;
						editor.putBoolean(str_remeber_me,remember_me.isChecked()) ;
												
						editor.putString(str_account,edittext_account.getText().toString()) ;
						editor.putString(str_password,edittext_password.getText().toString()) ;
						editor.commit() ;
						
						//解析結果並寫入 sessionid
						Gson gson = new Gson();						
						AuthResponseBean bean = gson.fromJson(result.toString(), AuthResponseBean.class) ;						
						Tool.setSessionid(bean.getSessionid()) ;
												
						progressDialog.dismiss() ;
						Intent intent = new Intent(Page_test_1.this, Page4_MainActivity.class);
						Page_test_1.this.startActivity(intent);
					}								
				});
				
				api.setOnFailListener(new OnFailListener(){
					//回傳失敗之處理
					@Override
					public void onFail(String errorMsg) {
						progressDialog.dismiss() ;
						Toast.makeText(Page_test_1.this,"登入失敗", Toast.LENGTH_LONG).show(); 
					}					
				}) ;
				
				api.login(bean);
				
				progressDialog.setTitle("登入");
				progressDialog.setMessage("處理中");
				progressDialog.show() ;
	
			}}
			);
		
		login_forever.setOnCheckedChangeListener(listener);
		remember_me.setOnCheckedChangeListener(listener);
		
				
		//check login_ferver , if true then update edittext 
		if(sharedPref.getBoolean(str_login_ferver,false)) {
			login_forever.setChecked(true);
			edittext_account.setText(sharedPref.getString(str_account,"")) ;
			edittext_password.setText(sharedPref.getString(str_password,"")) ;						
		}
		
				
		//check remember me , if true then update edittext 
		if(sharedPref.getBoolean(str_remeber_me,false)) {			
			remember_me.setChecked(true);
			edittext_account.setText(sharedPref.getString(str_account,"")) ;
			edittext_password.setText(sharedPref.getString(str_password,"")) ;
		}		
		
		//auto login
		if(sharedPref.getBoolean(str_login_ferver,false)) {
			button_login.performClick() ;
		}
		
		
	}

	
	//監聽user 是否有選取
	private CheckBox.OnCheckedChangeListener listener=new CheckBox.OnCheckedChangeListener()
	{
		public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
		{
			
			if( buttonView == login_forever && login_forever.isChecked()==false)
			{					 
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putBoolean(str_login_ferver,login_forever.isChecked()) ;
				editor.commit() ;
			}
			
			if( buttonView == remember_me && remember_me.isChecked()==false)
			{					
				SharedPreferences.Editor editor = sharedPref.edit();
				editor.putBoolean(str_remeber_me,remember_me.isChecked()) ;
				editor.commit() ;	
			}
		}
	};
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
