package com.ayushgjl.vehicleservicing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ayushgjl.vehicleservicing.bll.LoginBLL;
import com.ayushgjl.vehicleservicing.strictmode.StrictModeClass;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUser, etpwd;
    Button btnLogin;
    TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etpwd = findViewById(R.id.etPwd);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        String email=etUser.getText().toString();
        String password=etpwd.getText().toString();

        LoginBLL loginBLL=new LoginBLL();

        StrictModeClass.StrictMode();
        if (loginBLL.checkUser(email,password)){
            Intent intent=new Intent(LoginActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "email and password is incorrect", Toast.LENGTH_LONG).show();
            etUser.requestFocus();
        }
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
