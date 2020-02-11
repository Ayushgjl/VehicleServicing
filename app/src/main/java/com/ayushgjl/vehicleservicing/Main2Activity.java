package com.ayushgjl.vehicleservicing;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
//    TextView ProximitySensor,data;
//    SensorManager mysensorManager;
//    Sensor myproximitySensor;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)

                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//        setTitle("Light Sensor");
//        LightInstance();


//        ProximitySensor = (TextView) findViewById(R.id.proximitySensor);
//        data = (TextView) findViewById(R.id.data);
//        mysensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        myproximitySensor = mysensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//        if (myproximitySensor == null) {
//            ProximitySensor.setText("No Proximity Sensor!");
//
//        } else {
//            mysensorManager.registerListener(proximitySensorEventListener,
//                    myproximitySensor,
//                    SensorManager.SENSOR_DELAY_NORMAL);
//        }
    }

//    private void LightInstance() {
//
//        mysensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        Sensor sensor = mysensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
//        SensorEventListener lightlistener = new SensorEventListener() {
//            @Override
//            public void onSensorChanged(SensorEvent event) {
//                if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
//                    Toast.makeText(Main2Activity.this, "onSenor Change :"+ event.values[0], Toast.LENGTH_SHORT).show();
//                }
//
//            }
//
//            @Override
//            public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//            }
//        };
//        mysensorManager.registerListener(lightlistener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
//    SensorEventListener proximitySensorEventListener
//            = new SensorEventListener() {
//        @Override
//        public void onAccuracyChanged(Sensor sensor, int accuracy) {
//            // TODO Auto-generated method stub
//        }
//        @Override
//        public void onSensorChanged(SensorEvent event) {
//            WindowManager.LayoutParams params = Main2Activity.this.getWindow().getAttributes();
//            if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
//
//                if(event.values[0]==0){
//                    params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
//                    params.screenBrightness = 0;
//                    getWindow().setAttributes(params);
//                }
//                else{
//                    params.flags |= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
//                    params.screenBrightness = -1f;
//                    getWindow().setAttributes(params);
//                }
//            }
//        }
//    };
}



