package com.app.lab_03;

import java.io.Serializable;

public class Bai2_Item implements Serializable {
    private String tenSp;
    private int gia;
    private int anh;

    public Bai2_Item() { // constructor rỗng
    }

    public Bai2_Item(String tenSp, int gia, int anh) { // constructor đầy đủ
        this.tenSp = tenSp;
        this.gia = gia;
        this.anh = anh;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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