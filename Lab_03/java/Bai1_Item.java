package com.app.lab_03;

import java.io.Serializable;

public class Bai1_Item implements Serializable {
    private String ten;
    private String moTa;
    private int gia;
    private int anh;

    public Bai1_Item() {

    }

    public Bai1_Item(String ten, String moTa, int gia, int anh) {
        this.ten = ten;
        this.moTa = moTa;
        this.gia = gia;
        this.anh = anh;
    }

    public String getTenSp() {
        return ten;
    }

    public void setTenSp(String ten) {
        this.ten = ten;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}