package com.example.androidbanking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;


public class TellerMain extends Activity {
    static String selected = null; // To keep of selected Options, to be added to Option Singleton later

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tellermain);
        String Users[] = {"Bob", "Joe", "Kevin", "Joe"};


        Button ManageFundsButton = (Button) findViewById(R.id.ManageFundsB);
        Button ManageAcctButton = (Button) findViewById(R.id.ManageAccounts);
        //Button SelectButton = (Button)findViewById(R.id.SelectB);


        final AutoCompleteTextView actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        actv.setAdapter(new ArrayAdapter<String>(this, R.layout.tellersearchdropdown, Users));


        ManageFundsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Testing
                    String SelectedUser = actv.getText().toString();
                    selected = SelectedUser;
                    if (selected.equals("Joe")) {
                        Intent mfIntent = new Intent(TellerMain.this, ManageFundsTemplate.class);
                        startActivity(mfIntent);
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(),
                            "Please Select a User First",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        ManageAcctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String SelectedUser = actv.getText().toString();
                    selected = SelectedUser;
                    if (selected.equals("Joe")) {
                        Intent mcIntent = new Intent(TellerMain.this, ManageAcctTemplate.class);
                        startActivity(mcIntent);
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(getApplicationContext(),
                            "Please Select a User First",
                            Toast.LENGTH_LONG).show();
                }


            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teller_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
