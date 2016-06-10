package com.example.ux.project;

import android.app.Activity;
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
public class gridviewmutton extends Activity {
    GridView gv;
    String[] chicken = {"Chettinad Mutton", "Leg Piece Mutton", "Mutton Masala", "Pepper Mutton","Mutton Soup"};
    int[] images = {R.drawable.chettinadmutton, R.drawable.legpeasemutton,R.drawable.muttonmasala,R.drawable.peppermutton,R.drawable.muttonsoup};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muttonvariety);
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

