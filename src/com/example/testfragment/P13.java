package com.example.testfragment;


import info.androidhive.slidingmenu.R;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class P13 extends Activity{
	ToggleButton tButton,tButton_cloth,btn_b,btn_g,tButton_3c,tButton_makeup,
	                        tButton_gift,tButton_sex,tButton_other,tButton_gather,tButton_eat,
	                        tButton_entertain,tButton_live;
	EditText editText,editText1;	
	TextView dateText ;
	private int mYear;
	private int mMonth;
	private int mDay;
	private DatePickerDialog datePickerDialog;
	TextView tv_date,tv_cloth,tv_b,tv_g,tv_bg,tv_3c,tv_gather,tv_makeup,tv_other,tv_gift,tv_sex,
					tv_eat,tv_live,tv_entertain;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ask_btn);
		editText = (EditText)findViewById(R.id.editText1);
		editText1 = (EditText)findViewById(R.id.editText2);
		dateText = (TextView)findViewById(R.id.dateText);
		tv_date=(TextView)findViewById(R.id.textView3);
		tv_date.setText("is type consider to boy and girl?");
		Calendar calendar = Calendar.getInstance();
		mYear = calendar.get(Calendar.YEAR);
		mMonth = calendar.get(Calendar.MONTH);
		mDay = calendar.get(Calendar.DAY_OF_MONTH);
		dateText.setText(setDateFormat(mYear,mMonth,mDay)); 
		tButton = (ToggleButton) findViewById(R.id.toggleButton1);
		tButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_date.setText("yes is about my mate!");
			}else{
				tv_date.setText("not~~");
			}
		}
		});
		tv_cloth=(TextView)findViewById(R.id.textView4);
		tv_cloth.setText("is that Q about clothes??");
	
		tButton_cloth = (ToggleButton) findViewById(R.id.toggleButton2);
		tButton_cloth.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
			
				if(isChecked){
					tv_cloth.setText("yes is cloth!");
				}else{
				tv_cloth.setText("no!!!!");
				}

			}
		});
		tv_3c=(TextView)findViewById(R.id.textView_3c);
		tv_3c.setText("is about you want to buy a 3c?");
		tButton_3c = (ToggleButton) findViewById(R.id.toggleButton_3c);
		tButton_3c.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_3c.setText("pick for me please~!");
			}else{
				tv_3c.setText("not 3c");
			}
		}
		});
		
		tv_eat=(TextView)findViewById(R.id.textView_eat);
		tv_eat.setText("is about you want to pick something to eat?");
		tButton_eat = (ToggleButton) findViewById(R.id.toggleButton_eat);
		tButton_eat.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_eat.setText("eat me please~!");
			}else{
				tv_eat.setText("full");
			}
		}
		});
		
		tv_live=(TextView)findViewById(R.id.textView_live);
		tv_live.setText("is about you living?");
		tButton_live = (ToggleButton) findViewById(R.id.toggleButton_live);
		tButton_live.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_live.setText("pick for me please~!");
			}else{
				tv_live.setText("not living");
			}
		}
		});
		
		tv_entertain=(TextView)findViewById(R.id.textView_entertain);
		tv_entertain.setText("entertain us?");
		tButton_entertain = (ToggleButton) findViewById(R.id.toggleButton_entertain);
		tButton_entertain.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_entertain.setText("entertain");
			}else{
				tv_entertain.setText("not ");
			}
		}
		});
		
		tv_makeup=(TextView)findViewById(R.id.textView_makeup);
		tv_makeup.setText("is that about make up?");
		tButton_makeup = (ToggleButton) findViewById(R.id.toggleButton_make_up);
		tButton_makeup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_makeup.setText("mmmmmake up");
			}else{
				tv_makeup.setText("i don't put on make up!");
			}
		}
		});
		tv_gather=(TextView)findViewById(R.id.textView_gather);
		tv_gather.setText("is about a gathering?");
		tButton_gather = (ToggleButton) findViewById(R.id.toggleButton_gather);
		tButton_gather.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_gather.setText("is gather!!");
			}else{
				tv_gather.setText("not gather");
			}
		}
		});
		tv_gift=(TextView)findViewById(R.id.textView_gift);
		tv_gift.setText("is that you want to buy someone a gift?");
		tButton_gift = (ToggleButton) findViewById(R.id.toggleButton_gift);
		tButton_gift.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_gift.setText("yup about gift");
			}else{
				tv_gift.setText("no");
			}
		}
		});
		tv_sex=(TextView)findViewById(R.id.textView_sex);
		tv_sex.setText("is about sexxxx?");
		tButton_sex = (ToggleButton) findViewById(R.id.toggleButton_sex);
		tButton_sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_sex.setText("yes, have a nice sex");
			}else{
				tv_sex.setText("noQQQ");
			}
		}
		});
		tv_other=(TextView)findViewById(R.id.textView_other);
		tv_other.setText("is not one of them?");
		tButton_other = (ToggleButton) findViewById(R.id.toggleButton_other);
		tButton_other.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_other.setText("yes other please");
			}else{
				tv_other.setText("no");
			}
		}
		});
		tv_g=(TextView)findViewById(R.id.textView5);
		tv_g.setText("so you want a girl to answer Q?");
		btn_g = (ToggleButton) findViewById(R.id.toggleButton_g);
		btn_g.setOnCheckedChangeListener(new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_date.setText("girl");
			}else{
				tv_date.setText("nop");
			}

		}
		});
		tv_b=(TextView)findViewById(R.id.textView6);
		tv_b.setText("or you want a boy to answer for you!");
		btn_b = (ToggleButton) findViewById(R.id.toggleButton_b);
		btn_b.setOnCheckedChangeListener(new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
				boolean isChecked) {
			
			if(isChecked){
				tv_date.setText("boy please");
			}else{
				tv_date.setText("no~~~= =");
			}

		}
		});
		tv_bg=(TextView)findViewById(R.id.textView7);
	
		tv_bg.setText("if you choose either B and G then we ask both 4 you");
		
     
		
		Button dateButton = (Button)findViewById(R.id.dateButton);
		dateButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view) {
				showDialog(0);
				datePickerDialog.updateDate(mYear, mMonth, mDay);
			}
         
		});
		Button button = (Button)findViewById(R.id.button1);
	    	button.setOnClickListener(new OnClickListener() {
			
	    		@Override
	    		public void onClick(View arg0) {
	    			Intent intent = new Intent();
	    			intent.putExtra("title", editText.getText().toString());//title_there is a string which user input it
	    			intent.putExtra("detail", editText1.getText().toString());
	    			intent.setClass(P13.this,Add_choice_MainActivity.class);
	    			if(tButton_cloth.isChecked()){
					  intent.putExtra("cloth", "cloth");	  
	    			}
	    			if(tButton.isChecked()){
	    				intent.putExtra("date", "date");
	    			}
	    			if(tButton_3c.isChecked()){
	    				intent.putExtra("3c", "3c");
	    			}
	    			if(tButton_makeup.isChecked()){
	    				intent.putExtra("makeup", "makeup");
	    			}
	    			if(tButton_gift.isChecked()){
	    				intent.putExtra("gift", "gift");
	    			}
	    			if(tButton_sex.isChecked()){
	    				intent.putExtra("sex", "sex");
	    			}
	    			if(tButton_other.isChecked()){
	    				intent.putExtra("other", "other");
	    			}
	    			if(tButton_gather.isChecked()){
	    				intent.putExtra("gather", "gather");
	    			}
	    			if(tButton_eat.isChecked()){
	    				intent.putExtra("eat", "eat");
	    			}
	    			if(tButton_live.isChecked()){
	    				intent.putExtra("live", "live");
	    			}
	    			if(tButton_entertain.isChecked()){
	    				intent.putExtra("entertain", "entertain");
	    			}
	    			if(btn_g.isChecked()){
	    				intent.putExtra("girl", "girl");
	    			}
	    			if(btn_b.isChecked()){
	    				intent.putExtra("boy", "boy");
	    			}
	    			intent.putExtra("finish_day", dateText.getText().toString());
	    			startActivity(intent);
		

	    		}
	    	});
	
	
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
			@Override
			public void onDateSet(DatePicker view, int year, int month,
					int day) {
				mYear = year;
				mMonth = month;
				mDay = day;
				dateText.setText(setDateFormat(year,month,day)); 
			}
        
		}, mYear,mMonth, mDay);
    
		return datePickerDialog;
	}

	private String setDateFormat(int year,int monthOfYear,int dayOfMonth){
		return String.valueOf(year) + "/"
				+ String.valueOf(monthOfYear + 1) + "/"
				+ String.valueOf(dayOfMonth);
	}
}
