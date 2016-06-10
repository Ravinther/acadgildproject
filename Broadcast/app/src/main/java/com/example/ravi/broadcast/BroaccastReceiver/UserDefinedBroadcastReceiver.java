package com.example.ravi.broadcast.BroaccastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Ravi on 5/17/2016.
 */
public class UserDefinedBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.acadgild.own"))
        {
            StringBuilder msgstr=new StringBuilder("Current Time:");
            Format formatter=new SimpleDateFormat("hh:mm:ss a");
            msgstr.append(formatter.format(new Date()));
            Toast.makeText(context,msgstr,Toast.LENGTH_SHORT).show();
        }
    }
}
