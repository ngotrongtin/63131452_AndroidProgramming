package com.example.intentvd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    String dbName = "ngotrongtin";
    String dbPassword = "password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginCheck(View v){
        EditText userNameInput = findViewById(R.id.UserNameInput);
        EditText passwordInput = findViewById(R.id.PasswordInput);
        TextView notifyAreaOutput = findViewById(R.id.NotifyArea);
        String userNameInputStr = userNameInput.getText().toString();
        String passwordInputStr = passwordInput.getText().toString();

        if(!userNameInputStr.equals(dbName) || !passwordInputStr.equals(dbPassword)){
            notifyAreaOutput.setText("Mật khẩu hoặc tên không hợp lệ");
            return;
        }


        Intent IHome = new Intent(this, HomeActivity.class);
        IHome.putExtra("userName", userNameInputStr);
        IHome.putExtra("password", passwordInputStr);

        startActivity(IHome);
    }


}