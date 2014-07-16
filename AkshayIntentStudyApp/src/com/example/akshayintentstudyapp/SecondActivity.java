package com.example.akshayintentstudyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	TextView tvName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		tvName = (TextView) findViewById(R.id.tvName);

		Intent obtainedIntent = getIntent();

		String obtainedName = obtainedIntent.getStringExtra("NAME");
		int obtainedAge = obtainedIntent.getIntExtra("AGE", 0);

		Bundle b = obtainedIntent.getBundleExtra("vip");
		String obtainedComics = b.getString("COMICS");

		tvName.setText(obtainedName);

		Toast.makeText(getBaseContext(), "Age : " + obtainedAge,
				Toast.LENGTH_SHORT).show();
		Toast.makeText(getBaseContext(), "Comics : " + obtainedComics,
				Toast.LENGTH_SHORT).show();

	}

	public void goBack(View v) {

		Intent i = new Intent();
		i.putExtra("MSG", "Work Done");

		setResult(RESULT_OK, i);

		finish();
	}
}
