package com.example.lab_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_2_main extends AppCompatActivity {

    EditText edtTen, edtQue;
    RadioGroup rgGioiTinh;
    Button btnThem, btnIn;
    ImageView imgNhanVien;
    static ArrayList<Bai8_2_nhanvien> nhanVienList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8_1_main);

        edtTen = findViewById(R.id.edtTen);
        edtQue = findViewById(R.id.edtQue);
        rgGioiTinh = findViewById(R.id.rgGioiTinh);
        btnThem = findViewById(R.id.btnThem);
        btnIn = findViewById(R.id.btnIn);

        btnThem.setOnClickListener(v -> {
            String ten = edtTen.getText().toString();
            String que = edtQue.getText().toString();
            String gioiTinh = (rgGioiTinh.getCheckedRadioButtonId() == R.id.rbNam) ? "Nam" : "Nữ";

            if (ten.isEmpty() || que.isEmpty() || gioiTinh.isEmpty()) {
                Toast.makeText(Bai8_2_main.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
            } else {
                // Lấy avatar ngẫu nhiên từ drawable
                int[] avatars = {R.mipmap.ic_launcher, R.mipmap.ic_launcher_round};
                int randomAvatar = avatars[(int)(Math.random() * avatars.length)];

                Bai8_2_nhanvien nv = new Bai8_2_nhanvien(ten, gioiTinh, que, randomAvatar);
                nhanVienList.add(nv);

                edtTen.setText("");
                edtQue.setText("");
                rgGioiTinh.clearCheck();
                Toast.makeText(Bai8_2_main.this,"Thêm mới thành công " + ten,Toast.LENGTH_SHORT).show();
            }
        });

        btnIn.setOnClickListener(v -> {
            Intent intent = new Intent(Bai8_2_main.this, Bai8_2_list.class);
            intent.putExtra("list", nhanVienList);
            startActivity(intent);
        });
    }
}
