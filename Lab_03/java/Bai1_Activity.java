package com.app.lab_03;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai1_Activity extends AppCompatActivity {

    // Khai báo thuộc tính
    ListView lvSanPham;
    List<Bai1_Item> dsSanPham;
    Bai1_Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_activity);

        lvSanPham = findViewById(R.id.lvSanPham);

        // Khởi tạo các thuộc tính
        dsSanPham = new ArrayList<>();
        adapter = new Bai1_Adapter(this, R.layout.bai1_item, dsSanPham);
        lvSanPham.setAdapter(adapter);

        dsSanPham.add(new Bai1_Item("Máy Xay Sinh Tố", "Máy xay sinh tố nhập khẩu từ Đức", 40, R.drawable.sinhto));
        dsSanPham.add(new Bai1_Item("Máy Giặt","Máy giặt nhập khẩu từ Hàn Quốc" ,40, R.drawable.maygiat));
        dsSanPham.add(new Bai1_Item("Tủ Lạnh", "Tủ lạnh nhập khẩu từ Hàn Úc",50, R.drawable.tulanh));
        dsSanPham.add(new Bai1_Item("Máy Sinh Tố","Máy sinh tố nhập khẩu từ Nhật Bản", 15, R.drawable.sinhto));
        dsSanPham.add(new Bai1_Item("Máy Rửa Bát","Máy rửa bát nội địa", 60, R.drawable.ruabat));
        dsSanPham.add(new Bai1_Item("Tivi","Tivi nhập khẩu từ Mỹ", 30, R.drawable.tivi));
        adapter.notifyDataSetChanged();

    }
}