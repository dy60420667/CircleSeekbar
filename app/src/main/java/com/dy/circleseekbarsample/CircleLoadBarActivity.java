package com.dy.circleseekbarsample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.dy.circleseekbar.CircleLoadBar;

public class CircleLoadBarActivity extends Activity implements OnClickListener {

	public static void gotoActivity(Context context){
		Intent it = new Intent(context,CircleLoadBarActivity.class);
		context.startActivity(it);
	}

	private CircleLoadBar loadBar;
	boolean isStart = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		loadBar = (CircleLoadBar) findViewById(R.id.loadbar);
		loadBar.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (loadBar.getState()) {
		case UN_DO:
			downloadTask.execute("");
			loadBar.setState(CircleLoadBar.State.DOING);
			break;
		case DOING:
			pause();
			loadBar.setState(CircleLoadBar.State.PAUSE);
			break;
		case PAUSE:
			start();
			loadBar.setState(CircleLoadBar.State.DOING);
			break;
		case DONE:
			Toast.makeText(this, "already completed", Toast.LENGTH_SHORT)
					.show();
			break;
		default:
			break;
		}
	}

	private AsyncTask<String, Integer, String> downloadTask = new AsyncTask<String, Integer, String>() {
		int progress = 0;

		@Override
		protected String doInBackground(String... params) {
			while (progress < 100) {
				if (isStart) {
					progress++;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					this.publishProgress(progress);
				}

			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			loadBar.setProgress(values[0]);
		}

		protected void onPostExecute(String result) {
			loadBar.setState(CircleLoadBar.State.DONE);
		};
	};

	public void pause() {
		this.isStart = false;
	}

	public void start() {
		this.isStart = true;
	}
}
