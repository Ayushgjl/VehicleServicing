package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.ayushgjl.vehicleservicing.API.CarBookingAPI;
import com.ayushgjl.vehicleservicing.Model.CarBooking;
import com.ayushgjl.vehicleservicing.URL.url;
import com.ayushgjl.vehicleservicing.createchannel.CreateChannel;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private NotificationManagerCompat notificationManagerCompat;
    private int counter = 1;
    private EditText cfullname, ccontact, clocation, cvehiclenum, cproblem;
    private Spinner spin, spin1, spin2;
    private TextView vehicletype, cartype, servicingtype, date, time;
    private Button btncdate, btnctime, btncbook;
    int y1, m1, d1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        cfullname = findViewById(R.id.cfullname);
        ccontact = findViewById(R.id.ccontact);
        clocation = findViewById(R.id.clocation);
        cvehiclenum = findViewById(R.id.cvehiclenum);
        cproblem = findViewById(R.id.cproblem);
        spin = findViewById(R.id.spin);
        spin1 = findViewById(R.id.spin1);
        spin2 = findViewById(R.id.spin2);
        vehicletype = findViewById(R.id.vehicletype);
        cartype = findViewById(R.id.cartype);
        servicingtype = findViewById(R.id.cservicingtype);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        btncdate = findViewById(R.id.btncdate);
        btnctime = findViewById(R.id.btnctime);
        btncbook = findViewById(R.id.btncbook);

        String model[] = {"SUVs", "Sedans", "Sports", "Wagons", "Luxury", "Hybrids/EVs"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,model);

        spin.setAdapter(arrayAdapter);

        String Type[]={"Hyundai","Suzuki","Toyota","Audi","Volkswagen","Ford"};

        ArrayAdapter arrayAdapter1= new ArrayAdapter(this, android.R.layout.select_dialog_item,Type);

        spin1.setAdapter(arrayAdapter1);

        String servicing[]={"Full Servicing","Half Servicing"};

        final ArrayAdapter arrayAdapter2= new ArrayAdapter(this, android.R.layout.select_dialog_item,servicing);

        spin2.setAdapter(arrayAdapter2);

        btncbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter+=counter+1;
                if(TextUtils.isEmpty(cfullname.getText())){
                    cfullname.setError("Please enter your fullname");
                    return;
                }
                else if(TextUtils.isEmpty(ccontact.getText())){
                    ccontact.setError("Please enter your contact number");
                    return;
                }
                else if(TextUtils.isEmpty(clocation.getText())){
                    clocation.setError("Please enter your location");
                    return;
                }
                else if(TextUtils.isEmpty(cvehiclenum.getText())){
                    cvehiclenum.setError("Please enter your vehiclenum");
                    return;
                }
                else if(TextUtils.isEmpty(cproblem.getText())){
                    cproblem.setError("Please enter problem on vehicle");
                    return;
                }
                else if(TextUtils.isEmpty(btncdate.getText())){
                    btncdate.setError("Please enter date");
                    return;
                }
                else if(TextUtils.isEmpty(btnctime.getText())){
                    btnctime.setError("Please enter time");
                    return;
                }

                else {
                    registercarbooking();
                }

         DisplayNotification();



            }
        });

        btncdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
        btnctime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
    }

    private void registercarbooking() {
        String fullname=cfullname.getText().toString();
        String contact=ccontact.getText().toString();
        String location=clocation.getText().toString();
        String vehiclenum=cvehiclenum.getText().toString();
        String problem=cproblem.getText().toString();
        String model=spin.getSelectedItem().toString();
        String type=spin1.getSelectedItem().toString();
        String servicing = spin2.getSelectedItem().toString();
        String date=btncdate.getText().toString();
        String time=btnctime.getText().toString();

        CarBooking carBooking=new CarBooking(fullname,contact,location,vehiclenum,problem,model,type,servicing,date,time);

        CarBookingAPI carBookingAPI= url.getInstance().create(CarBookingAPI.class);
        Call<CarBooking> carBookingCall=carBookingAPI.registercarbooking(carBooking);
        carBookingCall.enqueue(new Callback<CarBooking>() {
            @Override
            public void onResponse(Call<CarBooking> call, Response<CarBooking> response) {
                if (! response.isSuccessful()) {
                    Toast.makeText(BookingActivity.this, "Error : API is not responding " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(BookingActivity.this, "Car Booked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CarBooking> call, Throwable t) {
                    Toast.makeText(BookingActivity.this, "Error : Network Problem  and Error : " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            }






    private void DisplayNotification() {
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_border_all_black_24dp)
                .setContentTitle("Notification")
                .setContentText("Succesfully Booked")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(counter, notification);

    }

    private void loadTime() {
        Calendar calendar = Calendar.getInstance();
        int HOUR = calendar.get(Calendar.HOUR);
        int Minute = calendar.get(Calendar.MINUTE);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = "hour:" + hourOfDay + "minute :" + minute;
                btnctime.setText(timeString);
            }
        }, HOUR,Minute,is24HourFormat);
        timePickerDialog.show();




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

        btncdate.setText(date);

    }


}
