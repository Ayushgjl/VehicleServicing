package com.example.vehicleservicingwear;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.vehicleservicingwear.createchannel.CreateChannel;

public class MainActivity extends WearableActivity {
    private int counter = 1;
    private TextView login;
    private EditText etemail, etpw;
    private Button btnlogin;
    private NotificationManager notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
