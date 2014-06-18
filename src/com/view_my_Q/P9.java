/*
 * holder.viewBtn ( the button on listview) click to choose what he choose
 * this button click place i send the position out to (int)choose, in order to record which he choose at last
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
import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.user_vote_pages.Fragment_BG;
import com.user_vote_pages.Fragment_B_only;
import com.user_vote_pages.Fragment_G_only;
import com.user_vote_pages.P17;

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
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
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


public class P9 extends Activity {
	EditText editText;
	ListView command_list;
	Gallery gallery;
	ListView command_lisyview;
	TextView Title,Detail, finish_time,asker,start_time;
	Button button;
	List<Map<String, Object>> commands = new ArrayList<Map<String,Object>>();
	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	ImageSwitcher imageSwitcher;
	SimpleAdapter simpleAdapter,commandadapter;
	TextSwitcher textswitcher,textswitcher1;
	private int[] hot = {R.drawable.hot,R.drawable.hot,R.drawable.hot
	};
	private String[] title = {
				"title1","titlee2","title3"
				};
	private String[] detail = {
				"detail1","detail2","detail3"
	};
	
	private String[] name = {
	            "name1","name2","name3"
	    };
  private String[] command = {
	            "command","command2","command3"
	    };
	int  choose=0;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p9);
		editText = (EditText)findViewById(R.id.editrext);
		start_time = (TextView) findViewById(R.id.textView3);
		start_time.setText("start time show here");
		finish_time = (TextView) findViewById(R.id.textView2);
		finish_time.setText("finish time show here");
		Title = (TextView) findViewById(R.id.Title);
		Title.setText("Title show here");
		Detail = (TextView) findViewById(R.id.description);
		Detail.setText("description show here");
		SimpleAdapter simpleAdapter;
		
		  for (int i = 0; i < title.length; i++) {
	            Map<String, Object> item = new HashMap<String, Object>();
	            item.put("image", hot[i]);
	            item.put("title", title[i]);
	            item.put("detail", detail[i]);
	            item.put("vote", "at last i choose"); 
	            items.add(item);
	        }
		
		gallery = (Gallery) findViewById(R.id.gallery);

		  String[] ContentItem = new String[] { "image","title", "click","vote" };
	      int[] ViewID = new int[] {R.id.imageView_choice,R.id.textView_title,R.id.textView_detail,R.id.button1 };
	        
	     simpleAdapter = new SimpleAdapter(this, 
	                items, R.layout.listview_for_p9, ContentItem,
	                ViewID){
				@Override
				public View getView(final int position, View convertView, ViewGroup parent) {
					
					if(convertView==null){
					convertView=View.inflate(P9.this, R.layout.listview_for_p17, null);
					}
					 Button button_choose=(Button)convertView.findViewById(R.id.button1);
					 button_choose.setText("at last i choose");
					button_choose.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							// TODO Auto-generated method stub
							choose=position;
							Toast.makeText(getApplicationContext(),"final i choose "+position, 1).show();
						}
			        });
					return convertView;
				}
	        	
	        };
		 gallery.setAdapter(simpleAdapter);
		 gallery.setOnItemClickListener(new OnItemClickListener(){
			          public void onItemClick(AdapterView parent, View view, int position, long id) {
			        	// imageSwitcher.setImageURI(Uri.parse(items.get(position).get("Uri_string")));
			        	// textswitcher.setText(items.get(position).get("Title"));
			        	 //textswitcher1.setText(list.get(position).get("detail"));
			        	  	imageSwitcher.setImageResource(hot[choose]);
				          	 textswitcher.setText(title[choose]);
				        	 textswitcher1.setText(detail[choose]);  
			          }
			        });
		 
////
			for (int i = 0; i < name.length; i++) {
		            Map<String, Object> item_command = new HashMap<String, Object>();
		            
		            item_command.put("name", name[i]);
		            item_command.put("command", command[i]);
		       
		            commands.add(item_command);
		        }
			String[] command_item = new String[] {"name", "command" };
		    int[] command_ViewID = new int[] {R.id.textView_name,R.id.textView_command};
		        
		    commandadapter = new SimpleAdapter(this, 
		                commands, R.layout.listview_command, command_item,
		                command_ViewID);
			
			command_list = (ListView) findViewById(R.id.list_for_command);
			command_list.setAdapter(commandadapter);
////			 
		 
		imageSwitcher = (ImageSwitcher)findViewById(R.id.image_switcher);
		imageSwitcher.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		        ImageView imageView = new ImageView(P9.this);
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
		       TextView textView = new TextView(P9.this);
		       textView.setTextColor(Color.GREEN);
		       textView.setTextSize(32);
		        return textView;
		    }         
		});
		textswitcher1 = (TextSwitcher) findViewById(R.id.text_switcher1);
		textswitcher1.setFactory(new ViewFactory(){
		    @Override
		    public View makeView() {
		       TextView textView = new TextView(P9.this);
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
				public void onClick(View arg0) {//想要接到問題完成頁面，也就是現在還沒寫的
					String review =editText.getText().toString();
					int choose;//what position of item he choose
					Intent intent = new Intent();
					intent.setClass(P9.this, P19.class);
					startActivity(intent);
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

