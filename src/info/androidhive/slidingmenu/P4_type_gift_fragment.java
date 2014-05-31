/*this page is home page , long click the Q title ,then can go to the Q's page,
 * but!!!!!!!!!!!!!!!
 * the page we are going to despart to two condition, one is the page haven't  been finish
 * the other is the page has been finish,  we are going to P19.java
 * ------------------------------------------------------------------------------------------------
 * the listview contain 4 part
 * 1.image to show ''hot''   ''new''   etc
 * 2.textview to show title
 * 3.textview to show the number of  command of Q
 * 4.textview to shoe the number of click of Q
 * ------------------------------------------------------------------------------------------------
 * page5_adapter.xml is the xml of listview this place
 * 
 * 
 * 
 * */


package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.page_test_1.page0;
import com.example.page_test_1.page3;
import com.example.testfragment.Add_choice_MainActivity;
import com.example.testfragment.P13;
import com.example.testfragment.P15;
import com.user_vote_pages.P17;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class P4_type_gift_fragment extends Fragment {
	   private ListView listView;
	    private SimpleAdapter simpleAdapter;
	    private int[] hot = {R.drawable.hot,R.drawable.hot,R.drawable.hot
	    };
	    private String[] Title = {
	            "title1","title2","title3"
	    };
	    private String[] click = {
	            "click","click2","click3"
	    };
	    private String[] command = {
	            "command","command2","command3"
	    };
	    
	
	public P4_type_gift_fragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.type_gifr, container, false);
         Button button_ask=(Button)rootView.findViewById(R.id.button_ask);
         
         button_ask.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), P13.class);
				startActivity(intent); 
				getActivity().finish();
				
			}}
			);
         Button button_howuse=(Button)rootView.findViewById(R.id.button_howuse);
         
         button_howuse.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), page3.class);
				startActivity(intent); 
			//	getActivity().finish();
				
			}}
			);
		 listView = (ListView)rootView.findViewById(R.id.listView);
		 List<Map<String, Object>> items = new ArrayList<Map<String,Object>>();
		        for (int i = 0; i < Title.length; i++) {
		            Map<String, Object> item = new HashMap<String, Object>();
		            item.put("image", hot[i]);
		            item.put("title", Title[i]);
		            item.put("click", click[i]);
		            item.put("command", command[i]);
		            items.add(item);
		        }
		        String[] ContentItem = new String[] { "image","title", "click","command" };
		        int[] ViewID = new int[] {R.id.imageView1,R.id.TextView1,R.id.textView2,R.id.TextView3 };
		        simpleAdapter = new SimpleAdapter(getActivity(), 
		                items, R.layout.page5_adapter, ContentItem,
		                ViewID);
		        listView.setAdapter(simpleAdapter);
		     
		        listView.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override         
					public boolean onItemLongClick(AdapterView<?> av, View v, final int pos, long id)
					            {
								Intent intent = new Intent();
								intent.setClass(getActivity(), P17.class);
								startActivity(intent); 
						
								return false;
					            }
					});
	
         
        return rootView;
    }
}
