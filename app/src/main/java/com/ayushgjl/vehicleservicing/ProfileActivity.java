package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ayushgjl.vehicleservicing.API.UserAPI;
import com.ayushgjl.vehicleservicing.Model.User;
import com.ayushgjl.vehicleservicing.URL.url;

import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.http.Url;

public class ProfileActivity extends AppCompatActivity {

    TextView textView,textView2,textView3,textView4;
    CircleImageView imageView3;
    Button button;
    User  user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        imageView3 = findViewById(R.id.imageView3);
        button = findViewById(R.id.button);
//        user = new User();
        loaduser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, UpdateActivity.class);
                startActivity(intent);
            }
        });

    }

    private void loaduser() {

        UserAPI userApi= url.getInstance().create(UserAPI.class);
//        Call<User> listCall= userApi.getUserDetails(Url.token);



    }
}
