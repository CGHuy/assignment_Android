package com.app.lab_03;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai2_Activity extends AppCompatActivity {
    GridView gvSanPham;
    Bai2_Adapter adapter;
    List<Bai2_Item> dsSanPham;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2_activity);

        gvSanPham = findViewById(R.id.gvSanPham);

        dsSanPham = new ArrayList<>();
        adapter = new Bai2_Adapter(this, R.layout.bai2_item, dsSanPham);
        gvSanPham.setAdapter(adapter);

        dsSanPham.add(new Bai2_Item("Điều hòa", 30, R.drawable.dieuhoa));
        dsSanPham.add(new Bai2_Item("Máy Giặt", 40, R.drawable.maygiat));
        dsSanPham.add(new Bai2_Item("Tủ Lạnh", 50, R.drawable.tulanh));
        dsSanPham.add(new Bai2_Item("Máy Sinh Tố", 15, R.drawable.sinhto));
        dsSanPham.add(new Bai2_Item("Máy Rửa Bát", 60, R.drawable.ruabat));
        dsSanPham.add(new Bai2_Item("Tivi", 30, R.drawable.tivi));


        adapter.notifyDataSetChanged();

    }
}