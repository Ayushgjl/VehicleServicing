package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ayushgjl.vehicleservicing.API.UserAPI;
import com.ayushgjl.vehicleservicing.Model.User;
import com.ayushgjl.vehicleservicing.URL.url;
import com.squareup.picasso.Picasso;

import java.net.URL;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class ProfileActivity extends AppCompatActivity {

    TextView textView,textView2,textView3,textView4;
    CircleImageView imageView3;
    Button update;
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
        update = findViewById(R.id.update);
        user = new User();
        loaduser();

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, UpdateActivity.class);
                intent.putExtra("User",user);
                startActivity(intent);
            }
        });

    }

    private void loaduser() {

        UserAPI userApi= url.getInstance().create(UserAPI.class);

        Call<User> listCall= userApi.getUserDetails(url.token);
        listCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(ProfileActivity.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                }

                user = response.body();
                if(response.body() != null){

                    String imgPath=null;
                    imgPath=url.imagePath + response.body().getImage();
                    Picasso.get().load(imgPath).into(imageView3);
                }

                textView.setText(response.body().getFirstName());
                textView2.setText(response.body().getLastName());
                textView3.setText(response.body().getPhonenumber());
                textView4.setText(response.body().getUsername());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                Log.d("Error Message" , "Error" + t.getLocalizedMessage());
                Toast.makeText(ProfileActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
