package com.example.settlelahwaisiong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class Problem_faced_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_faced_1);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public void plumber(View view) {
        Intent intent = new Intent(Problem_faced_1.this, plumber_services.class);
        startActivity(intent);
    }
    public void maintenance(View view) {
        Intent intent = new Intent(Problem_faced_1.this, maintenance_services.class);
        startActivity(intent);
    }
    public void back(View view) {
        Intent intent = new Intent(Problem_faced_1.this, HomePage.class);
        startActivity(intent);
    }

}
