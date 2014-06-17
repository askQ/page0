/*this class i include one library in order to show the pie chart!!
 * however , if i gonna show three pie in one page , that i have to add 3 fragment to show 3 pie
 * so i add 3~~ and  [selectFrag]function is to show them,
 * and the code of the pie is in com.user_vote_pages.FragmentXXXX;
 * the vote number of choice have to send there
 * 
 * they got many method to use in pie chart
 * dictionary here
 * http://blog.csdn.net/lk_blog/article/details/7645661
 * 
 * */


//http://givemepass.blogspot.tw/2012/07/tabactivity.html

package com.user_vote_pages;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.view_my_Q.MP16;

import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ViewSwitcher.ViewFactory;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;


public class P18_mainactivity extends Activity {
	Gallery gallery;
	
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
    SimpleAdapter simpleAdapter;
	List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.p18);
      gallery = (Gallery) findViewById(R.id.gallery);
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
      		        ImageView imageView = new ImageView(P18_mainactivity.this);
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
      		       TextView textView = new TextView(P18_mainactivity.this);
      		       textView.setTextColor(Color.GREEN);
      		       textView.setTextSize(32);
      		        return textView;
      		    }         
      		});
      		textswitcher1 = (TextSwitcher) findViewById(R.id.text_switcher1);
      		textswitcher1.setFactory(new ViewFactory(){
      		    @Override
      		    public View makeView() {
      		       TextView textView = new TextView(P18_mainactivity.this);
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
      Button button_out = (Button)findViewById(R.id.button_gohome);
		
	    button_out.setOnClickListener(new Button.OnClickListener(){
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(P18_mainactivity.this, Page4_MainActivity.class);
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

		 f2 = (Fragment_B_only)fm.findFragmentById(R.id.fragment_1);
		 //at second fragment's place should display another
		 f3 = (Fragment_G_only)fm.findFragmentById(R.id.fragment_2);

	}

}
