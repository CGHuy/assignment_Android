package com.example.lab_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7 extends AppCompatActivity {

    EditText edta, edtb;
    Button btnGiai, btnXoa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai7);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btnGiai = findViewById(R.id.btnGiai);
        btnXoa = findViewById(R.id.btnXoa);

        // nút giải
        btnGiai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double a = Double.parseDouble(edta.getText().toString());
                    double b = Double.parseDouble(edtb.getText().toString());

                    String kq;
                    if (a == 0 && b == 0) {
                        kq = "Phương trình vô số nghiệm";
                    } else if (a == 0 && b != 0) {
                        kq = "Phương trình vô nghiệm";
                    } else {
                        double x = -b / a;
                        kq = "Phương trình có nghiệm x = " + x;
                    }

                    Toast.makeText(Bai7.this, kq, Toast.LENGTH_LONG).show();

                } catch (NumberFormatException e) {
                    Toast.makeText(Bai7.this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // nút xóa
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edta.setText("");
                edtb.setText("");
                Toast.makeText(Bai7.this, "Đã xóa dữ liệu!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
