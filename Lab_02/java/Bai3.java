package com.example.lab_02;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Bai3 extends AppCompatActivity {

    EditText edtNgay, edtGio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);

        edtNgay = findViewById(R.id.edtNgay);
        edtGio = findViewById(R.id.edtGio);

        edtNgay.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();
            // class calendar dùng để làm việc với ngày giờ và getInstance() dùng để lấy thời gian hiện tại
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1; // vì tháng bắt đầu từ 0
            int day = calendar.get(Calendar.DAY_OF_MONTH);
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(Bai3.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            edtNgay.setText(dayOfMonth + "/" + month + "/" + year);
                        }
                    }, year, month, day);
                    datePickerDialog.show();
                }
        });

        edtGio.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Bai3.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                edtGio.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
        });
    }
}
