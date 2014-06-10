package com.example.page_test_1;

import java.util.List;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.support.v4.view.ViewPager;

public class MyPagerAdapter extends PagerAdapter
{
    private static final String TAG = "MyPagerAdapter";
    private List<View> mViewPages;

    public MyPagerAdapter(List<View> viewPages) {
        mViewPages = viewPages;
    }

    @Override
    public int getCount()
    {
        // TODO Auto-generated method stub
        return mViewPages.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1)
    {
        // TODO Auto-generated method stub
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(View v, int position, Object object)
    {
        // TODO Auto-generated method stub
        ((ViewPager) v).removeView(mViewPages.get(position));
    }

    @Override
    public void finishUpdate(View container)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public int getItemPosition(Object object)
    {
        // TODO Auto-generated method stub
        return super.getItemPosition(object);
    }

    @Override
    public Object instantiateItem(View v, int position)
    {
        // TODO Auto-generated method stub
        ((ViewPager) v).addView(mViewPages.get(position));
        return mViewPages.get(position);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader)
    {
        // TODO Auto-generated method stub
    }

    @Override
    public Parcelable saveState()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void startUpdate(View container)
    {
        // TODO Auto-generated method stub
    }

}