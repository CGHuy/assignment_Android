package com.example.lab_01;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7_1_result extends AppCompatActivity {

    Button btnTraVe;
    String kq;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai7_1_result);

        btnTraVe = findViewById(R.id.btnTraVe);

        // nhận dữ liệu
        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);

        // giải ptb1
        if (a == 0 && b == 0) {
            kq = "Phương trình có vô số nghiệm";
        } else if (a == 0 && b != 0) {
            kq = "Phương trình vô nghiệm";
        } else {
            kq = "Phương trình có nghiệm x = " + String.format("%.2f", (-b / a));
        }

        // trả kết quả về main
        btnTraVe.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("ketqua", kq);
            setResult(RESULT_OK, intent); // báo trạng thái chạy và gửi ngược lại dữ liệu cho act đã mở nó
            finish();
        });
    }
}
