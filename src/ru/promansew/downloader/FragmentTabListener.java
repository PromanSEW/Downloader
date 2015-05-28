package ru.promansew.downloader;

import android.app.*;
import android.app.ActionBar.*;
import android.os.Bundle;
 
@SuppressWarnings("deprecation")
public class FragmentTabListener implements TabListener {
	
	private Fragment fragment;
	private final Activity act;
	private final String tag;
	private final Class<? extends Fragment> cls;
	
	public FragmentTabListener(Activity activity, Class<? extends Fragment> cls, String tag) {
		act = activity;
		this.tag = tag;
		this.cls = cls;
	}
	
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		FragmentTransaction sft = act.getFragmentManager().beginTransaction();
		if (fragment == null) {
			fragment = Fragment.instantiate(act, cls.getName(), new Bundle());
			sft.add(android.R.id.content, fragment, tag);
		} else sft.attach(fragment);
		sft.commit();
	}
	
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		FragmentTransaction sft = act.getFragmentManager().beginTransaction();
		sft.detach(fragment);
		sft.commit();
	}
	
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {}
}
