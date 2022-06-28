package com.example.settlelahwaisiong;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class adminLogin extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        Email = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        Login = (Button) findViewById(R.id.button);
        Info = (TextView) findViewById(R.id.tvInfo);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                validate(Email.getText().toString(), Password.getText().toString());
            }

        });
    }


    private void validate(String userEmail, String userPassword) {

        if ((userEmail.equals("admin@gmail.com")) && (userPassword.equals("password"))) {
            Intent intent = new Intent(adminLogin.this, admin_main.class);
            startActivity(intent);

        } else if ((userEmail.equals("admin@gmail.com")) && (!userPassword.equals("password"))) {
            Password.setError("Please enter the correct password");
            counter--;

            Info.setText("No of attempts remaining left: " + String.valueOf(counter));

            if (counter == 0) {
                Login.setEnabled(false);
                Info.setText("Please restart the app to login again");}
        } else if ((!userEmail.equals("admin@gmail.com")) && (userPassword.equals("password"))) {
            Email.setError("Please enter the correct Email Address");
            counter--;

            Info.setText("No of attempts remaining left: " + String.valueOf(counter));
        }else{
            if (counter == 0) {
                Login.setEnabled(false);
                Info.setText("Please restart the app to login again");
            } else {
                counter--;
                Email.setError("Please enter the correct Email Address");
                Password.setError("Please enter the correct password");
                Info.setText("No of attempts remaining left: " + String.valueOf(counter));

                if (counter == 0) {
                    Login.setEnabled(false);
                    Info.setText("Please restart the app to login again");
                }
            }

        }}
    public void back(View view) {
        Intent intent = new Intent(adminLogin.this, ChooseUser.class);
        startActivity(intent);
    }


}