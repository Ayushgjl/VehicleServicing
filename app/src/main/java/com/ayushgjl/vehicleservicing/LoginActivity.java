package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUser, etpwd;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etpwd = findViewById(R.id.etPwd);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnLogin){
            String username1 = etUser.getText().toString();
            String password1 = etpwd.getText().toString();

            if(username1.equals("admin")  && password1.equals("admin") ) {
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
            }

        }

    }
}
