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

import android.app.Fragment;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Fragment_BG extends Fragment {
	int a=1;
	
   @Override
   public View onCreateView(LayoutInflater inflater,
      ViewGroup container, Bundle savedInstanceState) {

       
       double[] values = new double[] { 2, 14, 11, 10, 19 };//here to change rate
       int[] color = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };

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
      
       /*
       for (double value : values) {
    	   
    	  // if (values.)series.add("hihihi", values);
    	   series.add("Project " + ++k, value);
       }*/
       for (int k =0; k <values.length ; k++ )
       {
    	   if (k==0)series.add("hihihi"+a, values[k]);
    	   else
    		   series.add("fdsa", values[k]);
       }
       return series;
     }


   
}
