package com.app.lab_03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Bai1_Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Bai1_Item> dsSanPham;

    public Bai1_Adapter(Context context, int layout, List<Bai1_Item> dsSanPham) {
        this.context = context;
        this.layout = layout;
        this.dsSanPham = dsSanPham;
    }

    @Override
    public int getCount() {
        if (dsSanPham != null) {
            return dsSanPham.size(); // Trả về số lượng item thực tế
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (dsSanPham != null && position >= 0 && position < dsSanPham.size()) {
            return dsSanPham.get(position); // Trả về item tại vị trí position
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position; // Trả về vị trí làm ID
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layout, null);

        // Ánh xạ thành phần giao diện
        ImageView imgAnh = view.findViewById(R.id.imgAnh);
        TextView tvTenSp = view.findViewById(R.id.tvTenSp);
        TextView tvMoTa = view.findViewById(R.id.tvMoTa);
        TextView tvGia = view.findViewById(R.id.tvGia);

        Bai1_Item sp = dsSanPham.get(position); // Lấy item tại vị trí position
        imgAnh.setImageResource(sp.getAnh());
        tvTenSp.setText(sp.getTenSp());
        tvMoTa.setText(sp.getMoTa());
        tvGia.setText("$" + sp.getGia());

        return view;
    }
}