package com.example.smssarabhjeetstudy;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edPhoneNumber, edMessage;

	SmsManager smsmgr;

	String SMS_SENT = "SMS_SENT";
	String SMS_DELIVERED = "SMS_DELIVERED";

	Intent iSent;
	Intent iDelivered;

	PendingIntent piSent;
	PendingIntent piDelivered;

	BroadcastReceiver brSent;
	BroadcastReceiver brDelivered;

	IntentFilter infSent;
	IntentFilter infDelvered;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		edPhoneNumber = (EditText) findViewById(R.id.editText1);
		edMessage = (EditText) findViewById(R.id.editText2);

		smsmgr = SmsManager.getDefault();

		if (smsmgr == null) {
			Toast.makeText(getBaseContext(),
					"Your Device Doesn't support SMS ", Toast.LENGTH_SHORT)
					.show();
		}

		iSent = new Intent(SMS_SENT);
		iDelivered = new Intent(SMS_DELIVERED);

		piSent = PendingIntent.getBroadcast(getBaseContext(), 1, iSent, 0);
		piDelivered = PendingIntent.getBroadcast(getBaseContext(), 2,
				iDelivered, 0);

		brSent = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {

				switch (getResultCode()) {
				case RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS Sent Successfully ",
							Toast.LENGTH_LONG).show();
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(getBaseContext(),
							"Hardware Failure SMS Cannot Be Sent",
							Toast.LENGTH_LONG).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(getBaseContext(),
							"No Service SMS Cannot Be Sent", Toast.LENGTH_LONG)
							.show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(getBaseContext(),
							"No Packates  Null PDU SMS Cannot Be Sent",
							Toast.LENGTH_LONG).show();
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(getBaseContext(),
							"Radio Off SMS Cannot Be Sent", Toast.LENGTH_LONG)
							.show();
					break;

				default:
					break;
				}

			}
		};
		brDelivered = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				switch (getResultCode()) {
				case RESULT_OK:
					Toast.makeText(getBaseContext(), "SMS Devlivered",
							Toast.LENGTH_LONG).show();
					break;

				default:
					break;
				}
			}
		};

		infSent = new IntentFilter(SMS_SENT);
		infDelvered = new IntentFilter(SMS_DELIVERED);
	}

	public void smsSendKaro(View v) {
		String phoneNumber = edPhoneNumber.getText().toString();
		String message = edMessage.getText().toString();

		smsmgr.sendTextMessage(phoneNumber, null, message, piSent, piDelivered);

	}

	@Override
	protected void onResume() {
		registerReceiver(brSent, infSent);
		registerReceiver(brDelivered, infDelvered);
		super.onResume();
	}

	@Override
	protected void onPause() {
		unregisterReceiver(brSent);
		unregisterReceiver(brDelivered);

		super.onPause();
	}
}
