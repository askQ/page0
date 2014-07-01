package com.example.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;






import com.example.bean.AddChoiceRequestBean;
import com.example.bean.AskQuestionRequestBean;
import com.example.bean.AuthRequestBean;
import com.example.bean.MemberInfoRequestBean;
import com.google.gson.Gson;

import android.os.AsyncTask;
import android.util.Log;

public class API_1 {

	/* interface */
	public interface OnSuccessListener {
		void onSucess(JSONObject result);
	}

	public interface OnFailListener {
		void onFail(String errorMsg);
	}

	/* static variables and functions */
	private static String serverURL = "http://askq.lionfree.net/";	
	public static String server_url = serverURL.substring(0,serverURL.length()-1) ;
	

		
	public static String OP_REGISTER = "register.php" ;
	public static String OP_LOGIN = "login.php" ;
	public static String OP_EDIT_INFO = "edit_info.php" ;
	public static String OP_QUERY_INFO = "query_info.php" ;
	public static String OP_QUERY_TYPE = "query_type.php" ;
	public static String OP_QUERY_QUESTION = "query_question.php" ;
	public static String OP_QUERY_CONTENT = "query_content.php" ;
	public static String OP_ASK_QUESTION = "ask_question.php" ;
	public static String OP_ADD_CHOICE = "add_choice.php" ;
	public static String OP_DELETE_QUESTION = "delete_question.php" ;
	public static String OP_FINISH_QUESTION = "finish_question.php" ;
	public static String OP_VOTE_QUESTION = "vote_question.php" ;
	
	
	public void login(AuthRequestBean bean) {		
		Gson gson = new Gson() ;	
		try {			
			JSONObject obj = new JSONObject(gson.toJson(bean)) ;
			Task task = new Task() ;
			task.execute(OP_LOGIN,obj.toString()) ;
		} catch (Exception e) {			
			e.printStackTrace() ;
		}		
	}
	
	public void register(MemberInfoRequestBean bean) {		
		Gson gson = new Gson() ;	
		try {			
			JSONObject obj = new JSONObject(gson.toJson(bean)) ;			
			Task task = new Task() ;
			task.execute(OP_REGISTER,obj.toString()) ;
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public void edit_info(AuthRequestBean bean) {		
		Gson gson = new Gson() ;	
		try {			
			JSONObject obj = new JSONObject(gson.toJson(bean)) ;			
			Task task = new Task() ;
			task.execute(OP_EDIT_INFO,obj.toString()) ;
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}
	
	public void query_info(AuthRequestBean bean) {		
		Gson gson = new Gson() ;	
		try {			
			JSONObject obj = new JSONObject(gson.toJson(bean)) ;			
			Task task = new Task() ;
			task.execute(OP_QUERY_INFO,obj.toString()) ;
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}

	public void ask_question(AskQuestionRequestBean bean) {
		Gson gson = new Gson() ;
		try {
			JSONObject obj = new JSONObject(gson.toJson(bean));
			Task task = new Task() ;
			task.execute(OP_ASK_QUESTION, obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add_choice(AddChoiceRequestBean bean) {
		Gson gson = new Gson() ;
		try {
			JSONObject obj = new JSONObject(gson.toJson(bean));
			Task task = new Task() ;
			task.execute(OP_ADD_CHOICE, obj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JSONObject sendRequest(String php, String dataString) throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost request = new HttpPost(serverURL + php);
		List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		postParameters.add(new BasicNameValuePair("data", dataString));
		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParameters, HTTP.UTF_8);
		request.setEntity(formEntity);

		HttpResponse response = httpClient.execute(request);
				
		return new JSONObject(EntityUtils.toString(response.getEntity(), HTTP.UTF_8));
	}	

	private class Task extends AsyncTask<String, Void, JSONObject> {
		@Override
		protected JSONObject doInBackground(String... params) {
			try {				
				return sendRequest(params[0],params[1]);
			} catch (Exception e) {				
				e.printStackTrace();
				return null;
			}
		}

		@Override
		protected void onPostExecute(JSONObject result) {
									
			try {
				if (result != null) {
					if (result.getString("code").equals("0000")) {
						success_callback.onSucess(result);
					} else {
						fail_callback.onFail(result.getString("message"));
					}
				} else {
					fail_callback.onFail("Unknown Error");
				}
			} catch (JSONException e) {				
				e.printStackTrace();
				fail_callback.onFail("Unknown Error");
			}

			super.onPostExecute(result);
		}
	}	
	

	/* variables */
	private OnSuccessListener success_callback;
	private OnFailListener fail_callback;

	/* public functions */	
	public void setOnSuccessListener(OnSuccessListener callback) {
		this.success_callback = callback;
	}

	public void setOnFailListener(OnFailListener callback) {
		this.fail_callback = callback;
	}
	
}
