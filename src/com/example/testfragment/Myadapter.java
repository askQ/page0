package com.example.testfragment;

import info.androidhive.slidingmenu.R;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Myadapter extends BaseAdapter {

	Context context;
	ArrayList<MyObject> array;

	public Myadapter(Context context, ArrayList<MyObject> arraylist) {
		// TODO Auto-generated constructor stub

		this.context = context;
		this.array = arraylist;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return array.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return array.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		View view = LayoutInflater.from(context).inflate(
				R.layout.listview_choice, null);
		ImageView imageView = (ImageView) view.findViewById(R.id.imageView_choice);
		TextView title = (TextView) view.findViewById(R.id.textView_title);
		TextView detail = (TextView) view.findViewById(R.id.textView_detail);
		
		title.setText(array.get(arg0).titleFromEdittext);
		detail.setText(array.get(arg0).DetailFromEdittext);
		//Bitmap bitmap = BitmapFactory.decodeFile(array.get(arg0).UriFroFramgnet);
		//imageView.setImageBitmap(bitmap);
		Uri uri = Uri.parse(array.get(arg0).UriFroFramgnet);
		imageView.setImageURI(uri);
		Log.i("adapter is used!!!!!!","already!!!!!!!!!!!!!");
		return view;
		
		
	}
}