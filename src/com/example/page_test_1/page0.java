package com.example.page_test_1;


import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.WindowManager;


public class page0 extends Activity {
 private final int SPLASH_DISPLAY_LENGHT = 1000;//4蝘�
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.page0);
   this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,  
                 WindowManager.LayoutParams.FLAG_FULLSCREEN);  
                 setContentView(R.layout.page0);
                 new Handler().postDelayed(new Runnable() {
                         @Override
                         public void run() {
                                 Intent intent = new Intent(page0.this, Page_test_1.class);
                                 page0.this.startActivity(intent);
//                                 overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                 page0.this.finish();
                         }

                 }, SPLASH_DISPLAY_LENGHT);
         }
 


}
