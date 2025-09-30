package com.example.lab_01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai7_2_main  extends AppCompatActivity {

    EditText edta, edtb, edtc;
    Button btnGiai, btnXoa;
    final int REQUEST_CODE = 456; // mã định danh (tự đặt) để phân biệt request khi gọi startActivityForResult()

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai7_2_main);

        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        edtc = findViewById(R.id.edtc);
        btnGiai = findViewById(R.id.btnGiai);
        btnXoa = findViewById(R.id.btnXoa);

        // nút giải
        btnGiai.setOnClickListener(v -> {
            try {
                // lấy dữ liệu kiểu string và ép sang double
                double a = Double.parseDouble(edta.getText().toString());
                double b = Double.parseDouble(edtb.getText().toString());
                double c = Double.parseDouble(edtc.getText().toString());

                // tạo Intent sang màn hình 2
                Intent intent = new Intent(Bai7_2_main.this, Bai7_2_result.class);
                intent.putExtra("a", a); // "a" là key, a là dữ liệu
                intent.putExtra("b", b);
                intent.putExtra("c", c);
                startActivityForResult(intent, REQUEST_CODE); // gọi intent để sang màn hình result

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Lỗi: Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
            }
        });

        // nút xóa
        btnXoa.setOnClickListener(v -> {
            edta.setText("");
            edtb.setText("");
            edtc.setText("");
            Toast.makeText(this, "Đã xóa dữ liệu", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if (data != null) {
                String kq = data.getStringExtra("ketqua");
                Toast.makeText(this, kq, Toast.LENGTH_LONG).show();
            }
        }
    }
}
