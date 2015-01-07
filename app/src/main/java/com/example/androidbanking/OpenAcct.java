package com.example.androidbanking;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class OpenAcct extends Activity {

    Button create;
    Spinner accountSpinner;
    private static final String accountList[] = {"Checkings", "Savings"};
    private static final String defaultSelect[] = {"Account Type"};
    ArrayAdapter<String> accountAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_acct);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");

        create = (Button) findViewById(R.id.createBtn);
        accountSpinner = (Spinner) findViewById(R.id.typeSpinner);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "create",
                        Toast.LENGTH_SHORT).show();
            }
        });
        accountAdapter = new ArrayAdapter(this, R.layout.singleitem, accountList);

        accountAdapter.setDropDownViewResource(R.layout.singleitem);
        accountSpinner.setAdapter(accountAdapter);

        accountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getSelectedItemPosition() == 0) {

                    //checking account selected
                    Toast.makeText(getApplicationContext(), "checking",
                            Toast.LENGTH_SHORT).show();
                } else if (parent.getSelectedItemPosition() == 1) {
                    //saving account selected

                    Toast.makeText(getApplicationContext(), "saving",
                            Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_open_acct, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
