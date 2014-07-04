/*
 * holder.viewBtn ( the button on listview) click to choose what he choose
 * this button click place i send the position out to (int)choose, in order to record which he choose at last
 * 
 * put the number in and it will show
 * this page the (int)choose cannot be change
 * 
 * review is the string to get the review of the item....i den't know how to explain
 * ------------------------------------------------------------------------------------------------------
 * ------->	imageSwitcher.setImageResource(hot[choose]);
				    textswitcher.setText(title[choose]);
				    textswitcher1.setText(detail[choose]);  ------->is to show the item which asker choose!!
 * -------------------------------------------------------------------------------------------------------
 * TextView Title,Detail, finish_time,asker,start_time,review
 * is to show the text of the element
 * 
 * 
 * 
 * 
 * */

package com.view_my_Q;

import info.androidhive.slidingmenu.R;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.api.API_1;
import com.example.bean.ChoiceBean;
import com.example.bean.ContentResponseBean;
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


//已完成之問題
public class P19 extends Activity {
	ListView command_list;
	Gallery gallery;
	TextView Title,Detail, finish_time,asker,start_time,text_review;
	ImageView photo;
	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> commands = new ArrayList<Map<String,Object>>();
	Button button_out;
	ImageSwitcher imageSwitcher;
	TextSwitcher textswitcher,textswitcher1;
	SimpleAdapter simpleAdapter,commandadapter;
	
	private int[] hot = {R.drawable.hot,R.drawable.hot,R.drawable.hot};
	
	private String[] title = { "並未決定選項" };
	private String[] detail = { "" };
	
	private String [] picurl = { "" } ;
	
	private String[] name = {
	            ""
	    };
	private String[] command = {
	            "目前沒有評論"
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
	
	
	int  choose=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p19);
		

		asker = (TextView) findViewById(R.id.textView_asker);
		asker.setText("asker show here");
		start_time = (TextView) findViewById(R.id.textView5);
		start_time.setText("start time show here");
		finish_time = (TextView) findViewById(R.id.textView7);
		finish_time.setText("finish time show here");
		Title = (TextView) findViewById(R.id.Title);
		Title.setText("Title show here");
		Detail = (TextView) findViewById(R.id.description);
		Detail.setText("description show here");
		text_review= (TextView) findViewById(R.id.text_review);
		text_review.setText("review ot asker show here");
////
		for (int i = 0; i < name.length; i++) {
			            Map<String, Object> item_command = new HashMap<String, Object>();			           
			            item_command.put("name", name[i]);
			            item_command.put("command", command[i]);			       
			            commands.add(item_command);
			        }
		String[] command_item = new String[] {"name", "command" };
		int[] command_ViewID = new int[] {R.id.textView_name,R.id.textView_command};
			        
			 commandadapter = new SimpleAdapter(this,commands, R.layout.listview_command, command_item,
			                command_ViewID);
				
				command_list = (ListView) findViewById(R.id.list_for_command);
				command_list.setAdapter(commandadapter);
////				
		photo=(ImageView)findViewById(R.id.imageView1);
		//photo.setimage.....
		  for (int i = 0; i < title.length; i++) {
	            Map<String, Object> item = new HashMap<String, Object>();
	            item.put("image", hot[i]);
	            item.put("title", title[i]);
	            item.put("detail", detail[i]);	       
	            items.add(item);
	        }
		 String[] ContentItem = new String[] { "image","title", "click" };
	        int[] ViewID = new int[] {R.id.imageView_choice,R.id.textView_title,R.id.textView_detail};
	        
	       simpleAdapter = new SimpleAdapter(this, 
	                items, R.layout.listview_choice, ContentItem,
	                ViewID);
		
		gallery = (Gallery) findViewById(R.id.gallery);

		 gallery.setAdapter(simpleAdapter);
	/*	 gallery.setOnItemClickListener(new OnItemClickListener(){
			          public void onItemClick(AdapterView parent, View view, int position, long id) {
			        	 imageSwitcher.setImageURI(Uri.parse(list.get(position).get("Uri_string")));
			        	 textswitcher.setText(list.get(position).get("Title"));
			        	 textswitcher1.setText(list.get(position).get("detail"));
			            }
			        });*/
		
		imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
		imageSwitcher.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		        ImageView imageView = new ImageView(P19.this);
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
		       TextView textView = new TextView(P19.this);
		       textView.setTextColor(Color.GREEN);
		       textView.setTextSize(32);
		        return textView;
		    }         
		});
		textswitcher1 = (TextSwitcher) findViewById(R.id.text_switcher1);
		textswitcher1.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		       TextView textView = new TextView(P19.this);
		       textView.setTextColor(Color.GREEN);
		       textView.setTextSize(32);
		        return textView;
		    }         
		});
		
		
        
		textswitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		textswitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		textswitcher1.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
		textswitcher1.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
	    imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
	    button_out =(Button)findViewById(R.id.button_gohome);
		
	    button_out.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					/*
	 				Intent intent = new Intent();
					intent.setClass(P19.this, P18_mainactivity.class);
					startActivity(intent); 
					*/
				}}
				);
	    
	    //從 Intent 抓取問題的內容
		 String questionContent = this.getIntent().getStringExtra("QuestionContent") ;		 
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
		
		String choose_choiceid = responseBean.getChoiceid() ;
		
		ChoiceBean [] choice_arr = responseBean.getChoice() ;		
		
		//假如有選項的情況,抓取內容		
		if(choice_arr!=null && choose_choiceid != null && choice_arr.length>0) {
			
			items.clear();
			
			for(int i=0 ; i<choice_arr.length ; i++) {
				//找到使用者選的選項後,就開始塞資料
				if(choose_choiceid.equals(choice_arr[i].getChoiceid())) {
					title[choose] = choice_arr[i].getTitle() ;
					detail[choose] = choice_arr[i].getContent() ;
					picurl[choose] = choice_arr[i].getPicurl() ;
					
					Map<String, Object> item = new HashMap<String, Object>();
					item.put("title", title[choose]);
					//item.put("detail", detail[choose]);
		            item.put("image", hot[choose]);
		            items.add(item);
		            
		            if(picurl[choose]!=null && !"".equals(picurl[choose]) ) {
		            	
		            	new Thread() {
							@Override
							public void run() {
								try {											
									choice_Bitmap = Tool.get_bitmap(API_1.server_url
											+ URLDecoder.decode(picurl[choose], "utf-8"));
									messageHandler.sendEmptyMessage(0);
									
								} catch (UnsupportedEncodingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}										
							}
	        	  		 }.start();		            	
		            	
		            }
		            textswitcher.setText(title[choose]);
		            textswitcher1.setText(detail[choose]);
					break ;
				}				      
			}
			simpleAdapter = new SimpleAdapter(this, 
	                items, R.layout.listview_choice, ContentItem,
	                ViewID);
			gallery.setAdapter(simpleAdapter);			
		}
		
		UserMessageBean [] usermessage = responseBean.getUser_message() ;
		
		if(usermessage!=null && usermessage.length>0) {
			
			commands.clear(); 
			
			for(int i=0 ; i<usermessage.length ; i++) {				
				Map<String, Object> item_command = new HashMap<String, Object>();		           
	            item_command.put("name", usermessage[i].getUsername());
	            item_command.put("command", usermessage[i].getContent());	       
	            commands.add(item_command); 
			}
			
		}
		
		commandadapter = new SimpleAdapter(this, 
                commands, R.layout.listview_command, command_item,
                command_ViewID);
		
		command_list.setAdapter(commandadapter);
		
		 
		 
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
