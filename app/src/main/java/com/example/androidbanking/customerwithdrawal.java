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
import android.widget.Toast;

public class customerwithdrawal extends Activity {

    private int accountNumber = 0;
    private Spinner accountSpinner;
    private EditText amountField;
    private Button withdrawButton;
    private UserSingleton user;
    static String JsonStatic = null;

    private static String[] paths = {"Saving 1", "Checking 2", "Saving 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerwithdrawal);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("");


        accountSpinner = (Spinner) findViewById(R.id.selectacctspinner);
        amountField = (EditText) findViewById(R.id.amountText);
        withdrawButton = (Button) findViewById(R.id.withdrawBtn);

        user = UserSingleton.getInstance();

        paths = new String[user.getnumOfAccounts()];

        for (int i = 0; i < user.getnumOfAccounts(); i++) {
            paths[i] = user.getSingleAccountType(i) + " " + (i + 1);
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.singleitem, paths);
        adapter.setDropDownViewResource(R.layout.singleitem);
        accountSpinner.setAdapter(adapter);

        accountSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                accountNumber = user.getSingleAccountNumber(position);

            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        withdrawButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                                  UserSingleton user = UserSingleton.getInstance();

                                                  String email = user.getuserName();
                                                  String password = user.getPassword();
                                                  String account_number = accountNumber + "";
                                                  try {
                                                      String amount = Double.parseDouble(amountField.getText().toString()) + "";
                                                      //String account_new = "n";
                                                      //String deposit = "d";
                                                      //String transfer = "t";
                                                      String account_from = "";
                                                      String account_to = "";
                                                      String request = "withdraw"; // DEPENDENT ON THIS ACTIVITY

                                                      String[] tempParams = new String[]{ amount, account_number};

                                                      user.queryRequest(request,tempParams);
                                                      /*
                                                      //String[] params = new String[]{request,email, password, account_number, amount, account_new, deposit, account_from, account_to};
                                                      String[] params = new String[]{request, email, password, account_from, account_to, amount, account_number};

                                                      Connect connection = new Connect();

                                                      connection.execute(params);

//                String Json = getIntent().getExtras().getString("Json");
//                JsonStatic = Json;
                                                        */
                                                      Intent mfIntent = new Intent(customerwithdrawal.this, CustomerMain.class);

                                                      startActivity(mfIntent);

                                                      finish();


                                                  } catch (NumberFormatException e) {
                                                      e.printStackTrace();
                                                      Toast.makeText(getApplication(), "Please Enter a Valid Amount", Toast.LENGTH_LONG);
                                                  }
                                              }
                                          }

        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customerwithdrawal, menu);
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
