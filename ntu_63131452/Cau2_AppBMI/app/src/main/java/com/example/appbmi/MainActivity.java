package com.example.appbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String severity(double bmi) {
        if (bmi < 18.5) {
            return "Cân nặng thấp";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Bình thường";
        } else if (bmi >= 25 && bmi < 30) {
            return "Tiền béo phì";
        } else {
            return "Béo phì";
        }
    }

    private void calculate(View view){
        double weight, height, bmi;

        EditText inputWeight_ele = findViewById(R.id.inputWeight);
        EditText inputHeight_ele = findViewById(R.id.inputHeight);
        //calculate
        weight = Double.parseDouble(inputWeight_ele.getText().toString());
        height = Double.parseDouble(inputHeight_ele.getText().toString());
        bmi = weight / Math.sqrt(height);

        EditText bmiOutput_ele = findViewById(R.id.bmiOutput);
        bmiOutput_ele.setText(String.valueOf(bmi));

        TextView noticeOutput_ele = findViewById(R.id.noticeOutput);
        noticeOutput_ele.setText(severity(bmi));

    }

}