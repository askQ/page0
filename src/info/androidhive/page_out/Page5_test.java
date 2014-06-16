package info.androidhive.page_out;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.slidingmenu.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class Page5_test extends Activity {
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
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.page5_test);
		 listView = (ListView)findViewById(R.id.listView);
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
		        simpleAdapter = new SimpleAdapter(this, 
		                items, R.layout.page5_adapter, ContentItem,
		                ViewID);
		        listView.setAdapter(simpleAdapter);
		    
		 
	 }

}
