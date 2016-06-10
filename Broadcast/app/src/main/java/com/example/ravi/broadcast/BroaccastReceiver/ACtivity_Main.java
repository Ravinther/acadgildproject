package com.example.ravi.broadcast.BroaccastReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.ravi.broadcast.R;

import java.util.ArrayList;

/**
 * Created by Ravi on 5/31/2016.
 */
public class ACtivity_Main extends ActionBarActivity
{
    public static final String Extra_Message="Message";
    public ListView listView;
    dbhelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqllitelistview);
        mydb=new dbhelper(this);
        ArrayList arrayList=mydb.getallcontacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayList);
        listView=(ListView)findViewById(R.id.listview1);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int id_to_search=position+1;

                Bundle bundle=new Bundle();
                bundle.putInt("id",id_to_search);
                Intent intent=new Intent(getApplicationContext(),displaycontact.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId())
        {
            case R.id.Addnewcontact:
                Bundle bundle=new Bundle();
                bundle.putInt("id", 0);
                Intent intent=new Intent(getApplicationContext(),displaycontact.class);
                intent.putExtras(bundle);
                startActivity(intent);
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
        }
        return super.onKeyDown(keyCode, event);
    }
}
