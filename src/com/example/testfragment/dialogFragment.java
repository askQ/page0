package com.example.testfragment;

import info.androidhive.slidingmenu.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class dialogFragment extends DialogFragment implements OnClickListener {

	Button btnBrowse;
	Button btnLoad;
	EditText editText;
	EditText editText1;
	ImageView imageView;
	Comunicator comunicator;
	String selectedImagePath;
	Uri selectedImageUri;
	Uri mImageCaptureUri;
	String mPath;
	Bitmap bitmap = null;
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		/*
		 * con th蝛�c蝐�th撱蕭g�槃 cho cha 嚙踝�撱�tuy nhi蝷 con th蝛�kh蝜南g :v
		 */
		comunicator = (Comunicator) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.dialog, null);
		btnBrowse = (Button) view.findViewById(R.id.btnLoadImage);
		btnLoad = (Button) view.findViewById(R.id.btnloadToListView);
		btnBrowse.setOnClickListener(this);
		btnLoad.setOnClickListener(this);
		editText = (EditText) view.findViewById(R.id.editText1);
		editText1 = (EditText) view.findViewById(R.id.EditText2);
		imageView = (ImageView) view.findViewById(R.id.imageView_dia);
    
		return view;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnLoadImage:
			 final String[] items = new String[] { "From Camera", "From SD Card" };
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.select_dialog_item, items);
	        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	        builder.setTitle("Select Image");

	        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int item) {
	                if (item == 0) {
	                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	                    File file = new File(Environment.getExternalStorageDirectory(), "tmp_avatar_"
	                        + String.valueOf(System.currentTimeMillis())
	                        + ".jpg");
	                    selectedImageUri = Uri.fromFile(file);//

	                    try {
	                        intent.putExtra(
	                            android.provider.MediaStore.EXTRA_OUTPUT,
	                            selectedImageUri);//
	                        intent.putExtra("return-data", true);

	                        startActivityForResult(
	            					Intent.createChooser(intent, "Select Picture"), 111);
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }

	                    dialog.cancel();
	                } else {
	                	Intent intent = new Intent();
	        			intent.setType("image/*");
	        			intent.setAction(Intent.ACTION_GET_CONTENT);
	        			startActivityForResult(
	        					Intent.createChooser(intent, "Select Picture"), 1111);
	                }
	            }
	        });
	        final AlertDialog dialog = builder.create();
			dialog.show();
		
			break;

		case R.id.btnloadToListView:
			comunicator.doSomeThing(editText.getText().toString(),editText1.getText().toString(),
					selectedImageUri);
			comunicator.save(editText.getText().toString(),editText1.getText().toString(),
					selectedImageUri.toString());//mImageCaptureUri
		
			dismiss();
			break;
		default:
			break;
		}

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == Activity.RESULT_OK){
       if (requestCode == 1111) {       	
    	   selectedImageUri = data.getData();
			selectedImagePath = getPath(selectedImageUri);
			bitmap = BitmapFactory.decodeFile(selectedImagePath);
//			Toast.makeText(getActivity(), selectedImagePath, 1).show();
			imageView.setImageBitmap(bitmap);
        } 
        else {//in this case data is null!!!!!!!!
        	 // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options(); 
            options.inSampleSize = 8;
            final Bitmap bitmap = BitmapFactory.decodeFile(selectedImageUri.getPath(),
                    options);
            imageView.setImageBitmap(bitmap);
   
        }
		}
    }	
	public String getPath(Uri uri) {
		String[] projection = { MediaStore.Images.Media.DATA };
		Cursor cursor = getActivity().managedQuery(uri, projection, null, null,
				null);
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}
}
