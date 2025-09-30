package com.example.lab_01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_1_list extends AppCompatActivity {

    Button btnThoat;
    ListView lvNhanVien;
    ArrayAdapter aadanhsach;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8_1_list);

        lvNhanVien = findViewById(R.id.lvNhanVien);
        btnThoat = findViewById(R.id.btnThoat);

        // nhận dữ liệu
        ArrayList<String> dsNhanVien = getIntent().getStringArrayListExtra("list");

        aadanhsach = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsNhanVien);
        lvNhanVien.setAdapter(aadanhsach);

        btnThoat.setOnClickListener(v -> {
            finish();
        });
    }
}
