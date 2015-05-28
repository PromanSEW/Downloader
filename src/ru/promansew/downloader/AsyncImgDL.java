package ru.promansew.downloader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

public class AsyncImgDL extends AsyncTask<String, Void, Bitmap> {
	
	private final View view;
	
	public AsyncImgDL(View v) { view = v; }
	
	protected Bitmap doInBackground(String... params) {
		return Downloader.downloadImage(params[0]);
	}
	
	protected void onPostExecute(final Bitmap result) {
		view.post(new Runnable() {
			public void run() {
				((ImageView) view.findViewById(R.id.img)).setImageBitmap(result);
			}
		});
	}
}
