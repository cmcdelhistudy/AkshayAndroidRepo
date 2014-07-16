package com.example.akshayintentstudyapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edName = (EditText) findViewById(R.id.edName);
	}

	public void doWork(View v) {
		// Intent i = new Intent(Intent.ACTION_VIEW);
		// i.setData(Uri.parse("http://www.facebook.com"));//i.setData(Uri.parse("geo:34.5656,89.3434"));
		//
		// startActivity(i);

		// Intent i = new Intent(Intent.ACTION_DIAL);
		// i.setData(Uri.parse("tel:123214"));
		//
		// startActivity(i);

		// Intent i = new Intent(Intent.ACTION_CALL);
		// i.setData(Uri.parse("tel:123214"));
		//
		// startActivity(i);
		String uname = edName.getText().toString();

		Intent i = new Intent(getBaseContext(), SecondActivity.class);

		i.putExtra("NAME", uname);
		i.putExtra("AGE", 12);

		Bundle bag = new Bundle();
		bag.putString("COMICS", "Batman");

		i.putExtra("vip", bag);

		// startActivity(i);
		startActivityForResult(i, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent returnedIntent) {

		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {

				String msg = returnedIntent.getStringExtra("MSG");
				Toast.makeText(getBaseContext(),
						"Msg from Second Activity : " + msg, Toast.LENGTH_SHORT)
						.show();

			}
		}

		super.onActivityResult(requestCode, resultCode, returnedIntent);
	}
}
