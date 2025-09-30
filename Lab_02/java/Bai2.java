package com.example.lab_02;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai2 extends AppCompatActivity {

    EditText edtTen;
    TextView tvThongBao;
    Button btnNhap;
    ListView lvTen;
    List<String> dsNhap;
    ArrayAdapter adapter;
    int pos = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai2);

        edtTen = findViewById(R.id.edtTen);
        tvThongBao = findViewById(R.id.tvThongBao);
        btnNhap = findViewById(R.id.btnNhap);
        lvTen = findViewById(R.id.lvTen);

        dsNhap = new ArrayList<>();
        adapter = new ArrayAdapter<>(Bai2.this,android.R.layout.simple_list_item_1,dsNhap);
        lvTen.setAdapter(adapter);

        btnNhap.setOnClickListener(v -> {
            String ten = edtTen.getText().toString().trim();
            if (ten.isEmpty()) {
                Toast.makeText(Bai2.this, "Vui lòng nhập dữ liệu", Toast.LENGTH_SHORT).show();
                return;
            }
            dsNhap.add(ten);
            adapter.notifyDataSetChanged();
            edtTen.setText("");
            Toast.makeText(Bai2.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
        });

        lvTen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pos = position + 1;
                tvThongBao.setText("Vị trí: " + pos + " - Giá trị: " + dsNhap.get(position));
            }
        });
    }
}
