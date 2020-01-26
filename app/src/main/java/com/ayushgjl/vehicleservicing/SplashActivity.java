package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;


public class SplashActivity extends AppCompatActivity {
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView=(ImageView) findViewById(R.id.imageView);

        Animation  animation= AnimationUtils.loadAnimation(this,R.anim.myanimation);
        imageView.startAnimation(animation);

        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(4000);

                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e){ e.printStackTrace();}

            }
        });
        myThread.start();


//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        },1000);

    }
}
