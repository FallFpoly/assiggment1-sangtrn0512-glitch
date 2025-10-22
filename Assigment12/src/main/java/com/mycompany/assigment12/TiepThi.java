/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

/**
 *
 * @author sang
 */
public class TiepThi extends NhanVien {
    private double doanhSo;
    private double hueHong;

    public TiepThi(String manv, String hoten, double luong, double doanhSo, double hueHong) {
        super(manv, hoten, luong);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public double getThuNhap() {
        return super.getThuNhap() + (this.doanhSo * this.hueHong);
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Doanh số: " + doanhSo);
        System.out.println("Huê hồng: " + hueHong);
    }
}
