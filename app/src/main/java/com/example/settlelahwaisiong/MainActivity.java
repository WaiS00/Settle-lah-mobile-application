package com.example.settlelahwaisiong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public void chooseuser(View view) {
        Intent intent = new Intent(MainActivity.this, ChooseUser.class);
        startActivity(intent);
    }
}
