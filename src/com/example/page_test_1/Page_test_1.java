/*account is the string account
 * password is the string password
 * there is 4 button button_login,button_regist,button_FBlogin,button_noname
 * there is 2 checkbox login_forever and remember me, @ the button of this activity
 * is the listener to detect whether the checkbox is selected or not
 * 
 * */

package com.example.page_test_1;

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page_test_1 extends Activity {
	CheckBox login_forever,remember_me;
	public Button button_login,button_regist,button_FBlogin,button_noname;
	public EditText edittext_account,edittext_password;
	public TextView text;
	String account,password;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_test_1);
		
		edittext_account=(EditText)findViewById(R.id.edittext_account);
		edittext_password=(EditText)findViewById(R.id.edittext_password);
		edittext_password.setTransformationMethod(new AsteriskPasswordTransformationMethod());
		account=edittext_account.getText().toString();
		password=edittext_password.getText().toString();
		login_forever=(CheckBox)findViewById(R.id.checkBox1);
		remember_me=(CheckBox)findViewById(R.id.checkBox2);
		
		//assign button
		button_regist=(Button)findViewById(R.id.button_regist);
		button_noname=(Button)findViewById(R.id.button_noname);
		button_FBlogin=(Button)findViewById(R.id.button_FBlogin);
		button_login=(Button)findViewById(R.id.button_login);
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
				 Intent intent = new Intent(Page_test_1.this, Page4_MainActivity.class);
				 Page_test_1.this.startActivity(intent);

	
			}}
			);
		
	}

	private void checkboxlistener()
	{
	login_forever.setOnCheckedChangeListener(listener);
	remember_me.setOnCheckedChangeListener(listener);
	}
	//監聽user 是否有選取
	private CheckBox.OnCheckedChangeListener listener=new CheckBox.OnCheckedChangeListener()
	{
		public void onCheckedChanged(CompoundButton buttonView,boolean isChecked)
		{
			//if check the login_forever
				if(login_forever.isChecked()==true)
				{
					
				}
				//if check the remember_me
				if(remember_me.isChecked()==true)
				{
						
				}
		}
	};
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
