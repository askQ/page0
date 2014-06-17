package info.androidhive.page_out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.page_test_1.Page_test_1;

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class p16 extends Activity {
   private Button home;
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.p16);
			home=(Button)findViewById(R.id.button2);
			home.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					 Intent intent = new Intent(p16.this, Page4_MainActivity.class);
					 p16.this.startActivity(intent);
		 
				}}
					);
				
			}

		}