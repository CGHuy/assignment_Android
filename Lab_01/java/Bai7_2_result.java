package com.example.lab_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7_2_result extends AppCompatActivity {

    Button btnTraVe;
    String kq;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai7_2_result);

        btnTraVe = findViewById(R.id.btnTraVe);

        // nhận dữ liệu
        double a = getIntent().getDoubleExtra("a", 0);
        double b = getIntent().getDoubleExtra("b", 0);
        double c = getIntent().getDoubleExtra("c",0);

        // giải ptb2
        if (a == 0) {
            // lùi về ptb1: bx + c = 0
            if (b == 0 && c == 0) {
                kq = "Phương trình có vô số nghiệm";
            } else if (b == 0 && c != 0) {
                kq = "Phương trình vô nghiệm";
            } else {
                kq = "Phương trình có nghiệm x = " + String.format("%.2f", (-c / b));
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                kq = "Phương trình vô nghiệm";
            } else if (delta == 0) {
                double x = -b / (2 * a);
                kq = "Phương trình có nghiệm kép x = " + String.format("%.2f", x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                kq = "Phương trình có 2 nghiệm phân biệt:\n"
                        + "x1 = " + String.format("%.2f", x1) + ", "
                        + "x2 = " + String.format("%.2f", x2);
            }
        }

        // trả kết quả về main
        btnTraVe.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("ketqua", kq);
            setResult(RESULT_OK, intent); // báo trạng thái chạy và gửi ngược lại dữ liệu cho act đã mở nó
            finish(); // kết thúc act hiện tại và quay về
        });

    }
}
