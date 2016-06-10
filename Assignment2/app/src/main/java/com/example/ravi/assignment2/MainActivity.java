package com.example.ravi.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    Spinner sp;
    RadioGroup rb;
    int pos1;
    int pos2;
    EditText Username,Password;
    String user,Pass;
    Button btn;
    boolean click=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username=(EditText)findViewById(R.id.Username);
       user=Username.getText().toString();
        Password=(EditText)findViewById(R.id.Userpassword);
        sp=(Spinner)findViewById(R.id.spinner1);
        btn=(Button)findViewById(R.id.button1);
        btn.setBackgroundDrawable(getResources().getDrawable(R.color.Green));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click = true) {
                    Intent intent = new Intent(getBaseContext(), gridview.class);
                    startActivity(intent);
                    btn.setBackgroundDrawable(getResources().getDrawable((R.color.Red)));
                } else {
                    btn.setBackgroundDrawable(getResources().getDrawable(R.color.colorPrimary));
                }

            }
        });
        btn.setOnLongClickListener(new View.OnLongClickListener() {
            Intent in=new Intent(getBaseContext(),listview.class);

            @Override

            public boolean onLongClick(View v) {
                return false;
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), sp.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                btn.setBackgroundDrawable(getResources().getDrawable(R.color.Green));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        rb=(RadioGroup)findViewById(R.id.radiogroup1);
        rb.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                btn.setBackgroundDrawable(getResources().getDrawable(R.color.Green));

                pos1 = rb.indexOfChild(findViewById(checkedId));
                Toast.makeText(getBaseContext(), "Method 1 ID=" + String.valueOf(pos1), Toast.LENGTH_SHORT).show();
                pos2 = rb.indexOfChild(findViewById(rb.getCheckedRadioButtonId()));
                Toast.makeText(getBaseContext(), "Method 2 ID=" + String.valueOf(pos2), Toast.LENGTH_SHORT).show();
                switch (pos1)
                {
                    case 0:
                        Toast.makeText(getBaseContext(), "You Have Clicked Male", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getBaseContext(), "You Have Clicked Female", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getBaseContext(), "You Have Clicked Other", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getBaseContext(), "You Have Clicked Male", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
