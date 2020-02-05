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
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        login = (TextView) findViewById(R.id.text);
        etemail = (EditText) findViewById(R.id.etemail);
        etpw = (EditText) findViewById(R.id.etpw);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter+=counter+1;
                DisplayNotification();
            }
        });


        // Enables Always-on
        setAmbientEnabled();
    }

    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_border_all_black_24dp)
                .setContentTitle("First Notification")
                .setContentText("Succesfully Booked")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(counter, notification);
    }
}
