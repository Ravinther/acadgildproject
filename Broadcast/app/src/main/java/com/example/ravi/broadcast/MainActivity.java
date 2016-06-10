package com.example.ravi.broadcast;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            call();
            }
        });

    }
    public void  call()
    {
        try {
            Intent intentcall = new Intent(Intent.ACTION_CALL);
            intentcall.setData(Uri.parse("tel:"+"9751410036"));
            startActivity(intentcall);
        }
        catch (ActivityNotFoundException ex)
        {
        }
    }
}
