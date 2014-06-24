package info.androidhive.slidingmenu;

import com.example.page_test_1.page_test_1_1;

import android.R.string;
import android.app.Activity;
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
import android.widget.TextView;
import android.widget.Toast;




public class ChangePersondetail extends Activity {

private Button change;
private TextView UserId;
private TextView password1;
private TextView mail1;
private TextView age1;
private TextView sex1;
private TextView name1;
	
	public ChangePersondetail(){}
	
	  public void onCreate(Bundle savedInstanceState) {

	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.fragment_changeperson);
	        
	
	//photo of asker
	photo =(ImageView) findViewById(R.id.img);       
	//photo.setimg(...) ;       
	        
	    
//取得TextView对象
	UserId = (TextView) findViewById(R.id.UserId);
	password1 = (TextView) findViewById(R.id.password);
	mail1 = (TextView) findViewById(R.id.mail);
	age1 = (TextView) findViewById(R.id.age);
	sex1 = (TextView) findViewById(R.id.sex);
	name1 = (TextView) findViewById(R.id.name);
	//取得启动该Activity的Intent对象
	Intent intent =getIntent();
	/*取出Intent中附加的数据*/
	String id = intent.getStringExtra("et1");
	String password = intent.getStringExtra("et2");
	String mail = intent.getStringExtra("et3");
	String age = intent.getStringExtra("et4");
	String sex = intent.getStringExtra("et5");
	String name = intent.getStringExtra("et6");

	UserId.setText(id);
	password1.setText(password);
	mail1.setText(mail);
	age1.setText(age);
	sex1.setText(sex);
	name1.setText(name);

        
        
        change=(Button) findViewById(R.id.button6);
        change.setOnClickListener(new Button.OnClickListener(){
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(ChangePersondetail.this, ChangePersondetail_1.class);
				startActivity(intent); 
				
			}}
			);

        

        
    }
	
}



