package com.ayushgjl.vehicleservicing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private EditText fullname, contact, location, vehiclenum, problem;
    private Spinner spin, spin1, spin2;
    private TextView vehicletype, cartype, servicingtype, date, time;
    private Button btndate, btntime, btnbook;
    int y1, m1, d1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        fullname = findViewById(R.id.fullname);
        contact = findViewById(R.id.contact);
        location = findViewById(R.id.location);
        vehiclenum = findViewById(R.id.vehiclenum);
        problem = findViewById(R.id.problem);
        spin = findViewById(R.id.spin);
        spin1 = findViewById(R.id.spin1);
        spin2 = findViewById(R.id.spin2);
        vehicletype = findViewById(R.id.vehicletype);
        cartype = findViewById(R.id.cartype);
        servicingtype = findViewById(R.id.servicingtype);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        btndate = findViewById(R.id.btndate);
        btntime = findViewById(R.id.btntime);
        btnbook = findViewById(R.id.btnbook);

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

        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(fullname.getText())){
                    fullname.setError("Please enter your fullname");
                    return;
                }
                else if(TextUtils.isEmpty(contact.getText())){
                    contact.setError("Please enter your contact number");
                    return;
                }
                else if(TextUtils.isEmpty(location.getText())){
                    location.setError("Please enter your location");
                    return;
                }
                else if(TextUtils.isEmpty(vehiclenum.getText())){
                    vehiclenum.setError("Please enter your vehiclenum");
                    return;
                }
                else if(TextUtils.isEmpty(problem.getText())){
                    problem.setError("Please enter problem on vehicle");
                    return;
                }
                else if(TextUtils.isEmpty(btndate.getText())){
                    btndate.setError("Please enter date");
                    return;
                }
                else if(TextUtils.isEmpty(btntime.getText())){
                    btntime.setError("Please enter time");
                    return;
                }

            }
        });

        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadDatePicker();
            }
        });
        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadTime();
            }
        });
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

        btndate.setText(date);

    }
}
