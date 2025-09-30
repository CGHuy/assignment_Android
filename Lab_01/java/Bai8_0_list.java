package com.example.lab_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_0_list extends AppCompatActivity {

    TextView tvList;
    Button btnThoat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8_0_list);

        tvList = findViewById(R.id.tvList);
        btnThoat = findViewById(R.id.btnThoat);

        // nhận dữ liệu
        ArrayList<String> danhSach = getIntent().getStringArrayListExtra("list");

        if (danhSach == null || danhSach.isEmpty()) {
            tvList.setText("Danh sách trống");
        } else {
            StringBuilder sb = new StringBuilder(); // tạo 1 StringBuilder để ghép chuỗi
            for (String i : danhSach) {
                sb.append(i).append("\n");
            }
            tvList.setText(sb.toString()); // gán chuỗi vào tvList
        }

        btnThoat.setOnClickListener(v -> {
            finish();
        });

    }
}
