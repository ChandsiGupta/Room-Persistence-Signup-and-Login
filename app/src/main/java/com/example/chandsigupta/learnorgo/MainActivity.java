package com.example.chandsigupta.learnorgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button clickhere;
TextView already_user;
EditText name,email,password,confirm_password,mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickhere = findViewById(R.id.click_here_btn);
        already_user = findViewById(R.id.already_user);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        confirm_password = findViewById(R.id.confirm_password);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);

        clickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseInitializer databaseInitializer = new DatabaseInitializer();
                databaseInitializer.populateAsync(AppDatabase.getAppDatabase(MainActivity.this), name.getText().toString(), email.getText().toString(), password.getText().toString(),confirm_password.getText().toString(),mobile.getText().toString());
            }
        });
        already_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}


