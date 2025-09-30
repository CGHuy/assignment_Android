package com.example.lab_01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Bai4 extends AppCompatActivity {

    EditText edtUserName, edtPassword;
    Button btnLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai4);

        edtUserName = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUserName.getText().toString();
                String pass = edtPassword.getText().toString();
                if (user.equals("admin") && pass.equals("admin")) {
                    Toast.makeText(Bai4.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Bai4.this,"Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
