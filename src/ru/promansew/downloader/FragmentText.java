package ru.promansew.downloader;

import android.app.Fragment;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FragmentText extends Fragment {
	
	private TextView address;
	private AsyncTextDL dl;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.tabtext, null);
		address = (TextView) view.findViewById(R.id.address);
		view.findViewById(R.id.go).setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(dl != null && dl.getStatus() != Status.RUNNING) dl.cancel(true);
				dl = null;
				dl = new AsyncTextDL(view);
				dl.execute(address.getText().toString());
			}
		});
		return view;
	}
}
