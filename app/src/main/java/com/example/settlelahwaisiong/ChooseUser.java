package com.example.settlelahwaisiong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class ChooseUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_user);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void proceed(View view) {
        Intent intent = new Intent(ChooseUser.this, LoginPage1.class);
        startActivity(intent);
    }
    public void admin(View view) {
        Intent intent = new Intent(ChooseUser.this, adminLogin.class);
        startActivity(intent);
    }
}
