package info.androidhive.slidingmenu;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import org.json.JSONObject;

import com.example.api.API_1;
import com.example.api.API_1.OnFailListener;
import com.example.api.API_1.OnSuccessListener;
import com.example.bean.AuthRequestBean;
import com.example.bean.MemberInfoResponseBean;
import com.example.bean.QuestionBean;
import com.example.testfragment.P13;
import com.example.util.Tool;
import com.google.gson.Gson;
import com.user_vote_pages.P17;
import com.view_my_Q.MP16;
import com.view_my_Q.P19;
import com.view_my_Q.P9;

import android.R.string;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
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
import android.widget.AdapterView.OnItemLongClickListener;

public class PersondeiailFragment extends Fragment {

	ListView listView;
	ListView listView2;
	ArrayAdapter<String> adapter;
	ArrayAdapter<String> adapter2;
	Button changePersonDetail;
	TextView name, account, password, mail, birthday, sexual;

	ImageView personalimg;
	Bitmap personalbitmap;

	ProgressDialog progressDialog;
	String picurl = null;

	// 設定抓完圖片後進行UI切換圖片的處理
	private Handler messageHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0:
				personalimg.setImageBitmap(personalbitmap);
				return;
			}
			progressDialog.dismiss();
		}
	};

	public PersondeiailFragment() {
	}

	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_persondetail,
				container, false);
		name = (TextView) rootView.findViewById(R.id.txtLabel);
		account = (TextView) rootView.findViewById(R.id.UserId);
		password = (TextView) rootView.findViewById(R.id.password);
		mail = (TextView) rootView.findViewById(R.id.mail);
		birthday = (TextView) rootView.findViewById(R.id.age);
		sexual = (TextView) rootView.findViewById(R.id.sex);
		personalimg = (ImageView) rootView.findViewById(R.id.backgrd);

		changePersonDetail = (Button) rootView.findViewById(R.id.button2);
		listView = (ListView) rootView.findViewById(R.id.listView1);
		listView2 = (ListView) rootView.findViewById(R.id.listView2);
		changePersonDetail.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), ChangePersondetail_1.class);
				startActivity(intent);
				getActivity().finish();

			}
		});
		// 皜���
		String[] arr1 = new String[] { "無未完成之問題" };
		String[] arr2 = new String[] { "無已完成之問題" };
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_expandable_list_item_1, arr1);
		adapter2 = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_expandable_list_item_1, arr2);

		listView.setAdapter(adapter);

		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> av, View v,
					final int pos, long id) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), MP16.class);
				startActivity(intent);

				return false;
			}
		});
		listView2.setAdapter(adapter2);

		listView2.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> av, View v,
					final int pos, long id) {
				Intent intent = new Intent();
				intent.setClass(getActivity(), P19.class);
				startActivity(intent);

				return false;
			}
		});

		API_1 api = new API_1();

		AuthRequestBean bean = new AuthRequestBean();
		bean.setSessionid(Tool.getSessionid());

		api.setOnSuccessListener(new OnSuccessListener() {
			// 回傳成功之處理
			@Override
			public void onSucess(JSONObject result) {

				Gson gson = new Gson();

				// 從結果解析出 MemberInfoResponseBean
				MemberInfoResponseBean bean = gson.fromJson(result.toString(),
						MemberInfoResponseBean.class);

				account.setText(bean.getAccount());
				name.setText(bean.getName());
				mail.setText(bean.getEmail());
				birthday.setText(bean.getBirthtime());
				sexual.setText(Tool.getSexName(bean.getSex()));

				QuestionBean[] question = bean.getQuestion();

				ArrayList<String> finish_question = new ArrayList<String>();
				ArrayList<String> unfinish_question = new ArrayList<String>();

				// 判斷是問過問題的話抓取資料

				try {

					if (question != null && question.length != 0) {

						for (int i = 0; i < question.length; i++) {

							if (question[i].getFinishtime() != null) {
								finish_question.add(URLDecoder.decode(
										question[i].getTitle(), "utf-8"));
							} else {
								unfinish_question.add(URLDecoder.decode(
										question[i].getTitle(), "utf-8"));
							}
						}

						Object[] arr1 = unfinish_question.toArray();
						Object[] arr2 = finish_question.toArray();

						String[] str1 = new String[arr1.length];
						String[] str2 = new String[arr2.length];

						for (int i = 0; i < arr1.length; i++) {
							str1[i] = (String) arr1[i];
						}

						for (int i = 0; i < arr2.length; i++) {
							str2[i] = (String) arr2[i];
						}

						adapter = new ArrayAdapter<String>(getActivity(),
								android.R.layout.simple_expandable_list_item_1,
								str1);
						adapter2 = new ArrayAdapter<String>(getActivity(),
								android.R.layout.simple_expandable_list_item_1,
								str2);

						listView.setAdapter(adapter);
						listView2.setAdapter(adapter2);
					}

				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {

					// 假如帶有 picurl 資料 , 則進行圖片傳輸 api
					if ( bean.getPicurl() != null && !"".equals(bean.getPicurl()) ) {
						picurl = API_1.server_url
								+ URLDecoder.decode(bean.getPicurl(), "utf-8");
						new Thread() {
							public void run() {
								personalbitmap = Tool.get_bitmap(picurl);
								messageHandler.sendEmptyMessage(0);
							}
						}.start();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				progressDialog.dismiss();
			}
		});

		api.setOnFailListener(new OnFailListener() {
			// 回傳失敗之處理
			@Override
			public void onFail(String errorMsg) {
				progressDialog.dismiss();
				Toast.makeText(PersondeiailFragment.this.getActivity(), "查詢失敗",
						Toast.LENGTH_LONG).show();
			}
		});

		api.query_info(bean);

		progressDialog = new ProgressDialog(this.getActivity());

		progressDialog.setTitle("查詢個人資料");
		progressDialog.setMessage("處理中");
		progressDialog.show();

		return rootView;
	}

}
