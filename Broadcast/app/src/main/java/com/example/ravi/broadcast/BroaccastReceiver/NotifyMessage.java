package com.example.ravi.broadcast.BroaccastReceiver;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Ravi on 5/17/2016.
 */
public class NotifyMessage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView txt=new TextView(this);
        txt.setText("Notification Message");
        setContentView(txt);
    }
}
