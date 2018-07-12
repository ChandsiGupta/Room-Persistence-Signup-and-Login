package com.example.chandsigupta.learnorgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    Button getdata;
    TextView createAccount;
    EditText name,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getdata = findViewById(R.id.getdata);
        createAccount = findViewById(R.id.createAccount);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        getdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean value = DatabaseInitializer.getTestData(AppDatabase.getAppDatabase(LoginActivity.this), name.getText().toString(), email.getText().toString());
                if (value == true) {
                    Intent intent = new Intent( LoginActivity.this,GameActivity.class);
                    startActivity(intent);
                    Log.e("LoginActivity", "Welcome");
                }
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }



    }

