/*the fragment is to show all the type of user choose
 * 
 * ---------------------------------------------------------------------------------
 *    fragmentTransaction.addToBackStack(null);
 *    --------->is to record the last fragment we go to 
 * 
 * */

package info.androidhive.slidingmenu;
 
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Page4_TypeFragment extends Fragment {
	
	public Page4_TypeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_type, container, false);
        Button button_BG=(Button)rootView.findViewById(R.id.button_BG);
        Button button_cloth=(Button)rootView.findViewById(R.id.button_cloth);
        Button button_3C=(Button)rootView.findViewById(R.id.button_3C);
        Button button_eat=(Button)rootView.findViewById(R.id.button_eat);
        Button button_gather=(Button)rootView.findViewById(R.id.button_gather);
        Button button_makeup=(Button)rootView.findViewById(R.id.button_makeup);
        Button button_sex=(Button)rootView.findViewById(R.id.button_sex);
        Button button_live=(Button)rootView.findViewById(R.id.button_live);
        Button button_entertain=(Button)rootView.findViewById(R.id.button_entertain);
        Button button_other=(Button)rootView.findViewById(R.id.button_other);
        Button button_gift=(Button)rootView.findViewById(R.id.button_gift);
        button_BG.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Page4_Type_BG_Fragment fragment = new Page4_Type_BG_Fragment();
		            FragmentManager fragmentManager = getFragmentManager();
		            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
		            fragmentTransaction.replace(R.id.frame_container, fragment);
		            fragmentTransaction.addToBackStack(null);
		            fragmentTransaction.commit();
		
			}}
			);
        button_cloth.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Page4_type_Cloth_Fragment fragment = new Page4_type_Cloth_Fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
	/*	            FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.frame_container, fragment).commit();
		*/
			}}
			);
        button_3C.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Page4_type_3C_Fragment fragment = new Page4_type_3C_Fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
		
			}}
			);
        button_eat.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_eat_fragment fragment = new P4_type_eat_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_gift.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_gift_fragment fragment = new P4_type_gift_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_live.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_live_fragment fragment = new P4_type_live_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_gather.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_gather_fragment fragment = new P4_type_gather_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_entertain.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_entertain_fragment fragment = new P4_type_entertain_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_sex.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_sex_fragment fragment = new P4_type_sex_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_makeup.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_makeup_fragment fragment = new P4_type_makeup_fragment();
				FragmentManager fragmentManager = getFragmentManager();
	            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();  
	            fragmentTransaction.replace(R.id.frame_container, fragment);
	            fragmentTransaction.addToBackStack(null);
	            fragmentTransaction.commit();
			}}
			);
        button_other.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				P4_type_other_fragment fragment = new P4_type_other_fragment();
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
