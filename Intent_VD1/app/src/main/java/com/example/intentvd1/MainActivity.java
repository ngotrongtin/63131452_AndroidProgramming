package com.example.intentvd1;

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

    public void SwitchActivity(View v){
        Intent IManHinhKhac = new Intent(this, MainActivity2.class);

        startActivity(IManHinhKhac);
    }
}