package com.example.finalexam3;

import java.io.Serializable;

public class Nhanvien{
    private String maNV;
    private String tenNV;
    private String ngaySinh;
    private String gioiTinh;
    private String chucVu;
    private int soDT;
    private String diaChi;
    private String email;

    public Nhanvien(String maNV, String tenNV, String ngaySinh, String gioiTinh,String chucVu, int soDT, String diaChi, String email) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.email = email;
    }

    public Nhanvien() {

    }

    public String getMaNV() {
        return maNV;
    }

    public Nhanvien(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNgaySinh() { return ngaySinh; }

    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getGioiTinh() { return gioiTinh; }

    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }

    @Override
    public String toString() {
        return "ID: " + maNV + " Name: " + tenNV + " CV: " + chucVu;
    }

}
