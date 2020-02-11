package com.example.vehicleservicingwear;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vehicleservicingwear.URL.url;
import com.example.vehicleservicingwear.strictmode.StrictModeClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends WearableActivity {
    private TextView login;
    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etemail);
        etPassword = findViewById(R.id.etpassword);
        btnLogin = findViewById(R.id.btnlogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        setAmbientEnabled();
    }

    private void login() {

        String email=etEmail.getText().toString();
        String password=etPassword.getText().toString();

        username Username = new username(email,password);

        StrictModeClass.StrictMode();
        UserAPI userAPI = url.getInstance().create(UserAPI.class);
        Call<SignUpResponse> userCall = userAPI.checklogin(Username);
        userCall.enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Email and password is not correct", Toast.LENGTH_SHORT).show();

                    etEmail.setText("");
                    etPassword.setText("");

                    return;
                }

                Toast.makeText(MainActivity.this, "Redirecting...", Toast.LENGTH_SHORT).show();
                url.token += response.body().getToken();
                startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
