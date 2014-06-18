/*
 * button_choose is the buton click to vote!!!
 *imageSwitcher is to show the image array[position] in the upside, it can add  Animations
 *so as
 *textswitcher,textswitcher1  show title and detail
 *
 *to use save to save data array--->
 * for(int i=0;i<array.size;i++){
 * save(title[i],detail[i],image_uri_str[i]);
 *
 * Title is the textview to show title oF Q
 * Detail is the textview to show detail of Q
 * asker show the asker name is textview
 * finishtime show the finish time
 * starttime show the ask time
 * 
 * photo is a imageview show asker's photo ,to use it by (photo.setimage.....)
 * 
 * */

package com.user_vote_pages;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import android.widget.SimpleAdapter.ViewBinder;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ViewSwitcher.ViewFactory;


public class P17 extends Activity {
	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	ImageView person_photo;
	Gallery gallery;
	Button button;
	TextView asker,fivishtime,starttime;
	SimpleAdapter simpleAdapter;
	ImageSwitcher imageSwitcher;
	TextSwitcher textswitcher,textswitcher1;
	private int[] hot = {R.drawable.hot,R.drawable.hot,R.drawable.hot
									};
	private String[] title = {
           "name1","name2","name3"
   											};
	private String[] detail = {
           "command","command2","command3"
   			};
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_p17);
		//person photo
		person_photo= (ImageView) findViewById(R.id.imageView1);
		//person_name
		asker= (TextView) findViewById(R.id.textView1);
		asker.setText("asker");
		starttime= (TextView) findViewById(R.id.textView2);
		starttime.setText("start time");
		fivishtime= (TextView) findViewById(R.id.textView3);
		fivishtime.setText("fivish time");
		gallery = (Gallery) findViewById(R.id.gallery);

		
	        for (int i = 0; i < title.length; i++) {
	            Map<String, Object> item = new HashMap<String, Object>();
	            item.put("image", hot[i]);
	            item.put("title", title[i]);
	            item.put("detail", detail[i]);
	            item.put("vote", "vote me");
	            items.add(item);
	        }
	     String[] ContentItem = new String[] { "image","title", "click","vote" };
	     int[] ViewID = new int[] {R.id.imageView_choice,R.id.textView_title,R.id.textView_detail,R.id.button1 };
	        
	      simpleAdapter = new SimpleAdapter(this, 
	                items, R.layout.listview_for_p17, ContentItem,
	                ViewID){
				@Override
				public View getView(final int position, View convertView, ViewGroup parent) {
					
					if(convertView==null){
					convertView=View.inflate(P17.this, R.layout.listview_for_p17, null);
					}
					 Button button_choose=(Button)convertView.findViewById(R.id.button1);
					button_choose.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
					
							Toast.makeText(getApplicationContext(),"hi i choose "+position, 1).show();
						}
			        });
					return convertView;
				}
	        	
	        };
	        //in order to search whether is button or not
	       
	     gallery.setAdapter(simpleAdapter);
		 gallery.setOnItemClickListener(new OnItemClickListener(){
			          public void onItemClick(AdapterView parent, View view, int position, long id) {
			        	  imageSwitcher.setImageResource(hot[position]);
			          	 textswitcher.setText(title[position]);
			        	 textswitcher1.setText(detail[position]);
			        	 
			            }
			        });
		
		imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
		imageSwitcher.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		        ImageView imageView = new ImageView(P17.this);
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
		       TextView textView = new TextView(P17.this);
		       textView.setTextColor(Color.GREEN);
		       textView.setTextSize(32);
		        return textView;
		    }         
		});
		textswitcher1 = (TextSwitcher) findViewById(R.id.text_switcher1);
		textswitcher1.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		       TextView textView = new TextView(P17.this);
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
		 button =(Button)findViewById(R.id.button_out);
		 button.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(P17.this, P18_mainactivity.class);
					startActivity(intent); 
			
				}}
				);
	}


}
