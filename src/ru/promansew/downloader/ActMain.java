package ru.promansew.downloader;

import android.app.*;
import android.os.Bundle;

@SuppressWarnings("deprecation")
public class ActMain extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.addTab(bar.newTab().setTabListener(new FragmentTabListener(this, FragmentText.class, "1")).setText("Текст"));
		bar.addTab(bar.newTab().setTabListener(new FragmentTabListener(this, FragmentImage.class, "2")).setText("Изображение"));
		bar.addTab(bar.newTab().setTabListener(new FragmentTabListener(this, FragmentWeb.class, "3")).setText("Web"));
	}
}
