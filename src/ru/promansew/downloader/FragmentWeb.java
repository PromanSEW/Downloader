package ru.promansew.downloader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.TextView;

public class FragmentWeb extends Fragment {
	
	private TextView address;
	WebView webview;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.tabweb, null);
		address = (TextView) view.findViewById(R.id.address);
		webview = (WebView) view.findViewById(R.id.web);
		webview.getSettings().setBuiltInZoomControls(true);
		view.findViewById(R.id.go).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				webview.loadUrl(address.getText().toString());
			}
		});
		return view;
	}
}
