package com.example.ravi.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 06/04/2016.
 */
public class gridview extends Activity {
    List<String> list;
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlayout);
        list=new ArrayList<String>();
        grid=(GridView)findViewById(R.id.gridview1);

        list.add("Ravinther");
        list.add("22");
        list.add("Completed B.Tech 2015");
        list.add("73.90");
        list.add("Working as asp.net deveploer");
        list.add("Playing Cricket");
        list.add("Single");

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        grid.setAdapter(adapter1);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),list.get(position),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
