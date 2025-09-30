package com.example.lab_02;

import static java.util.stream.Collectors.mapping;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Bai4 extends AppCompatActivity {

    ListView lvCongViec;
    TextView tvNgay, tvGio;
    EditText edtCongViec, edtNoiDung;
    Button btnNgay, btnGio,btnThem;
    List<String> dsCongViec;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4);
        mapping();

        btnNgay.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Bai4.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvNgay.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        btnGio.setOnClickListener(new View.OnClickListener() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Bai4.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvGio.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, true);
                timePickerDialog.show();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String congViec = edtCongViec.getText().toString().trim();
                String noiDung = edtNoiDung.getText().toString().trim();
                String ngay = tvNgay.getText().toString().trim();
                String gio = tvGio.getText().toString().trim();

                if (congViec.isEmpty()) {
                    Toast.makeText(Bai4.this, "Vui lòng nhập công việc", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ngay.equals("Chưa chọn ngày")) {
                    Toast.makeText(Bai4.this, "Vui lòng chọn ngày", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (gio.equals("Chưa chọn giờ")) {
                    Toast.makeText(Bai4.this, "Vui lòng chọn giờ", Toast.LENGTH_SHORT).show();
                    return;
                }

                dsCongViec.add(congViec + " - " + noiDung + " - " + ngay + " - " + gio);
                adapter.notifyDataSetChanged();
                Toast.makeText(Bai4.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                edtCongViec.setText("");
                edtNoiDung.setText("");
                tvNgay.setText("Chưa chọn ngày");
                tvGio.setText("Chưa chọn giờ");
            }
        });
    }

    private void mapping() {
        edtCongViec = findViewById(R.id.edtCongViec);
        edtNoiDung = findViewById(R.id.edtNoiDung);
        lvCongViec = findViewById(R.id.lvCongViec);
        tvNgay = findViewById(R.id.tvNgay);
        tvGio = findViewById(R.id.tvGio);
        btnNgay = findViewById(R.id.btnNgay);
        btnGio = findViewById(R.id.btnGio);
        btnThem = findViewById(R.id.btnThem);

        dsCongViec = new ArrayList<>();
        adapter = new ArrayAdapter(Bai4.this, android.R.layout.simple_list_item_1, dsCongViec);
        lvCongViec.setAdapter(adapter);
    }
}

