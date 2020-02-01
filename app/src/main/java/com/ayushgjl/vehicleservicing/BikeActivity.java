package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.ayushgjl.vehicleservicing.createchannel.CreateChannel;

import java.util.Calendar;

public class BikeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private NotificationManagerCompat notificationManagerCompat;
    private int counter = 1;
    private EditText bfullname, bcontact, blocation, bvehiclenum, bproblem;
    private Spinner bspin, bspin1;
    private TextView bikemodel, biketype;
    private Button btnbdate, btnbtime, btnbook;
    int y1, m1, d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        bfullname = findViewById(R.id.bfullname);
        bcontact = findViewById(R.id.bcontact);
        blocation = findViewById(R.id.blocation);
        bvehiclenum = findViewById(R.id.bvehiclenum);
        bproblem = findViewById(R.id.bproblem);
        bspin = findViewById(R.id.bspin);
        bspin1 = findViewById(R.id.bspin1);
        bikemodel = findViewById(R.id.bikemodel);
        biketype = findViewById(R.id.biketype);
        btnbdate = findViewById(R.id.btnbdate);
        btnbtime = findViewById(R.id.btnbtime);
        btnbook = findViewById(R.id.btnbook);

        String model[] = {"Sports", "Scooter", "Cruiser", "Off Road"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,model);

        bspin.setAdapter(arrayAdapter);

        String Type[]={"Honda","Suzuki","Yamaha","KTM","Bajaj"};

        ArrayAdapter arrayAdapter1= new ArrayAdapter(this, android.R.layout.select_dialog_item,Type);

        bspin1.setAdapter(arrayAdapter1);

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
                counter+= counter +1;
                if(TextUtils.isEmpty(bfullname.getText())){
                    bfullname.setError("Please enter your fullname");
                    return;
                }
                else if(TextUtils.isEmpty(bcontact.getText())){
                    bcontact.setError("Please enter your contact number");
                    return;
                }
                else if(TextUtils.isEmpty(blocation.getText())){
                    blocation.setError("Please enter your location");
                    return;
                }
                else if(TextUtils.isEmpty(bvehiclenum.getText())){
                    bvehiclenum.setError("Please enter your vehicle nnumber");
                    return;
                }
                else if(TextUtils.isEmpty(bproblem.getText())){
                    bproblem.setError("Please enter problem of bike");
                    return;
                }
                else if(TextUtils.isEmpty(btnbdate.getText())){
                    btnbdate.setError("Please enter date");
                    return;
                }

                else if(TextUtils.isEmpty(btnbtime.getText())){
                    btnbtime.setError("Please enter time");
                    return;
                }
            }
        });        btnbdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
        btnbtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });

    }

    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_phone_android_black_24dp)
                .setContentTitle("Second Message")
                .setContentText("Second Message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(counter, notification);
    }

    private void loadTime() {
    }

    private void loadDatePicker() {
        final Calendar c = Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = "Select Date:" + (month+1) + "/" + dayOfMonth + "/" + year;
        y1= year;
        m1= month;
        d1= dayOfMonth;

        btnbdate.setText(date);
    }
}

