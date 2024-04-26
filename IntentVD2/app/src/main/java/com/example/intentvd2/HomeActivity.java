package com.example.intentvd2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView userNameOutput = findViewById(R.id.nameLabel);
        Intent Ilogin = getIntent();
        String userName = Ilogin.getStringExtra("userName");

        userNameOutput.setText(userName);
    }
}