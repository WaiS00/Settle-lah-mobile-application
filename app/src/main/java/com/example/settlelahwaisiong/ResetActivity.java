package com.example.settlelahwaisiong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ResetActivity extends AppCompatActivity {

    TextView username;
    EditText pass, repass;
    Button confirm;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        this.setTitle("Reset Password");

        username = (TextView) findViewById(R.id.username_reset_text);
        pass = (EditText) findViewById(R.id.password_reset);
        repass = (EditText) findViewById(R.id.repassword_reset);
        confirm =(Button) findViewById(R.id.btnconfirm);
        DB =new DatabaseHelper(this);

        Intent intent = getIntent();
        username.setText(intent.getStringExtra("emailaddress"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String email = username.getText().toString();
                    String password = pass.getText().toString();
                    String repassword = repass.getText().toString();
                    if(password.equals(repassword)) {
                        Boolean checkpasswordupdate = DB.updatepassword(email, password);
                        if (checkpasswordupdate == true) {
                            Toast.makeText(ResetActivity.this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ResetActivity.this, "Password Not Updated Successfully", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(ResetActivity.this, "Password does not match", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }
}
