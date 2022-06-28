package com.example.settlelahwaisiong;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class register_houseowner extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3,e5,e6,e7;
    Button b1;
    EditText date;
    DatePickerDialog datePickerDialog;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_houseowner);
        date = (EditText) findViewById(R.id.startDate);
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
                datePickerDialog = new DatePickerDialog(register_houseowner.this,
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
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        db=new DatabaseHelper(this);
        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.email);
        e3 = (EditText) findViewById(R.id.pass);
        e5 = (EditText) findViewById(R.id.number);
        e6 = (EditText) findViewById(R.id.houseNumber);
        e7 = (EditText) findViewById(R.id.startDate);
        b1 = (Button) findViewById(R.id.register);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= e1.getText().toString();
                String s2= e2.getText().toString();
                String s3= e3.getText().toString();
                String s5= e5.getText().toString();
                String s6= e6.getText().toString();
                String s7= e7.getText().toString();

                if(s1.equals("")|| s2.equals("")|| s3.equals("")||s5.equals("")||s6.equals("")||s7.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }else{

                        Boolean chkemail = db.chkemail(s2);
                        if(chkemail==true && s2.trim().matches(emailPattern)){
                            Boolean insert = db.insert(s2,s3);
                            if(insert==true){
                                Intent intent = new Intent(register_houseowner.this, admin_main.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();

                            }
                        }else if(chkemail==true && !s2.trim().matches(emailPattern)){
                                Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_SHORT).show();
                            }
                        else if (chkemail==false && s2.trim().matches(emailPattern)){
                            Toast.makeText(getApplicationContext(),"Email already exist",Toast.LENGTH_SHORT).show();
                        }
                    }


                }


        });
    }
}