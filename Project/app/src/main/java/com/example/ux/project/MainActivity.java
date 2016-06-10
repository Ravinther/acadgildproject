package com.example.ux.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity
{
    ListView listView1;
    String[] dish={"Chicken", "Idly", "Lunch", "Mutton","Egg Gravy","panikaram","Ladddu"};
    int[] image={R.drawable.chicken, R.drawable.idly, R.drawable.southindian, R.drawable.mutton,R.drawable.panikaram,R.drawable.eggcurry,R.drawable.laddu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listview1);
        listView1.setAdapter(new datalist(dish, image));

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent intent=new Intent(getBaseContext(),gridviewchicken.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(getBaseContext(),idlyclass.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(getBaseContext(),mealsgrieview.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(getBaseContext(),gridviewmutton.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(getBaseContext(),gridviewmutton.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5=new Intent(getBaseContext(),gridviewpanikaram.class);
                        startActivity(intent5);
                        break;
                }
            }
        });
    }

    class datalist extends BaseAdapter
    {
        String[] name;
        int[] img;
        datalist()
        {
            name=null;
            img=null;
        }
        public datalist(String[] text,int[] image)
        {
            name=text;
            img=image;
        }
        public int getCount()
        {
            return name.length;
        }
        public Object getItem(int args0)
        {
            return null;
        }
        public  long getItemId(int position)
        {
            return position;
        }

        public View getView(int position,View view,ViewGroup parent)
        {
            LayoutInflater inflater=getLayoutInflater();
            View row;
            row=inflater.inflate(R.layout.images,parent,false);
            TextView textView1;
            ImageView img1;
            textView1=(TextView)row.findViewById(R.id.Textview1);
            img1=(ImageView)row.findViewById(R.id.image1);
            textView1.setText(name[position]);
            img1.setImageResource(img[position]);

            return  row;

        }
    }


}


