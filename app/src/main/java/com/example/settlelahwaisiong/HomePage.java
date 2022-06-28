package com.example.settlelahwaisiong;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void problem(View view) {
        Intent intent = new Intent(HomePage.this, Problem_faced_1.class);
        startActivity(intent);
    }

    public void repair(View view) {
        Intent intent = new Intent(HomePage.this, BeneficiaryListActivity.class);
        startActivity(intent);
    }

    public void problemfaced(View view) {
        Intent intent = new Intent(HomePage.this, adminAcceptReject.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(HomePage.this, LoginPage1.class);
        startActivity(intent);
        Toast.makeText(this,"Logout Successfully", Toast.LENGTH_SHORT).show();
    }

    public void btnForgot(View view) {
        Intent intent = new Intent(getApplicationContext(), PasswordActivity.class);
        startActivity(intent);
    }

    public void pic(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailsActivity3.class);
        startActivity(intent);
    }

    public void whatsapp(View view) {
        try {
            Uri uri = Uri.parse("smsto: " + "0122978732");
            Intent i = new Intent(Intent.ACTION_SENDTO, uri);
            i.setPackage("com.whatsapp");
            startActivity(i);
        }catch(Exception e){
            Toast.makeText(this, "Please install the WhatsApp app", Toast.LENGTH_SHORT)
                    .show();
        }
    }

}
