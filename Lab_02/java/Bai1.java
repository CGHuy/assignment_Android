package com.example.lab_02;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Bai1 extends AppCompatActivity {

    Button btnThem, btnSua;
    EditText edtTen;
    ListView lvTen;
    ArrayList<String> dsTen;
    ArrayAdapter aaTen;
    int vitriDangChon = -1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1);

        edtTen = findViewById(R.id.edtTen);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        lvTen = findViewById(R.id.lvTen);

        initData();
        aaTen = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dsTen);
        lvTen.setAdapter(aaTen);

        btnThem.setOnClickListener(v -> {
            String ten = edtTen.getText().toString().trim();
            if (ten.isEmpty()) {
                Toast.makeText(Bai1.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_SHORT).show();
            } else {
                dsTen.add(ten);
                aaTen.notifyDataSetChanged(); // cập nhật lv
                edtTen.setText("");
            }
        });

        lvTen.setOnItemClickListener((parent, view, position, id) -> {
            vitriDangChon = position;
            String ten = dsTen.get(position);
            edtTen.setText(ten);
        });

        // nút Sửa
        btnSua.setOnClickListener(v -> {
            if (vitriDangChon == -1) {
                Toast.makeText(Bai1.this, "Vui lòng chọn mục cần sửa", Toast.LENGTH_SHORT).show();
                return;
            }
            String tenMoi = edtTen.getText().toString().trim();
            if (tenMoi.isEmpty()) {
                Toast.makeText(Bai1.this, "Tên không được để trống", Toast.LENGTH_SHORT).show();
                return;
            }
            dsTen.set(vitriDangChon, tenMoi); // cập nhật lại tên mới
            aaTen.notifyDataSetChanged(); // cập nhật lv
            edtTen.setText("");
            vitriDangChon = -1; // reset vị trí
        });

        // sự kiện long click -> xóa
        lvTen.setOnItemLongClickListener((parent, view, position, id) -> {
            new AlertDialog.Builder(Bai1.this)
                    .setTitle("Cảnh báo")
                    .setMessage("Bạn thật sự muốn xóa?")
                    .setPositiveButton("Có", (dialog, which) -> {
                        dsTen.remove(position);
                        aaTen.notifyDataSetChanged();
                        Toast.makeText(Bai1.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Không", null)
                    .show();
            return true; // đã xử lý sự kiện
        });

    }

    private void initData() {
        dsTen = new ArrayList<>();
        dsTen.add("JAVA");
        dsTen.add("PHP");
        dsTen.add("C");
        dsTen.add("C++");
        dsTen.add("C#");
        dsTen.add("Python");
        dsTen.add("JS");
        dsTen.add("TypeScript");
    }
}
