package com.example.lab_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_2_list extends AppCompatActivity {

    Button btnThoat;
    ListView lvNhanVien;
    Bai8_2_adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8_2_list);

        lvNhanVien = findViewById(R.id.lvNhanVien);
        btnThoat = findViewById(R.id.btnThoat);

        // nhận dữ liệu
        ArrayList<Bai8_2_nhanvien> dsNhanVien = (ArrayList<Bai8_2_nhanvien>) getIntent().getSerializableExtra("list");

        adapter = new Bai8_2_adapter(this, R.layout.bai8_2_item, dsNhanVien);
        lvNhanVien.setAdapter(adapter);

        btnThoat.setOnClickListener(v -> finish());
    }
}
