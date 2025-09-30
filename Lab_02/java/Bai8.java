package com.example.lab_02;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Bai8 extends AppCompatActivity {
    Spinner planets_spiner;
    ArrayAdapter adapter;
    List<String> planets;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai8);
        mapping();

        planets.add("Mercury");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Jupiter");
        planets.add("Saturn");
        planets.add("Uranus");
        planets.add("Neptune");
        adapter.notifyDataSetChanged();
    }

    private void mapping() {
        planets_spiner = findViewById(R.id.planets_spiner);

        planets = new ArrayList<>();
        adapter = new ArrayAdapter<>(Bai8.this, android.R.layout.simple_spinner_item, planets);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // dùng để chỉ định giao diện của từng item khi Spinner xổ xuống
        planets_spiner.setAdapter(adapter);
    }
}