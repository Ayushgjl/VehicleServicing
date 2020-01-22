package com.ayushgjl.vehicleservicing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    TextView tvBackToLogin;
    EditText etFname,etLname,etContact,etEmail,etPassword,etRePassword;
    ImageView imgProfile;
    Button btnRegister;
    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        tvBackToLogin=findViewById(R.id.tvback);
        etFname=findViewById(R.id.etfirstname);
        etLname=findViewById(R.id.etlastname);
        etContact=findViewById(R.id.etnumber);
        etEmail=findViewById(R.id.etemail);
        etPassword=findViewById(R.id.etpassword);
        etRePassword=findViewById(R.id.etrepassword);
        imgProfile=findViewById(R.id.imgProfile);
        btnRegister=findViewById(R.id.btnregister);

        tvBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etPassword.getText().toString().equals(etRePassword.getText().toString())){
//                    saveImageOnly();
//                    signUp();
                }else {
                    Toast.makeText(RegisterActivity.this, "Password does not match", Toast.LENGTH_LONG).show();
                    etPassword.requestFocus();
                    return;
                }
            }
        });
    }

    private void BrowseImage() {

        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/");
        startActivityForResult(intent,0);
    }
}
