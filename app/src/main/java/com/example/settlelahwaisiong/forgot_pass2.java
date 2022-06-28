package com.example.settlelahwaisiong;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.DatePicker;

import java.util.Calendar;


public class forgot_pass2 extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = forgot_pass2.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutBeneficiaryName;
    private TextInputLayout textInputLayoutBeneficiaryEmail;
    private TextInputLayout textInputLayoutBeneficiaryAddress;
    private TextInputLayout textInputLayoutBeneficiaryCountry;
    private TextInputLayout textInputLayoutBeneficiaryId;

    private TextInputEditText textInputEditTextBeneficiaryName;
    private TextInputEditText textInputEditTextBeneficiaryEmail;
    private TextInputEditText textInputEditTextBeneficiaryAddress;
    private TextInputEditText textInputEditTextBeneficiaryCountry;
    private TextInputEditText textInputEditTextBeneficiaryId;


    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewBenefList;

    private InputValidation2 inputValidation;
    private DatabaseHelper3 databaseHelper1;
    private Forgot forgot;
    EditText date;
    DatePickerDialog datePickerDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pass2);
        this.setTitle("Forgot Password");

        initViews();
        initObjects();
        initListeners();

        // initiate the date picker and a button
        date = (android.support.design.widget.TextInputEditText) findViewById(R.id.textInputEditTextBeneficiaryCountry);
        // perform click event on edit text
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(forgot_pass2.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


    }



    //Initialize Views
    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutBeneficiaryName = (TextInputLayout) findViewById(R.id.textInputLayoutBeneficiaryName);
        textInputLayoutBeneficiaryEmail = (TextInputLayout) findViewById(R.id.textInputLayoutBeneficiaryEmail);
        textInputLayoutBeneficiaryAddress = (TextInputLayout) findViewById(R.id.textInputLayoutBeneficiaryAddress);
        textInputLayoutBeneficiaryCountry = (TextInputLayout) findViewById(R.id.textInputLayoutBeneficiaryCountry);
        textInputLayoutBeneficiaryId = (TextInputLayout) findViewById(R.id.textInputLayoutBeneficiaryId);

        textInputEditTextBeneficiaryName = (TextInputEditText) findViewById(R.id.textInputEditTextBeneficiaryName);
        textInputEditTextBeneficiaryEmail = (TextInputEditText) findViewById(R.id.textInputEditTextBeneficiaryEmail);
        textInputEditTextBeneficiaryAddress = (TextInputEditText) findViewById(R.id.textInputEditTextBeneficiaryAddress);
        textInputEditTextBeneficiaryCountry = (TextInputEditText) findViewById(R.id.textInputEditTextBeneficiaryCountry);
        textInputEditTextBeneficiaryId = (TextInputEditText) findViewById(R.id.textInputEditTextBeneficiaryId);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);


    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        appCompatButtonRegister.setOnClickListener(this);

    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        inputValidation = new InputValidation2(activity);
        databaseHelper1 = new DatabaseHelper3(activity);
        forgot = new Forgot();
    }

    @Override
    public void onClick(View v) {



        switch (v.getId()) {

            case R.id.appCompatButtonRegister:
                postDataToSQLite();
                break;

            case R.id.appCompatTextViewBenefList:
                Intent accountsIntent = new Intent(activity, ForgotListActivity.class);
                accountsIntent.putExtra("ID", textInputEditTextBeneficiaryId.getText().toString().trim());
                accountsIntent.putExtra("NAME", textInputEditTextBeneficiaryName.getText().toString().trim());
                accountsIntent.putExtra("EMAIL", textInputEditTextBeneficiaryEmail.getText().toString().trim());
                accountsIntent.putExtra("ADDRESS", textInputEditTextBeneficiaryAddress.getText().toString().trim());
                accountsIntent.putExtra("COUNTRY", textInputEditTextBeneficiaryCountry.getText().toString().trim());
                emptyInputEditText();
                startActivity(accountsIntent);
                break;
        }
    }

    private void postDataToSQLite() {
        if (!inputValidation.isInputEditTextFilled(textInputEditTextBeneficiaryName, textInputLayoutBeneficiaryName, getString(R.string.error_message_name))) {
            return;
        }
        else if (!inputValidation.isInputEditTextFilled(textInputEditTextBeneficiaryId, textInputLayoutBeneficiaryId, getString(R.string.error_message_email))) {
            return;
        }
        else if (!inputValidation.isInputEditTextFilled(textInputEditTextBeneficiaryEmail, textInputLayoutBeneficiaryEmail, getString(R.string.error_message_email))) {
            return;
        }
        else if (!inputValidation.isInputEditTextFilled(textInputEditTextBeneficiaryAddress, textInputLayoutBeneficiaryAddress, getString(R.string.error_message_email))) {
            return;
        }
        else if (!inputValidation.isInputEditTextFilled(textInputEditTextBeneficiaryCountry, textInputLayoutBeneficiaryCountry, getString(R.string.error_message_email))) {
            return;
        }


        if (!databaseHelper1.checkUser(textInputEditTextBeneficiaryEmail.getText().toString().trim())) {

            forgot.setId(Integer.parseInt(textInputEditTextBeneficiaryId.getText().toString().trim()));
            forgot.setName(textInputEditTextBeneficiaryName.getText().toString().trim());
            forgot.setEmail(textInputEditTextBeneficiaryEmail.getText().toString().trim());
            forgot.setAddress(textInputEditTextBeneficiaryAddress.getText().toString().trim());
            forgot.setCountry(textInputEditTextBeneficiaryCountry.getText().toString().trim());


            databaseHelper1.addBeneficiary(forgot);

            // Snack Bar to show success message that record saved successfully
            Intent accountsIntent = new Intent(activity, ChooseUser.class);
            Toast.makeText(this, "Requested Successfully!", Toast.LENGTH_SHORT)
                    .show();
            accountsIntent.putExtra("ID", textInputEditTextBeneficiaryId.getText().toString().trim());
            accountsIntent.putExtra("NAME", textInputEditTextBeneficiaryName.getText().toString().trim());
            accountsIntent.putExtra("EMAIL", textInputEditTextBeneficiaryEmail.getText().toString().trim());
            accountsIntent.putExtra("ADDRESS", textInputEditTextBeneficiaryAddress.getText().toString().trim());
            accountsIntent.putExtra("COUNTRY", textInputEditTextBeneficiaryCountry.getText().toString().trim());
            emptyInputEditText();



            startActivity(accountsIntent);


        }


    }

    private void emptyInputEditText() {
        textInputEditTextBeneficiaryName.setText(null);
        textInputEditTextBeneficiaryEmail.setText(null);
        textInputEditTextBeneficiaryAddress.setText(null);
        textInputEditTextBeneficiaryCountry.setText(null);
    }

    public void problem(View view) {
        Intent intent = new Intent(forgot_pass2.this, ChooseUser.class);
        startActivity(intent);
    }


}
