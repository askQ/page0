/*this page is the page asker see their Q's page
 * which the Q has not been finish 
 * asker can choose to finish it or delete it with button_finish &button_delete
 * 
 * 
 * 
 * 
 * */


package com.view_my_Q;

import info.androidhive.slidingmenu.PersondeiailFragment;
import info.androidhive.slidingmenu.R;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.api.API_1;
import com.example.api.API_1.OnFailListener;
import com.example.api.API_1.OnSuccessListener;
import com.example.bean.ChoiceBean;
import com.example.bean.ContentResponseBean;
import com.example.bean.MemberInfoResponseBean;
import com.example.bean.QuestionBean;
import com.example.bean.QuestoinRequestBean;
import com.example.bean.UserMessageBean;
import com.example.util.Tool;
import com.google.gson.Gson;
import com.user_vote_pages.Fragment_BG;
import com.user_vote_pages.Fragment_B_only;
import com.user_vote_pages.Fragment_G_only;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ViewSwitcher.ViewFactory;

//未完成之問題
public class MP16 extends Activity {
	
	Gallery gallery;
	ListView command_list;
	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> commands = new ArrayList<Map<String,Object>>();
	TextView Title,Detail, finish_time,asker,start_time;
	Button button,button_finish,button_delete;
	ImageSwitcher imageSwitcher;
	TextSwitcher textswitcher,textswitcher1;
	SimpleAdapter simpleAdapter,commandadapter;
	
	ProgressDialog progressDialog;
	
	
		
	private int[] hot = {R.drawable.hot,R.drawable.hot,R.drawable.hot
    };
	
    private String[] title = {
            "沒有發過選項"
    };
    private String[] detail = {
            ""
    };
    private String[] picurl = {
            ""
    };
    
    private Bitmap choice_Bitmap = null ;
    
    
    // 設定抓完圖片後進行UI切換圖片的處理
 	private Handler messageHandler = new Handler() {
 		public void handleMessage(Message msg) {
 			switch (msg.what) {
 			case 0: 				
 				BitmapDrawable temp = new BitmapDrawable(choice_Bitmap) ; 				
 				imageSwitcher.setImageDrawable(temp); 
 				return;
 			} 			
 		}
 	};
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p16);
		
	
		Title = (TextView) findViewById(R.id.Title);
		Title.setText("Title show here");
		Detail = (TextView) findViewById(R.id.description);
		Detail.setText("description show here");
		start_time = (TextView) findViewById(R.id.textView3);
		start_time.setText("start time show here");
		finish_time = (TextView) findViewById(R.id.textView2);
		finish_time.setText("finish time show here");
		
		progressDialog = new ProgressDialog(this) ;
		
		
////		
		 for (int i = 0; i < title.length; i++) {
	            Map<String, Object> item = new HashMap<String, Object>();
	            item.put("image", hot[i]);
	            item.put("title", title[i]);
	            item.put("detail", detail[i]);	       
	            items.add(item);
	        }
		 
		 String[] ContentItem = new String[] { "image","title", "detail" };
	     int[] ViewID = new int[] {R.id.imageView_choice,R.id.textView_title,R.id.textView_detail};
	        
	     simpleAdapter = new SimpleAdapter(this, 
	                items, R.layout.listview_choice, ContentItem,
	                ViewID);
		
		
		gallery = (Gallery) findViewById(R.id.gallery);

		gallery.setAdapter(simpleAdapter);
		
		//上面的文字
		gallery.setOnItemClickListener(new OnItemClickListener(){
			          public void onItemClick(AdapterView parent, View view, int position, long id) {
			        	  
			        	  final int temp_position = position ;
			        	  
			        	  	 if(picurl[position]!=null && ! "".equals(picurl[position])) {									
									
								new Thread() {
									@Override
									public void run() {
										try {											
											choice_Bitmap = Tool.get_bitmap(API_1.server_url
													+ URLDecoder.decode(picurl[temp_position], "utf-8"));
											messageHandler.sendEmptyMessage(0);
											
										} catch (UnsupportedEncodingException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}										
									}
			        	  		 }.start();			        	  		 
			        	  		 
			        	  		//imageSwitcher.setImageResource(hot[position]);
			        	  	 }
				          	 textswitcher.setText(title[position]);
				        	 textswitcher1.setText(detail[position]); 
			            }
			        });
		
				
////		
		command_list = (ListView) findViewById(R.id.list_for_command);
		
////		
		
		imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
		imageSwitcher.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		        ImageView imageView = new ImageView(MP16.this);
		        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		        imageView.setLayoutParams(
		        new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, 180));
		        return imageView;
		    }         
		});
		
		textswitcher = (TextSwitcher) findViewById(R.id.text_switcher);
		textswitcher.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		       TextView textView = new TextView(MP16.this);
		       textView.setTextColor(Color.GREEN);
		       textView.setTextSize(32);
		        return textView;
		    }         
		});
		
		textswitcher1 = (TextSwitcher) findViewById(R.id.text_switcher1);
		textswitcher1.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		       TextView textView = new TextView(MP16.this);
		       textView.setTextColor(Color.GREEN);
		       textView.setTextSize(32);
		        return textView;
		    }         
		});
		//Animation not important
		textswitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		textswitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		textswitcher1.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		textswitcher1.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
	    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
////		
	    button =(Button)findViewById(R.id.button_out);
		button.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(MP16.this, P9.class);
					startActivity(intent);
				}}
				);
		
		 button_finish =(Button)findViewById(R.id.button_finish);
		 button_finish.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(MP16.this, P9.class);
					startActivity(intent);
				}}
				);
		 
		 		 
		 
		 //從 Intent 抓取問題的內容
		 String questionContent = this.getIntent().getStringExtra("QuestionContent") ;		 
		 final String questionid = this.getIntent().getStringExtra("Questionid") ;
		 Gson gson = new Gson() ;			
		 ContentResponseBean responseBean = gson.fromJson(questionContent,ContentResponseBean.class);

		 try {				
				Title.setText("標題 :" + URLDecoder.decode(responseBean.getTitle(),"utf-8") );				
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Detail.setText("內容 :" + responseBean.getContent());					
		start_time.setText("發問時間:" + responseBean.getBuildtime());					
		finish_time.setText("結束時間:" + responseBean.getEndtime());
		
		ChoiceBean [] choice_arr = responseBean.getChoice() ;
		
		//假如有選項的情況,抓取內容
		if(choice_arr!=null && choice_arr.length>0) {
			
			title = new String[choice_arr.length] ;
			detail = new String[choice_arr.length] ;
			picurl = new String[choice_arr.length] ; 
			
			items.clear() ;
			
			for(int i=0 ; i<choice_arr.length ; i++) {
				
				//塞入選樣資料到陣列
				title[i] = choice_arr[i].getTitle() ;
				detail[i] = choice_arr[i].getContent() ;
				picurl[i] = choice_arr[i].getPicurl() ;
				
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("title", title[i]);
				//item.put("detail", detail[i]);
	            //item.put("image", hot[i]);
	            items.add(item);        
			}
			
			simpleAdapter = new SimpleAdapter(MP16.this,items, R.layout.listview_choice, ContentItem,ViewID);						
			gallery.setAdapter(simpleAdapter);			
		}
		
		
		//針對抓取選項做準初始化
		String[] command_item = new String[] {"name", "command" };
	    int[] command_ViewID = new int[] {R.id.textView_name,R.id.textView_command};
		
		UserMessageBean [] usermessage = responseBean.getUser_message() ;
		
		if(usermessage!=null && usermessage.length>0) {
			
			for(int i=0 ; i<usermessage.length ; i++) {				
				Map<String, Object> item_command = new HashMap<String, Object>();		           
	            item_command.put("name", usermessage[i].getUsername());
	            item_command.put("command", usermessage[i].getContent());	       
	            commands.add(item_command);	            
			}
		}
		else {
			Map<String, Object> item_command = new HashMap<String, Object>();		           
            item_command.put("name", "");
            item_command.put("command","目前暫時沒有評論");	       
            commands.add(item_command);	            
		}
		
		commandadapter = new SimpleAdapter(this, 
                commands, R.layout.listview_command, command_item,
                command_ViewID);
		
		command_list.setAdapter(commandadapter);
		
		
		button_delete =(Button)findViewById(R.id.button_delete);
		
		//進行刪除鍵按下動作
		button_delete.setOnClickListener(new Button.OnClickListener(){			
			public void onClick(View arg0) {
				
				QuestoinRequestBean bean = new QuestoinRequestBean() ;					
				bean.setSessionid(Tool.getSessionid());
				bean.setQuestionid(questionid);
				
				API_1 api = new API_1() ;
				
				 api.setOnSuccessListener(new OnSuccessListener() {
						// 回傳成功之處理
						@Override
						public void onSucess(JSONObject result) {						
							Toast.makeText(MP16.this,"刪除成功", Toast.LENGTH_LONG).show();
							//這邊可以加入導回個人資料面面
						}
					});

					api.setOnFailListener(new OnFailListener() {
						// 回傳失敗之處理
						@Override
						public void onFail(String errorMsg) {							
							Toast.makeText(MP16.this,"刪除失敗", Toast.LENGTH_LONG).show();
						}
					});
					
					api.delete_question(bean);
					
					Toast.makeText(MP16.this,"處理中..", Toast.LENGTH_SHORT).show();
					
			}}
		);
		
		
		 
	}
	
	
	public void selectFrag(View view) { 
		
		 Fragment fr,f2,f3;
		 fr = new Fragment_BG();
		 f2 = new Fragment_B_only();
		 f3 = new Fragment_G_only();
		 FragmentManager fm = getFragmentManager();
		 fr = (Fragment_BG)fm.findFragmentById(R.id.fragment_place);		 
		 //firstfragment should display one pie chart		 
		 f2 = (Fragment_B_only)fm.findFragmentById(R.id.fragment_1);
		 //at second fragment's place should display another
		 f3 = (Fragment_G_only)fm.findFragmentById(R.id.fragment_2);		 
	}
	



	
}

