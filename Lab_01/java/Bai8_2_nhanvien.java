package com.example.lab_01;

import java.io.Serializable;

public class Bai8_2_nhanvien implements Serializable {
    private String hoTen;
    private String gioiTinh;
    private String queQuan;
    private int hinhAnh; // id ảnh trong drawable

    public Bai8_2_nhanvien(String hoTen, String gioiTinh, String queQuan, int hinhAnh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.hinhAnh = hinhAnh;
    }

    public String getHoTen() { return hoTen; }
    public String getGioiTinh() { return gioiTinh; }
    public String getQueQuan() { return queQuan; }
    public int getHinhAnh() { return hinhAnh; }
}
