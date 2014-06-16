package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Page4_TransportFragment extends Fragment {
	
	public Page4_TransportFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_transport, container, false);
        
        
        Button button_G=(Button)rootView.findViewById(R.id.button1);
        Button button_B=(Button)rootView.findViewById(R.id.button2);
        Button button_urgent=(Button)rootView.findViewById(R.id.button3);
        button_G.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_G_fragment fragment = new P4_type_G_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_B.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_B_fragment fragment = new P4_type_B_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_urgent.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_urgent_task_fragment fragment = new P4_type_urgent_task_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        return rootView;
    }
}
