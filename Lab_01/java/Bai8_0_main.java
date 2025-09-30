package com.example.lab_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai8_0_main extends AppCompatActivity {

    EditText edtTen, edtQue;
    RadioGroup rgGioiTinh;
    Button btnThem, btnIn;
    static ArrayList<String> nhanVienList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8_0_main);

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
                Toast.makeText(Bai8_0_main.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
            } else {
                String info = ten + " - " + gioiTinh + " - " + que;
                nhanVienList.add(info);
                edtTen.setText("");
                edtQue.setText("");
                rgGioiTinh.clearCheck();
                Toast.makeText(Bai8_0_main.this,"Thêm mới thành công " + ten,Toast.LENGTH_SHORT).show();
            }
        });

        btnIn.setOnClickListener(v -> {
            Intent intent = new Intent(Bai8_0_main.this, Bai8_0_list.class);
            intent.putStringArrayListExtra("list", nhanVienList);
            startActivity(intent);
        });
    }
}
