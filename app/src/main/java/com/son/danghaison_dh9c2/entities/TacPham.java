package com.son.danghaison_dh9c2.entities;

import java.io.Serializable;

public class TacPham implements Serializable {
    private int maTP;
    private String tenTP, nxb,soxuatban,soluong, dongia;

    public String getSoxuatban() {
        return soxuatban;
    }

    public void setSoxuatban(String soxuatban) {
        this.soxuatban = soxuatban;
    }

    public TacPham(int maTP, String tenTP, String nxb, String soxuatban , String soluong, String dongia) {
        this.maTP = maTP;
        this.tenTP = tenTP;
        this.nxb = nxb;
        this.soxuatban = soxuatban;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    @Override
    public String toString() {
        return "TacPham{" +
                "maTP=" + maTP +
                ", tenTP='" + tenTP + '\'' +
                ", nxb='" + nxb + '\'' +
                ", soluong='" + soluong + '\'' +
                ", dongia='" + dongia + '\'' +
                '}';
    }

    public int getMaTP() {
        return maTP;
    }

    public void setMaTP(int maTP) {
        this.maTP = maTP;
    }

    public String getTenTP() {
        return tenTP;
    }

    public void setTenTP(String tenTP) {
        this.tenTP = tenTP;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }
}
