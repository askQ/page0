/*click button_noname_login to log in
 * 
 * 
 * */

package com.example.page_test_1;

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class page_test_1_1 extends Activity {
	public Button button_noname_login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_test_1_1);
		button_noname_login=(Button)findViewById(R.id.button_noname_login);
		button_noname_login.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(page_test_1_1.this, Page4_MainActivity.class);
				startActivity(intent); 
			}}
			);
	}

}
