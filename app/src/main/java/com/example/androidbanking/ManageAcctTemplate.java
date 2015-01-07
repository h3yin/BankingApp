package com.example.androidbanking;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ManageAcctTemplate extends Activity {

    Button closeAcct;
    Button openAcct;
    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manageaccttemplate);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");

        temp = (TextView) findViewById(R.id.accountType1);
        closeAcct = (Button) findViewById(R.id.closeAcct);
        openAcct = (Button) findViewById(R.id.openAcct);
        closeAcct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Are You Sure Want To Close Account " + temp.getText() + " ?",
                        Toast.LENGTH_LONG).show();
            }
        });

        openAcct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),
                        "Are You Sure Want To Open a New Account?",
                        Toast.LENGTH_LONG).show();

            }


        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manage_acct_template, menu);
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
