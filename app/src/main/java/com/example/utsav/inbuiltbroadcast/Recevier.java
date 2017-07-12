package com.example.utsav.inbuiltbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by utsav on 20-04-2017.
 */

public class Recevier extends BroadcastReceiver {
    private String sms = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(sms)) {
            Bundle bundle = intent.getExtras();
            String format = bundle.getString("format");
            if (bundle != null) {
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i],format);
                }
                for (SmsMessage message : messages) {

                    String strMessageFrom = message.getDisplayOriginatingAddress();
                    String strMessageBody = message.getDisplayMessageBody();


                    Toast.makeText(context, "From : " + strMessageFrom + "\nBody : " + strMessageBody, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
