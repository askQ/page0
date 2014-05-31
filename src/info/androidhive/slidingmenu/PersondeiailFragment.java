package info.androidhive.slidingmenu;

import com.example.testfragment.P13;
import com.user_vote_pages.P17;
import com.view_my_Q.MP16;
import com.view_my_Q.P19;
import com.view_my_Q.P9;

import android.R.string;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;




public class PersondeiailFragment extends Fragment {

	private ListView listView;
	private ListView listView2;
	private ArrayAdapter<String> adapter;
	private ArrayAdapter<String> adapter2;
	private Button changePersonDetail;
	
	public PersondeiailFragment(){}
	
	  public void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        super.onCreate(savedInstanceState);
	    }
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_persondetail, container, false);
        changePersonDetail=(Button)rootView.findViewById(R.id.button2);
        listView = (ListView) rootView.findViewById(R.id.listView1);
        listView2 = (ListView) rootView.findViewById(R.id.listView2);
        changePersonDetail.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), ChangePersondetail.class);
				startActivity(intent); 
				getActivity().finish();
				
			}}
			);
		// 皜���
	       String[] arr1 = new String[]{"��A","��B"};
	       String[] arr2 = new String[]{"��C","��D"};
		adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,arr1);
		adapter2=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,arr2);

		listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override         
			public boolean onItemLongClick(AdapterView<?> av, View v, final int pos, long id)
			            {
						Intent intent = new Intent();
						intent.setClass(getActivity(), MP16.class);
						startActivity(intent); 
				
						return false;
			            }
			});
		listView2.setAdapter(adapter2);

		listView2.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override         
			public boolean onItemLongClick(AdapterView<?> av, View v, final int pos, long id)
			            {
						Intent intent = new Intent();
						intent.setClass(getActivity(), P19.class);
						startActivity(intent); 
				
						return false;
			            }
			});
        return rootView;
    }
	
}



