package ru.promansew.downloader;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

public class AsyncTextDL extends AsyncTask<String, Void, String> {
	
	private final View view;
	
	public AsyncTextDL(View v) { view = v; }
	
	protected String doInBackground(String... params) {
		return Downloader.downloadText(params[0]);
	}
	
	protected void onPostExecute(final String result) {
		view.post(new Runnable() {
			public void run() {
				((TextView) view.findViewById(R.id.response)).setText(result);
			}
		});
	}
}
