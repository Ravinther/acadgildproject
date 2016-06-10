package com.example.ravi.broadcast.BroaccastReceiver;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.ravi.broadcast.R;

/**
 * Created by Ravi on 5/17/2016.
 */
public class Registerunregister extends Activity {
    UserDefinedBroadcastReceiver userdefinedbroadcast=new UserDefinedBroadcastReceiver();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_unregister);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_enabled_services,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
               switch (item.getItemId()) {
            case R.id.menu_on_off:
                Toast.makeText(Registerunregister.this, "Item 1 clicked", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent();
                intent.setAction("com.acadgild.own");
                sendBroadcast(intent);
                return true;
        }
            return super.onOptionsItemSelected(item);
    }


    public void registerbroadcast(View view)
    {
        this.registerReceiver(userdefinedbroadcast,new IntentFilter("com.acadgild.own"));
        Toast.makeText(this,"Enabled Broadcast Services",Toast.LENGTH_SHORT).show();
    }

    public void unregisterbroadcast(View view)
    {
        this.unregisterReceiver(userdefinedbroadcast);
        Toast.makeText(this,"Disable Broadcast Services",Toast.LENGTH_SHORT).show();
    }
}
