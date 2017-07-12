package com.example.utsav.inbuiltbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

TextView textView;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            textView= (TextView) findViewById(R.id.tv);
            Intent sms_intent=getIntent();
            Bundle b=sms_intent.getExtras();
            if(b!=null){
                // Display SMS in the TextView
                textView.setText(b.getString("sms_str"));
            }
        }



}