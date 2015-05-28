package ru.promansew.downloader;

import android.app.Fragment;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class FragmentImage extends Fragment {
	
	private TextView address;
	private AsyncImgDL dl;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.tabimage, null);
		address = (TextView) view.findViewById(R.id.address);
		view.findViewById(R.id.go).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(dl != null && dl.getStatus() != Status.RUNNING) dl.cancel(true);
				dl = null;
				dl = new AsyncImgDL(view);
				dl.execute(address.getText().toString());
			}
		});
		return view;
	}
}
