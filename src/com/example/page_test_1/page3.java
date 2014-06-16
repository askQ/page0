package com.example.page_test_1;
import info.androidhive.slidingmenu.Page4_MainActivity;
import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.view.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class page3 extends Activity {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    private ViewPager mViewPager;
    List<View> viewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);
        Button button_skip = (Button) findViewById(R.id.button_skip);
        button_skip.setText("skip introduction");
        button_skip.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
				intent.setClass(page3.this, Page4_MainActivity.class);
				startActivity(intent); 
              // Toast.makeText(getApplicationContext(), "嚙賡嚙質�蝛輯�豢╡�剖�頦�嚙踝蕭", Toast.LENGTH_SHORT).show();
                }
        });                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
        LayoutInflater mInflater = getLayoutInflater().from(this);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
        View v1 = mInflater.inflate(R.layout.page3_1, null);
        View v2 = mInflater.inflate(R.layout.page3_2, null);
        View v3 = mInflater.inflate(R.layout.page3_3, null);
       
        viewList = new ArrayList<View>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(viewList));
        mViewPager.setCurrentItem(0); //嚙踝�嚙踝蕭��雓Ｗ�嚙踝蕭憛狐�都�血�嚙�                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
        View view = viewList.get(0);
        TextView textView = (TextView) view.findViewById(R.id.text_1);
        textView.setText("  ");
        Button button = (Button) view.findViewById(R.id.button_1);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
              
               Toast.makeText(getApplicationContext(), "嚙賡嚙質�蝛輯�豢╡�剖�頦�嚙踝蕭", Toast.LENGTH_SHORT).show();
                }
        });
      
    }
}