package com.example.ravi.broadcast.BroaccastReceiver;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravi.broadcast.R;

/**
 * Created by Ravi on 5/31/2016.
 */
public class displaycontact extends ActionBarActivity {
    private dbhelper mydab;
    EditText name, email, phone, palce, street;
    int id_to_update = 0;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts_name);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        palce = (EditText) findViewById(R.id.place);
        street = (EditText) findViewById(R.id.street);
        btn = (Button) findViewById(R.id.button1);
        mydab = new dbhelper(this);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int value = bundle.getInt("id");
            if (value > 0) {
                Cursor cursor = mydab.numofele(value);
                id_to_update = value;
                cursor.moveToFirst();

                String nam = cursor.getString(cursor.getColumnIndex(dbhelper.db_name));
                String pho = cursor.getString(cursor.getColumnIndex(dbhelper.dbname_phone));
                String ema = cursor.getString(cursor.getColumnIndex(dbhelper.dbname_email));
                String str = cursor.getString(cursor.getColumnIndex(dbhelper.dbname_street));
                String pla = cursor.getString(cursor.getColumnIndex(dbhelper.dbname_place));
                if (!cursor.isClosed()) {
                    cursor.close();
                }
                btn.setVisibility(View.INVISIBLE);

                name.setText((CharSequence) nam);
                name.setFocusable(false);
                name.setClickable(false);

                email.setText((CharSequence) ema);
                email.setFocusable(false);
                email.setClickable(false);

                phone.setText((CharSequence) pho);
                phone.setFocusable(false);
                phone.setClickable(false);

                palce.setText((CharSequence) pla);
                palce.setFocusable(false);
                palce.setClickable(false);

                street.setText((CharSequence) str);
                street.setFocusable(false);
                street.setClickable(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Bundle bundle = getIntent().getExtras();

        int value = bundle.getInt("id");
        if (value > 0) {
            getMenuInflater().inflate(R.menu.sqlite_menu, menu);
        } else {
            getMenuInflater().inflate(R.menu.menu_main, menu);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.Edit_contact:
                Button bt = (Button) findViewById(R.id.button1);
                bt.setVisibility(View.INVISIBLE);

                name.setEnabled(true);
                name.setFocusableInTouchMode(true);
                name.setClickable(true);

                email.setEnabled(true);
                email.setFocusableInTouchMode(true);
                email.setClickable(true);

                phone.setEnabled(true);
                phone.setFocusableInTouchMode(true);
                phone.setClickable(true);

                palce.setEnabled(true);
                palce.setFocusableInTouchMode(true);
                palce.setClickable(true);

                street.setEnabled(true);
                street.setFocusableInTouchMode(true);
                street.setClickable(true);
                return true;
            case R.id.Delete_Contact:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage(R.string.Delete)
                        .setPositiveButton(R.string.Yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mydab.deletemethod(id_to_update);
                                Toast.makeText(getBaseContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getBaseContext(),ACtivity_Main.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                AlertDialog d = builder.create();
                d.setTitle("Are You Sure to Delete the Record");
                d.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void run(View view) {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int values = extras.getInt("id");
            if (values > 0)
            {
                if (mydab.updatemethod(id_to_update, name.getText().toString(), phone.getText().toString(), email.getText().toString(), palce.getText().toString(), street.getText().toString()))
                {
                    Toast.makeText(getBaseContext(), "Update", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getBaseContext(),ACtivity_Main.class);
                    startActivity(intent);
                } else
                {
                    Toast.makeText(getBaseContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                if (mydab.insertmethod(name.getText().toString(), phone.getText().toString(), email.getText().toString(), palce.getText().toString(), street.getText().toString()))
                {
                    Intent intent=new Intent(getBaseContext(),ACtivity_Main.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(), "Done", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), "Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

