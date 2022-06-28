package com.example.settlelahwaisiong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    EditText emailaddress;
    Button reset;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        this.setTitle("Reset Password");

        emailaddress =(EditText) findViewById(R.id.username_reset);
        reset = (Button) findViewById(R.id.btnreset);
        DB = new DatabaseHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailaddress.getText().toString();

                Boolean checkuser = DB.checkusername(email);
                if(checkuser ==true){
                    Intent intent = new Intent(getApplicationContext(),ResetActivity.class);
                    intent.putExtra("emailaddress",email);
                    startActivity(intent);
                }else{
                    Toast.makeText(PasswordActivity.this,"User does not exists", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
