package com.example.sendsms;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.telephony.SmsManager;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSms extends Activity {

	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_sms);
		final EditText message = (EditText) findViewById(R.id.editText1);
		final EditText sendto = (EditText) findViewById(R.id.editText2);
		Button btnsend = (Button) findViewById(R.id.button1);
		Button btnclear = (Button) findViewById(R.id.button2);
		btnsend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder alert = new AlertDialog.Builder(SendSms.this);
				alert.setTitle("Title");
				alert.setMessage("Message");
				// Set an EditText view to get user input 
				final EditText input = new EditText(SendSms.this);
				alert.setView(input);
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
					  Editable value = input.getText();
					  
					  if (value.toString().equals("1989"))
					  {
					  // Do something with value!
					  SmsManager sms = SmsManager.getDefault();
						sms.sendTextMessage(sendto.toString(), null, message.getText().toString(), null, null);
						Toast strmsg = Toast.makeText(SendSms.this,
								"Sending", Toast.LENGTH_SHORT);
						strmsg.show();
					  }
					  else
					  {
						  Toast strmsg = Toast.makeText(SendSms.this,
									"failed", Toast.LENGTH_SHORT);
							strmsg.show();
					  }
					  }
					  
					});

					alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					  public void onClick(DialogInterface dialog, int whichButton) {
					    // Canceled.
					  }
					});

					alert.show();
					
				
			}
		});
		
btnclear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				message.setText("");
				Toast strmsg = Toast.makeText(SendSms.this,
						"Cleared", Toast.LENGTH_SHORT);
				strmsg.show();
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_send_sms, menu);
		return true;
	}

}
