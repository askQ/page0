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
import java.util.List;

import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ListView;
import android.widget.TextView;

import com.example.api.API_1;
import com.example.api.API_1.OnFailListener;
import com.example.api.API_1.OnSuccessListener;
import com.example.bean.AddChoiceRequestBean;
import com.example.bean.AskQuestionRequestBean;
import com.example.bean.ChoiceBean;
import com.example.util.Tool;

public class P15 extends Activity {
	ArrayList<MyObject> arrayList;
	ListView ListView_here;
	Gallery gallery;
    Myadapter adapter;
    TextView textview_title,textview_detail,textview_type,textview_sex,textview_finish; 

    private String generate_typeid(String cloth, String date, String gift,
			String gather, String threec, String other, String sex,
			String makeup, String eat, String live, String entertain,
			String girl, String boy) {
		List<Integer> type_list = new ArrayList<Integer>();

		//  if (cloth != null) type_list.add(object);
		if (date != null) type_list.add(3);       //{"typeid":"3","name":"男女"},
		if (gift != null) type_list.add(7);       //{"typeid":"7","name":"送禮"},
		if (gather != null) type_list.add(6);     //{"typeid":"6","name":"聚會"},
		if (threec != null) type_list.add(4);     //{"typeid":"4","name":"3C"},
		// if (other != null) type_list.add(object);
		if (sex != null) type_list.add(8);        //{"typeid":"8","name":"西斯"},
		if (makeup != null) type_list.add(5);     //{"typeid":"5","name":"美妝"},
		if (eat != null) type_list.add(9);        //{"typeid":"9","name":"美食"},
		if (live != null) type_list.add(10);      //{"typeid":"10","name":"住宅"},
		if (entertain != null) type_list.add(11); //{"typeid":"11","name":"娛樂"},
		if (girl != null) type_list.add(2);       //{"typeid":"2","name":"女生"},
		if (boy != null) type_list.add(1);        //{"typeid":"1","name":"男生"},

		StringBuilder sb = new StringBuilder();
		int list_length = type_list.size();
		for (int i = 0; i < list_length; i++) {
			sb.append(type_list.get(i));
			if (i != list_length - 1)
				sb.append(',');
		}
		return sb.toString();
	}

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
	        
	        final String title=(String)getIntent().getSerializableExtra("title");
	        final String detail=(String)getIntent().getSerializableExtra("detail");
	        final String cloth=(String)getIntent().getSerializableExtra("cloth");
	        final String date=(String)getIntent().getSerializableExtra("date");
	        final String gift=(String)getIntent().getSerializableExtra("gift");
	        final String gather=(String)getIntent().getSerializableExtra("gather");
	        final String threec=(String)getIntent().getSerializableExtra("3c");
	        final String other=(String)getIntent().getSerializableExtra("other");
	        final String sex=(String)getIntent().getSerializableExtra("sex");
	        final String makeup=(String)getIntent().getSerializableExtra("makeup");
	        final String eat=(String)getIntent().getSerializableExtra("eat");
	        final String live=(String)getIntent().getSerializableExtra("live");
	        final String entertain=(String)getIntent().getSerializableExtra("entertain");
	        final String girl=(String)getIntent().getSerializableExtra("girl");
	        final String boy=(String)getIntent().getSerializableExtra("boy");
	        final String finish_day=(String)getIntent().getSerializableExtra("finish_day");
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
	        final ArrayList<MyObject> arrayList=(ArrayList<MyObject>)getIntent().getSerializableExtra("arrayList");
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
					// P15.this.finish();

					AskQuestionRequestBean bean = new AskQuestionRequestBean();
					bean.setSessionid(Tool.getSessionid());
					bean.setTitle(title);
					bean.setTypeid(generate_typeid(cloth, date, gift, gather, threec, other, sex, makeup, eat, live, entertain, girl, boy));
					bean.setContent(detail);
					bean.setEndtime(finish_day);

					API_1 api = new API_1();
					api.setOnSuccessListener(new OnSuccessListener() {
						@Override
						public void onSucess(JSONObject result) {

							try {
								ChoiceBean[] choiceBean_list = new ChoiceBean[arrayList.size()];
								for (int i = 0; i < arrayList.size(); i++) {
									ChoiceBean newChoiceBean = new ChoiceBean();
									MyObject object = arrayList.get(i);
									newChoiceBean.setTitle(object.titleFromEdittext);
									newChoiceBean.setContent(object.DetailFromEdittext);
									newChoiceBean.setPic(Tool.encode_to_base64(MediaStore.Images.Media.getBitmap(getContentResolver() , Uri.parse(object.UriFroFramgnet))));
									newChoiceBean.setExtension("jpg");
									choiceBean_list[i] = newChoiceBean;
								}

								AddChoiceRequestBean bean2 = new AddChoiceRequestBean();
								bean2.setSessionid(Tool.getSessionid());
								bean2.setQuestioned(result.getString("questionid"));
								bean2.setChoice(choiceBean_list);

								API_1 api2 = new API_1();
								api2.setOnSuccessListener(new OnSuccessListener() {
									@Override
									public void onSucess(JSONObject result) {
										Log.d("test", result.toString());
									}
								});
								api2.setOnFailListener(new OnFailListener() {
									@Override
									public void onFail(String errorMsg) {
										// TODO Auto-generated catch block
										Log.d("test", errorMsg);
									}
								});
								api2.add_choice(bean2);

							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							Log.d("test", result.toString());
						}
					});
					api.setOnFailListener(new OnFailListener() {
						@Override
						public void onFail(String errorMsg) {
							Log.e("test", errorMsg);
						}
					});
					api.ask_question(bean);
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
