/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

/**
 *
 * @author sang
 */
public class TruongPhong extends NhanVien {
    private double trachNhiem;

    public TruongPhong(String manv, String hoten, double luong, double trachNhiem) {
        super(manv, hoten, luong);
        this.trachNhiem = trachNhiem;
    }

    public double getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem(double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }

    @Override
    public double getThuNhap() {

        return super.getThuNhap() + this.trachNhiem;
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Trách nhiệm: " + trachNhiem);
    }
}
