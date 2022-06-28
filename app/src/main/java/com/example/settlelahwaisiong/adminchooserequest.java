package com.example.settlelahwaisiong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class adminchooserequest extends AppCompatActivity {

    ImageButton btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminchooserequest);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageButton btn1 = (ImageButton)findViewById(R.id.lan1);
        Button btn2 = (Button) findViewById(R.id.lan2);
        Button btn3 = (Button) findViewById(R.id.lan3);
        ImageButton btn4 = (ImageButton)findViewById(R.id.lan4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity3.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity3.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeneficiaryListActivity.class);
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BeneficiaryListActivity.class);
                startActivity(intent);
            }
        });

    }
    public void back(View view) {
        Intent intent = new Intent(adminchooserequest.this, admin_main.class);
        startActivity(intent);
    }

}
