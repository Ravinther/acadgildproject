package com.example.ux.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Ravi on 5/12/2016.
 */
public class listview extends Activity

{
    ListView listView;
    String[] dish={"Chicken", "Idly", "Lunch", "Mutton"};
    int[] image={R.drawable.chicken, R.drawable.idly, R.drawable.southindian, R.drawable.mutton};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview1);
        listView.setAdapter(new datalistadapter(dish,image));
    }
    class datalistadapter extends BaseAdapter
    {
        String[] text;
        int[] ima;
        datalistadapter()
        {
            text=null;
            ima=null;
        }

        public datalistadapter(String[] s1,int[] s2)
        {
            text=s1;
            ima=s2;
        }
        public int getCount()
        {
            return  text.length;
        }
        public Object getItem(int args0)
        {
            return null;
        }
        public long getItemId(int position)
        {
            return position;
        }

        public View getView(int position,View view,ViewGroup viewGroup)
        {
            LayoutInflater inflater=getLayoutInflater();
            View row;
            row=inflater.inflate(R.layout.images,viewGroup,false);
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
