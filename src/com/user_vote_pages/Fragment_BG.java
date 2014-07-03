package com.user_vote_pages;

import java.util.ArrayList;
import java.util.List;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.example.bean.ChoiceBean;
import com.example.bean.ContentResponseBean;
import com.example.util.Tool;
import com.google.gson.Gson;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Fragment_BG extends Fragment {
	
	double[] values = null ;
	String [] titile = null ;
    int[] color = null ;	
	
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {

       
	   String questionContent = this.getActivity().getIntent().getStringExtra("QuestionContent") ;		 
	   Gson gson = new Gson() ;			
	   ContentResponseBean responseBean = gson.fromJson(questionContent,ContentResponseBean.class);
	   
	   ChoiceBean [] choice_arr = responseBean.getChoice() ;
	   
	   //假如有選項的情況,抓取內容
	   if(choice_arr!=null && choice_arr.length>0) {
		   
		   values = new double[choice_arr.length] ;
		   titile = new String[choice_arr.length] ;
		
		   //建立選項標題,投票數陣列
		   for(int i=0 ; i<choice_arr.length ; i++) {
			   titile[i] = choice_arr[i].getTitle() ;
			   values[i] = Double.parseDouble(choice_arr[i].getNum_click()) ;			    
		   }
		   
	   }
	   else {
		   values = new double[] { 0 };//here to change rate		       
	       titile = new String[] {""} ;
	   }
	   
	   color = Tool.getColorArray(values.length) ;

       DefaultRenderer  defaultRenderer =buildCategoryRenderer(color);
       CategorySeries  categorySeries =buildCategoryDataset("?", values);
       
	    View pie =ChartFactory.getPieChartView(getActivity(), categorySeries, defaultRenderer);  //??
	    pie.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			}
			  
	    	
	    	
		});
        return pie;
     
   
   
   
 
}


protected DefaultRenderer buildCategoryRenderer(int[] colors) {
       DefaultRenderer renderer = new DefaultRenderer();
       renderer.setLabelsTextSize(30);//text on pie
       renderer.setLegendTextSize(30);//text down pie
       renderer.setMargins(new int[] { 20, 30, 15, 10 });
       renderer.setPanEnabled(false); 
       for (int color : colors) {
         SimpleSeriesRenderer r = new SimpleSeriesRenderer();
         r.setColor(color);
         renderer.addSeriesRenderer(r);
       }
      
       return renderer;
     }
   
   protected CategorySeries buildCategoryDataset(String title, double[] values) {
	   
       CategorySeries series = new CategorySeries(title);
       
       for(int i=0 ; i<values.length ; i++) {
    	   series.add(titile[i],values[i]); 
       }
       
       return series;
     }


   
}
