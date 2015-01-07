package com.example.androidbanking;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class ManageFundsTemplate extends Activity {


    private static final String accountList1[] = {"Credit 1", "Savings 2"};   //REPLACE: initialize with array of accounttypes
    private static final String optionSpinnerList2[] = {"Credit", "Debit", "Transfer", "Calculate Interest"};  // This is set
    private static final String accountList2[] = {"Credit 1", "Savings 2", "Credit 3"}; // Populate second spinner on Click, depending on username selected
    private static String transferToUser;
    private static String transfterToAccount;
    private static int transferToAmount;
    private static boolean transferButtonSelected = false;

    Button Apply;
    Spinner optionSpinner;
    Spinner accountSpinner;
    Spinner hiddenoptionSpinner;
    EditText hiddenText;

    ArrayAdapter<String> account2Adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managefundstemplate);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");
        // Can only initialize in OnCreate

        Apply = (Button) findViewById(R.id.applyButton);  //APPLY BUTTON
        optionSpinner = (Spinner) findViewById(R.id.spinnermfOptions);
        accountSpinner = (Spinner) findViewById(R.id.spinnerAccounts);
        hiddenoptionSpinner = (Spinner) findViewById(R.id.spinnerAccounts2);
        // Spinner Setup
        ArrayAdapter<CharSequence> optionAdapter = new ArrayAdapter(this,
                R.layout.singleitem, optionSpinnerList2);
        ArrayAdapter<String> accountAdapter = new ArrayAdapter(this, R.layout.singleitem, accountList1);


        optionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        optionSpinner.setAdapter(optionAdapter);

        accountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accountSpinner.setAdapter(accountAdapter);
        accountSpinner.getBackground().setAlpha(160);

        TextView selectUserText = (TextView) findViewById(R.id.selectUserTextView);
        selectUserText.getBackground().setAlpha(160);
        //TextView accountText = (TextView) findViewById(R.id.accountText);
        //accountText.getBackground().setAlpha(150);
        // Create the invisble views
        //LinearLayout a = (LinearLayout)findViewById(R.id.a);
        hiddenText = (EditText) findViewById(R.id.hiddenText);
        //Test
        //hiddenText.setText("STUFF");

        //InitialSetupUI();   // UI Instantiation & Setup
        optionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Transfer Button will be position 2 (0 index start)


                try {
                    //LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                    //View newview =inflater.inflate(R.layout.managefundstemplate, null);
                    //LinearLayout a = (LinearLayout)findViewById(R.id.a);
                    //LinearLayout b = (LinearLayout)findViewById(R.id.b);

                    if (parent.getSelectedItemPosition() == 2) {
                        transferButtonSelected = true;
                        hiddenText.setVisibility(View.VISIBLE);
                        hiddenoptionSpinner.setVisibility(View.VISIBLE);


                    } else {
                        transferButtonSelected = false;
                        hiddenText.setVisibility(View.INVISIBLE);
                        hiddenoptionSpinner.setVisibility(View.INVISIBLE);
                    }
                } catch (NullPointerException e) {
                    System.out.println("Something is wrong");
                    Toast.makeText(getApplicationContext(), "Error!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        // Temporary Test
        Apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (transferButtonSelected == true) {
                    try {
                        String temp = hiddenText.getText().toString();

                        Toast.makeText(getApplicationContext(), temp + "Transfer Section being Created!", Toast.LENGTH_LONG).show();

                        account2Adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, accountList2); // Create different array of options depending
                        hiddenoptionSpinner.setAdapter(account2Adapter);
                    } catch (NullPointerException e) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manage_funds_template, menu);
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
