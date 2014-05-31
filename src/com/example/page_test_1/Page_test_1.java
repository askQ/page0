package com.example.page_test_1;

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Page_test_1 extends Activity {
	public Button button_login,button_regist,button_FBlogin,button_noname;
	public EditText edittext_account,edittext_password;
	public TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_page_test_1);
		
		//assign button
		button_regist=(Button)findViewById(R.id.button_regist);
		button_noname=(Button)findViewById(R.id.button_noname);
		button_FBlogin=(Button)findViewById(R.id.button_FBlogin);
		button_login=(Button)findViewById(R.id.button_login);
		//�ΦW���O�J���s�A�H���I�Τ���|�ͪ��ƥ�
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

}
