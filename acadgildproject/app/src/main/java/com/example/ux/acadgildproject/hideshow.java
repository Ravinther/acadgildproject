package com.example.ux.acadgildproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Ravi on 6/8/2016.
 */
public class hideshow extends Activity {
    Button btn,btn2;
    TextView txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hideshow);
        btn=(Button)findViewById(R.id.button1);
        txt1=(TextView)findViewById(R.id.image1);
        btn2=(Button)findViewById(R.id.button2);
        btn2.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setVisibility((txt1.getVisibility() == View.VISIBLE)
                        ? View.GONE : View.INVISIBLE);
                btn.setVisibility((btn.getVisibility() == View.VISIBLE)
                                ? View.GONE : View.INVISIBLE
                );
                btn2.setVisibility(View.VISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt1.setVisibility(View.VISIBLE);
                btn2.setVisibility((btn2.getVisibility() == View.INVISIBLE)
                                ? View.VISIBLE : View.INVISIBLE
                );
                btn.setVisibility(View.VISIBLE);
            }
        });
    }
}
