package com.example.androidbanking;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.model.DBAdapter;


public class HelloActivity extends Activity {
    //Bundle Fields
    private static final String USER_TAG = "Username";
    private static final String ID_TAG = "Num_ID";
    private static final String OPTION_TAG = "Option";
    private static final String DB1_TAG = "DB1";
    private static final String DB2_TAG = "DB2";
    private static final String TYPE_TAG = "AcctType"; // User or Teller
    private static final String CREDIT_DATA = "Credit";
    private static final String DEBIT_DATA = "Debit";


    DBAdapter DB;
    Button manageButton;

    //DBAdapter DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*

        final Bundle USER = this.getIntent().getBundleExtra("USER");
        String credit_data = Double.toString(USER.getDouble(CREDIT_DATA));  //For Info Display
        String debit_data = Double.toString(USER.getDouble(DEBIT_DATA));   // For Info Display
        String id_num = Long.toString(USER.getLong(ID_TAG));

        String user = "Not Null";

		super.onCreate(savedInstanceState);
		setContentView(R.layout.helloactivity);



		TextView text_user = (TextView)findViewById(R.id.editText_user);
        TextView text_credit = (TextView)findViewById(R.id.editText_Credit);
        TextView text_debit = (TextView)findViewById(R.id.editText_Debit);
        TextView text_savings = (TextView)findViewById(R.id.editText_Savings);

        if (USER.getString(USER_TAG)== null){user = "NULL";}
        else { user = USER.getString(USER_TAG);}

        text_user.setText(user);

        //String user = getIntent().getBundleExtra("USER");
        // .getString("USER_TAG");
        // Sets User's Account data for view
		/*
        text.setText(("Hello " + user + "!").toCharArray(), 0, user.length() + 7);
        text_credit.setText(credit);
        text_debit.setText(debit);
        text_savings.setText(savings);
        */
        //Uncomment these things
/*
        //Testing --- set credit_data as rowid
        text_credit.setText(credit_data);
        text_debit.setText(debit_data);
        text_savings.setText("Empty");

        // Set button function
        manageButton = (Button)findViewById(R.id.manageButton);
        manageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent manageIntent = new Intent(v.getContext(), ManageFunds.class);
                manageIntent.putExtra("USER", USER); // Pass Bundle
                startActivity(manageIntent); // Not expecting sth back
                finish();

                // DB.close();
            }


        });
*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello, menu);
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
