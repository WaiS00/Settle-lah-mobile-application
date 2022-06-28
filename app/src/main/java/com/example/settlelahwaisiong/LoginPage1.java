package com.example.settlelahwaisiong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginPage1 extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        db= new DatabaseHelper(this);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e1.getText().toString();
                String password=e2.getText().toString();
                Boolean Chkemailpass = db.emailpassword(email,password);
                if(Chkemailpass==true) {
                    Toast.makeText(getApplicationContext(), "Successfully Login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPage1.this, HomePage.class);
                    startActivity(intent);}
                else
                    Toast.makeText(getApplicationContext(),"Wrong email or password", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void forgot(View view) {
        Intent intent = new Intent(LoginPage1.this, forgot_pass2.class);
        startActivity(intent);
    }
    public void back(View view) {
        Intent intent = new Intent(LoginPage1.this, ChooseUser.class);
        startActivity(intent);
    }
}