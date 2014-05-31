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


public class Fragment_G_only extends Fragment{
	@Override
	   public View onCreateView(LayoutInflater inflater,
	      ViewGroup container, Bundle savedInstanceState) {

	       
	       double[] values = new double[] { 12, 14, 11, 10, 19 };
	       int[] color = new int[] { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.CYAN };

	       DefaultRenderer  defaultRenderer =buildCategoryRenderer(color);
	       CategorySeries  categorySeries =buildCategoryDataset("?", values);
	       
		    View pie =ChartFactory.getPieChartView(getActivity(), categorySeries, defaultRenderer);  //??
	       
	        return pie;
	       //Inflate the layout for this fragment   return inflater.inflate(R.layout.fragment_one, container, false);
	   }
	   
	   
	   protected DefaultRenderer buildCategoryRenderer(int[] colors) {
	       DefaultRenderer renderer = new DefaultRenderer();
	       renderer.setLabelsTextSize(15);
	       renderer.setLegendTextSize(15);
	       renderer.setMargins(new int[] { 20, 30, 15, 10 });
	       for (int color : colors) {
	         SimpleSeriesRenderer r = new SimpleSeriesRenderer();
	         r.setColor(color);
	         renderer.addSeriesRenderer(r);
	       }
	       return renderer;
	     }
	   
	   protected CategorySeries buildCategoryDataset(String title, double[] values) {
	       CategorySeries series = new CategorySeries(title);
	       int k = 0;
	       for (double value : values) {
	         series.add("Project " + ++k, value);
	       }

	       return series;
	     }

	   
}
