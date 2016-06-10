package com.example.ux.project;

import android.app.Activity;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ravi on 5/15/2016.
 */
public class idlyclass extends Activity {
    GridView gv;
    String[] chicken = {"Rava Idly", "Madurai Idly", "Puthina Idly", "Ragi Idly","Varity Idly","Mutton Gravy Idly","Mysore Idly"};
    int[] images = {R.drawable.ravaidly, R.drawable.maduraiidly,R.drawable.puthinaidly,R.drawable.idly,R.drawable.idlystyle,R.drawable.muttonidly,R.drawable.mysoreidly};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.idlygridview);
        gv = (GridView) findViewById(R.id.gridview1);
        gv.setAdapter(new ImageAdapter(chicken,images));
    }

    class ImageAdapter extends BaseAdapter
    {
        String[] text;
        int[] ima;
        ImageAdapter()
        {
            text=null;
            ima=null;
        }

        public ImageAdapter(String[] s1,int[] s2)
        {
            text=s1;
            ima=s2;
        }

        public int getCount() {
            return images.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return position;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater=getLayoutInflater();
            View row;
            row=inflater.inflate(R.layout.images,parent,false);
            TextView textView1;
            ImageView imageView1;
            textView1=(TextView)row.findViewById(R.id.Textview1);
            imageView1=(ImageView)row.findViewById(R.id.image1);
            textView1.setText(text[position]);
            imageView1.setImageResource(ima[position]);
            return row;
        }
    }
}
