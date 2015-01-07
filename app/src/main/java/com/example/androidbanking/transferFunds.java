package com.example.androidbanking;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class transferFunds extends Activity {

    EditText transferToField;
    EditText amountField;
    Button transferButton;
    Spinner transferFromSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transferfunds);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");

        transferToField = (EditText) findViewById(R.id.accountNum);
        amountField = (EditText) findViewById(R.id.amountText);
        transferButton = (Button) findViewById(R.id.transferButton);
        transferFromSpinner = (Spinner) findViewById(R.id.selectAccountSpinner);

        UserSingleton user = UserSingleton.getInstance();

        transferButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CreateAccount.class);
                startActivityForResult(intent, 0);


                finish(); //Closes this activity
            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.transfer_funds, menu);
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
        Intent i = new Intent(getApplicationContext(), MainActivity.class);

        super.onOptionsItemSelected(item);


        if (id == R.id.logout) {

            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
