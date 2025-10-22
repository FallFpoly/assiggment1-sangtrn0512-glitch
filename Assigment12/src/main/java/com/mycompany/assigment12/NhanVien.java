/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assigment12;

import java.util.Scanner;

/**
 *
 * @author sang
 */
public class NhanVien {
    public String manv;
    public String hoten;
    public double luong;

    public NhanVien(String manv, String hoten, double luong) {
        this.manv = manv;
        this.hoten = hoten;
        this.luong = luong;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ma nv ");
        this.manv = sc.nextLine();
        System.out.print("nhap ten nv ");
        this.hoten = sc.nextLine();
        System.out.println("nhap luong ");
        this.luong = sc.nextDouble();
    }

    public void xuat() {
        System.out.println("manv :" + this.getManv());
        System.out.println("tennv :" + this.getHoten());
        System.out.println("luong :" + this.getLuong());
        System.out.println("thu nhap " + getThuNhap());
        System.out.println("thue " + getThueTN());
    }
    public double getThuNhap() {
        return this.luong;
    }

    public double getThueTN() {
        if (getThuNhap() < 9000000) {
            return 0;
        } else if (getThuNhap() >= 9000000 && getThuNhap() <= 15000000) {
            return this.getThuNhap() * 0.1;
        } else {
            return this.getThuNhap() * 0.12;
        }
    }

    public void xuatThongTin() {
        System.out.println("Mã NV: " + manv);
        System.out.println("Họ tên: " + hoten);
        System.out.println("Lương: " + luong);
        System.out.println("Thu nhập: " + getThuNhap());
        System.out.println("Thuế TN: " + getThueTN());
    }
}
