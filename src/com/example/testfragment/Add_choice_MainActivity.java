package com.example.testfragment;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Handler;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;

public class Add_choice_MainActivity extends Activity implements Comunicator {
 
	ImageView imageView;
	TextView tv,tv1;
    ListView ListView_here;
	Gallery gallery;
	 ArrayList<MyObject> arrayList;
	Myadapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.p14_main);
		
		imageView = (ImageView) findViewById(R.id.imageView1);
		
		tv = (TextView) findViewById(R.id.textView1);
		tv1= (TextView) findViewById(R.id.textView2);
		arrayList = new ArrayList<MyObject>();
		ListView_here= (ListView) findViewById(R.id.listView);
		
		adapter = new Myadapter(getApplicationContext(), arrayList);
		
		ListView_here.setAdapter(adapter);
		
		ListView_here.setBackgroundColor(Color.BLUE);
		
		/*which i want to show is!!!!!!!not show in listview
		gallery =  (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(adapter);
		gallery.setBackgroundColor(Color.BLUE);
		*/
		
		//ignore this first
		ListView_here.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override         
			public boolean onItemLongClick(AdapterView<?> av, View v, final int pos, long id)
			            {
			             Object listItem = ListView_here.getItemAtPosition(pos);
			                Toast.makeText(Add_choice_MainActivity .this, "The long clicked item is " + pos, Toast.LENGTH_LONG).show();
	
			                Builder alertDialogBuilder = new AlertDialog.Builder(Add_choice_MainActivity.this);
			                alertDialogBuilder.setTitle("Delete item");
			                alertDialogBuilder.setMessage("Are you sure?");
			                alertDialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			                    public void onClick(DialogInterface dialog,int id) {
			                    	arrayList.remove(pos);
			        				adapter.notifyDataSetChanged();
			                    }
			                  });
			                alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
			                    public void onClick(DialogInterface dialog,int id) {
			                            dialog.cancel();		
			                    }	
			                });
			                AlertDialog alertDialog = alertDialogBuilder.create();	
			                alertDialog.show();
			                return true; //false will also trigger OnItemClick!
			            }	
			       });


		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dialogFragment dialogFragment = new dialogFragment();
				dialogFragment.show(getFragmentManager(), "hello :)) ");
				
			}
		});
		Button button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
			
					 Intent intent = new Intent();
			    	 intent.putExtra("arrayList", arrayList);//��error�皂yobject���mplement閫��鈭�臭��仿��臭��臭誑
			    	  intent.setClass(Add_choice_MainActivity.this,P15.class);
			    	  intent.putExtra("title", (String)getIntent().getSerializableExtra("title"));
			    	  intent.putExtra("detail", (String)getIntent().getSerializableExtra("detail"));
			    	  intent.putExtra("cloth", (String)getIntent().getSerializableExtra("cloth"));
			    	  intent.putExtra("sex", (String)getIntent().getSerializableExtra("sex"));
			    	  intent.putExtra("gift", (String)getIntent().getSerializableExtra("gift"));
			    	  intent.putExtra("gather", (String)getIntent().getSerializableExtra("gather"));
			    	  intent.putExtra("makeup", (String)getIntent().getSerializableExtra("makeup"));
			    	  intent.putExtra("3c", (String)getIntent().getSerializableExtra("3c"));
			    	  intent.putExtra("other", (String)getIntent().getSerializableExtra("other"));
			    	  intent.putExtra("date", (String)getIntent().getSerializableExtra("date"));
			    	  intent.putExtra("eat", (String)getIntent().getSerializableExtra("eat"));
			    	  intent.putExtra("entertain", (String)getIntent().getSerializableExtra("entertain"));
			    	  intent.putExtra("live", (String)getIntent().getSerializableExtra("live"));
			    	  intent.putExtra("girl", (String)getIntent().getSerializableExtra("girl"));
			    	  intent.putExtra("boy", (String)getIntent().getSerializableExtra("boy"));
			    	  intent.putExtra("finish_day", (String)getIntent().getSerializableExtra("finish_day"));
			    	  startActivity(intent);
			    	  

				}
			});
	
	}

	@Override
	public void doSomeThing(String text, String Text1,Uri uri) {

		if (uri !=null) {
			imageView.setImageURI(uri);
		}
			tv.setText(text);
			tv1.setText(Text1);
			
	}
	
	@Override
	public void save(String title, String detail,String uri_s_from ){
		arrayList.add(new MyObject(title,detail,uri_s_from));
	
		Log.i("wwwwwwwww", uri_s_from);
		//Toast.makeText(getApplicationContext(), uri_s_from, 1).show();
		/*
		Map<String,String> map = new HashMap<String,String>();
		  map.put("Title",title);
		  map.put("detail",detail);
	      map.put("Uri_string", uri_s_from);
		  list.add(map);*/
		 
	}
}
