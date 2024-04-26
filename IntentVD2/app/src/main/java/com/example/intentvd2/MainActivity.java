package com.example.intentvd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SwitchToLogin(View v){
        Intent ILogin = new Intent(this, LoginActivity.class);

        startActivity(ILogin);
    }
}