package info.androidhive.slidingmenu;

import info.androidhive.slidingmenu.adapter.NavDrawerListAdapter;
import info.androidhive.slidingmenu.model.NavDrawerItem;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class Page4_MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);//alist
		
		/*Danger start, wt code*/
		View header=getLayoutInflater().inflate(R.layout.header,null);
		ImageView asker_photo = (ImageView) header.findViewById(R.id.backgrd);
		///set the asker's photo here
		asker_photo.setImageAlpha(R.drawable.hot);
		
		mDrawerList.addHeaderView(header);
	
		header.setOnClickListener(new OnClickListener(){
			Fragment fragment = null;
		    @Override
		    public void onClick(View v) {
		    	displayView(20);
		    	//fragment = new PersondeiailFragment();
		    }
		});
		/*wt code end, danger END*/
		
		
		// adding nav drawer items to array		
		navDrawerItems = new ArrayList<NavDrawerItem>();
		
		
	//	navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		// Find People
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
		// What's hot, We  will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));
		
		
		// Recycle the typed array
		navMenuIcons.recycle();

	
		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		
		
		mDrawerList.setAdapter(adapter);

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		
		
		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
	    getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0); //NOTE!!
		}
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			position -= mDrawerList.getHeaderViewsCount();//wt added
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		
		switch (position) {
		
		 case 0:
	            fragment = new Page4_NewestFragment();
	            FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();

				// update selected item and title, then close the drawer
				mDrawerList.setItemChecked(position+1, true);
				mDrawerList.setSelection(position);
				setTitle(navMenuTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
	            break;
		 case 1:
	            fragment = new Page4_HotFragment();
	            FragmentManager fragmentManager1 = getFragmentManager();
				fragmentManager1.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();

				// update selected item and title, then close the drawer
				mDrawerList.setItemChecked(position+1, true);
				mDrawerList.setSelection(position);
				setTitle(navMenuTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
	            break;
	     case 2:
	            fragment = new Page4_TypeFragment();
	            FragmentManager fragmentManager2 = getFragmentManager();
				fragmentManager2.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();

				// update selected item and title, then close the drawer
				mDrawerList.setItemChecked(position+1, true);
				mDrawerList.setSelection(position);
				setTitle(navMenuTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
	            break;
	     case 3:
	            fragment = new Page4_TransportFragment();
	            FragmentManager fragmentManager3 = getFragmentManager();
				fragmentManager3.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();

				// update selected item and title, then close the drawer
				mDrawerList.setItemChecked(position+1, true);
				mDrawerList.setSelection(position);
				setTitle(navMenuTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
	            break;
	     case 4:
	            fragment = new PagesFragment();
	            FragmentManager fragmentManager4 = getFragmentManager();
				fragmentManager4.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();

				// update selected item and title, then close the drawer
				mDrawerList.setItemChecked(position+1, true);
				mDrawerList.setSelection(position);
				setTitle(navMenuTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
	            break;
	     case 5:
	            fragment = new Page4_Etc2Fragment();
	            FragmentManager fragmentManager5 = getFragmentManager();
				fragmentManager5.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();

				// update selected item and title, then close the drawer
				mDrawerList.setItemChecked(position+1, true);
				mDrawerList.setSelection(position);
				setTitle(navMenuTitles[position]);
				mDrawerLayout.closeDrawer(mDrawerList);
	            break;
	     case 20:
	    	 mDrawerList.setItemChecked(0, true);
	    	 fragment = new PersondeiailFragment();
	    	 FragmentManager fragmentManager6 = getFragmentManager();
				fragmentManager6.beginTransaction()
						.replace(R.id.frame_container, fragment).commit();
			setTitle("Persondetail");
			mDrawerLayout.closeDrawer(mDrawerList);
	    	 break;
	 
	     default:
	            break;
		
		}
/*
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
		*/
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

}
