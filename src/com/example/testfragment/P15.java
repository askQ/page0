package com.example.testfragment;
/*textview_sex:show sexual of he wanna ask
 * textview_type:show the type he choose
 * textview_title:title send here
 * textview_detail
 * textview_finish:show the finish time
 * gallery:show the choice of he add(arraylist save the detail---->'title'detail''uri_string')
 * 
 * */

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.page_test_1.page3;
import com.example.page_test_1.page_2_test;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class P15 extends Activity {
	ArrayList<MyObject> arrayList;
	ListView ListView_here;
	Gallery gallery;
    Myadapter adapter;
    TextView textview_title,textview_detail,textview_type,textview_sex,textview_finish; 
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.preview);
	        Intent intent = getIntent();
	        /*
	         * ps send title method 
	         * at the button which decide to send title and detail 
	         * write to send them to add_choice_MainActivity then send here
	         * ->
	         *  Intent intent = new Intent();
			    intent.putExtra("title", title_there);//title_there is a string which user input it
			    intent.putExtra("detail", detail_there);
			    intent.setClass(Add_choice_MainActivity.this,Preview.class);
			    	 
	  		     startActivity(intent);
	         * <-
	         * 
	         * 
	         * */
	        
	        String title=(String)getIntent().getSerializableExtra("title");
	        String detail=(String)getIntent().getSerializableExtra("detail");
	        String cloth=(String)getIntent().getSerializableExtra("cloth");
	        String date=(String)getIntent().getSerializableExtra("date");
	        String gift=(String)getIntent().getSerializableExtra("gift");
	        String gather=(String)getIntent().getSerializableExtra("gather");
	        String threec=(String)getIntent().getSerializableExtra("3c");
	        String other=(String)getIntent().getSerializableExtra("other");
	        String sex=(String)getIntent().getSerializableExtra("sex");
	        String makeup=(String)getIntent().getSerializableExtra("makeup");
	        String eat=(String)getIntent().getSerializableExtra("eat");
	        String live=(String)getIntent().getSerializableExtra("live");
	        String entertain=(String)getIntent().getSerializableExtra("entertain");
	        String girl=(String)getIntent().getSerializableExtra("girl");
	        String boy=(String)getIntent().getSerializableExtra("boy");
	        String finish_day=(String)getIntent().getSerializableExtra("finish_day");
	        textview_sex= (TextView) findViewById(R.id.textView8);
	        textview_sex.setText(girl+boy);
	        textview_type= (TextView) findViewById(R.id.textView6);
	        textview_type.setText(cloth+date+threec+gift+makeup+gather+eat+live+entertain+sex+other);
	        textview_title = (TextView) findViewById(R.id.textView2);
	        textview_title.setText(title);
	        textview_detail = (TextView) findViewById(R.id.textView4);
	        textview_detail.setText(detail);
	        textview_finish= (TextView) findViewById(R.id.textView10);
	        textview_finish.setText(finish_day);
	        ArrayList<MyObject> arrayList=(ArrayList<MyObject>)getIntent().getSerializableExtra("arrayList");
	        gallery =  (Gallery) findViewById(R.id.gallery);

    			        adapter = new Myadapter(getApplicationContext(), arrayList);
	
    			        gallery.setAdapter(adapter);
	    		
    			        gallery.setBackgroundColor(Color.BLUE);
	       
	        Button button = (Button)findViewById(R.id.button);
	   	    button.setOnClickListener(new OnClickListener() {
	  			
	  			@Override
	  			public void onClick(View arg0) {
	  				Intent intent = new Intent();
	  				intent.setClass(P15.this, Page4_MainActivity.class);
	  				startActivity(intent); 
	  			//	P15.this.finish(); 
	  			}
	  		});
	        
	    }
	     public boolean onKeyDown(int keyCode,KeyEvent event){

	      if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount()==0){   //確定按下退出鍵and防止重複按下退出鍵

	          dialog();

	      }

	      return false;

	  }

	  

	   private void dialog(){

	       AlertDialog.Builder builder = new AlertDialog.Builder(P15.this); //創建訊息方塊

	       builder.setMessage("預覽問題不想問了嗎？");

	       builder.setTitle("不問了");

	       builder.setPositiveButton("確認", new DialogInterface.OnClickListener()  {

	           @Override

	           public void onClick(DialogInterface dialog, int which) {
	        	   Intent intent = new Intent();
					intent.setClass(P15.this, Page4_MainActivity.class);
					startActivity(intent); 
					
	              dialog.dismiss(); //dismiss為關閉dialog,Activity還會保留dialog的狀態

	              P15.this.finish();//關閉activity
	              
	              

	      }

	    });

	       builder.setNegativeButton("繼續問", new DialogInterface.OnClickListener()  {

	           @Override

	           public void onClick(DialogInterface dialog, int which) {

	        dialog.dismiss();

	      }

	    });

	    builder.create().show();

	   }
	
	
	
}
