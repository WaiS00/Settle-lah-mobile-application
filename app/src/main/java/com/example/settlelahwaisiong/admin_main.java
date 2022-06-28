package com.example.settlelahwaisiong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class admin_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }
    public void register(View view) {
        Intent intent = new Intent(admin_main.this, register_houseowner.class);
        startActivity(intent);
    }
    public void pending(View view) {
        Intent intent = new Intent(admin_main.this, adminchooserequest.class);
        startActivity(intent);
    }
    public void logout(View view) {
        Intent intent = new Intent(admin_main.this, adminLogin.class);
        startActivity(intent);
        Toast.makeText(this,"Logout Successfully", Toast.LENGTH_SHORT).show();
    }
    public void btnForgot(View view){
        Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
        startActivity(intent);
    }
    public void reset(View view){
        Intent intent = new Intent(getApplicationContext(), ForgotListActivity.class);
        startActivity(intent);
    }
}
