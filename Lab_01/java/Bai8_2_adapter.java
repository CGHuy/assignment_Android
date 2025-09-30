package com.example.lab_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Bai8_2_adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Bai8_2_nhanvien> dsNhanVien;

    public Bai8_2_adapter(Context context, int layout, ArrayList<Bai8_2_nhanvien> dsNhanVien) {
        this.context = context;
        this.layout = layout;
        this.dsNhanVien = dsNhanVien;
    }

    @Override
    public int getCount() {
        return dsNhanVien.size();
    }

    @Override
    public Object getItem(int position) {
        return dsNhanVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, parent, false);
        }

        // Ánh xạ các view
        ImageView imgAvatar = convertView.findViewById(R.id.imgAvatar);
        TextView tvHoTen = convertView.findViewById(R.id.tvHoTen);
        TextView tvGioiTinh = convertView.findViewById(R.id.tvGioiTinh);
        TextView tvQueQuan = convertView.findViewById(R.id.tvQueQuan);

        // Gán dữ liệu
        Bai8_2_nhanvien nv = dsNhanVien.get(position);
        imgAvatar.setImageResource(nv.getHinhAnh());
        tvHoTen.setText(nv.getHoTen());
        tvGioiTinh.setText(nv.getGioiTinh());
        tvQueQuan.setText(nv.getQueQuan());

        return convertView;
    }
}
