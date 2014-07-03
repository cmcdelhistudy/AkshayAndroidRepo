package com.example.refrencingviewstudy;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText ed;
	TextView tv;

	RelativeLayout ms;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ed = (EditText) findViewById(R.id.edName);
		tv = (TextView) findViewById(R.id.tvDisp);
		ms = (RelativeLayout) findViewById(R.id.mainScreen);
	}

	public void showMe(View v) {
		String data = ed.getText().toString();

		Toast.makeText(getBaseContext(), "Data : " + data, Toast.LENGTH_LONG)
				.show();

		tv.setText(data);

		Log.d("AKSHAY", "This is debug message");
		Log.e("AKSHAY", "This is error message");
		Log.i("AKSHAY", "This is information message");
		Log.w("AKSHAY", "This is warning message");

	}

	public void doCongress(View v) {
		ms.setBackgroundColor(Color.rgb(230, 100, 200));
	}

	public void doBJP(View v) {
		ms.setBackgroundColor(Color.RED);
	}

}
