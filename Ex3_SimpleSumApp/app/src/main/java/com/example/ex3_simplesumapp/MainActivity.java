package com.example.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void TinhTong(View view) {
        EditText edtA = findViewById(R.id.edtA);
        EditText edtB = findViewById(R.id.edtB);
        EditText edtKQ = findViewById(R.id.edtKQ);
        String edtAValue = edtA.getText().toString();
        String edtBValue = edtB.getText().toString();
        int result = Integer.parseInt(edtAValue) + Integer.parseInt(edtBValue);
        edtKQ.setText(String.valueOf(result));
    }
}