package com.example.ravi.assignment2;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Ravi on 08/04/2016.
 */
public class listview extends Activity
{
    ListView li;
    String[] text={"Video1","Video2"};
    String[] text2={"Lesson1","Lesson1"};
    int[] image={R.drawable.user,R.drawable.download};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        li=(ListView)findViewById(R.id.listview1);
        li.setAdapter(new datalistadapter(text,text2,image));

    }
    class  datalistadapter extends  BaseAdapter
    {
            String[] Title,Detail;
            int[] Img;
        datalistadapter()
        {
            Title=null;
            Detail=null;
            Img=null;
        }

    public datalistadapter(String[] s1,String[] s2,int[] s3)
    {
            Title=s1;
            Detail=s2;
            Img=s3;
    }
        public int getCount()
        {
            return Title.length;
        }
        public Object getItem(int args0)
        {
            return null;
        }
        public  long getItemId(int position)
        {
            return position;
        }

        public View getView(int position,View convertVIew,ViewGroup parent)
        {
            LayoutInflater inflater=getLayoutInflater();
            View row;
            row=inflater.inflate(R.layout.customs,parent,false);
            TextView title,detail;
            ImageView img;
            title=(TextView)row.findViewById(R.id.title1);
            detail=(TextView)row.findViewById(R.id.text3);
            img=(ImageView)row.findViewById(R.id.image1);
            title.setText(Title[position]);
            detail.setText(Detail[position]);
            img.setImageResource(Img[position]);


            return row;
        }
    }
}
