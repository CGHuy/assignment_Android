package com.example.lab_01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai3 extends AppCompatActivity {

    CheckBox cbNam, cbNu, cbKhac;
    Button btnkiemtra;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai3);

        cbNam = findViewById(R.id.checkboxnam);
        cbNu = findViewById(R.id.checkboxnu);
        cbKhac = findViewById(R.id.checkboxkhac);
        btnkiemtra = findViewById(R.id.btnkiemtra);

        btnkiemtra.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();

            if (cbNam.isChecked()) {
                result.append("Bạn đã check Nam");
            }
            if (cbNu.isChecked()) {
                if (result.length() > 0) result.append(", ");
                result.append("Bạn đã check Nữ");
            }
            if (cbKhac.isChecked()) {
                if (result.length() > 0) result.append(", ");
                result.append("Bạn đã check Khác");
            }

            if (result.length() == 0) {
                Toast.makeText(Bai3.this, "Bạn chưa check gì", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Bai3.this, result.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
