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
public class Menu {


    public void menu() {
    Scanner sc = new Scanner(System.in);
    int choice;
        do {
            System.out.println("====================================");
            System.out.println(" QUẢN LÝ NHÂN VIÊN - GIAI ĐOẠN 1");
            System.out.println("====================================");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Xuất danh sách nhân viên");
            System.out.println("3. Tìm và hiển thị nhân viên theo mã");
            System.out.println("4. Xóa nhân viên theo mã");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Tìm các nhân viên theo khoảng lương");
            System.out.println("7. Sắp xếp nhân viên theo họ và tên");
            System.out.println("8. Sắp xếp nhân viên theo thu nhập");
            System.out.println("9. Xuất 5 nhân viên có thu nhập cao nhất");
            System.out.println("0. Thoát");
            System.out.print(">> Chọn chức năng: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(">> Chức năng: Nhập danh sách nhân viên");
                    break;
                case 2:
                    System.out.println(">> Chức năng: Xuất danh sách nhân viên");
                    break;
                case 3:
                    System.out.println(">> Chức năng: Tìm nhân viên theo mã");
                    break;
                case 4:
                    System.out.println(">> Chức năng: Xóa nhân viên theo mã");
                    break;
                case 5:
                    System.out.println(">> Chức năng: Cập nhật nhân viên theo mã");
                    break;
                case 6:
                    System.out.println(">> Chức năng: Tìm nhân viên theo khoảng lương");
                    break;
                case 7:
                    System.out.println(">> Chức năng: Sắp xếp nhân viên theo họ tên");
                    break;
                case 8:
                    System.out.println(">> Chức năng: Sắp xếp nhân viên theo thu nhập");
                    break;
                case 9:
                    System.out.println(">> Chức năng: Xuất 5 nhân viên thu nhập cao nhất");
                    break;
                default:
                    System.out.println("lua chon ko hop le");
                    break;
            }
    
        } while (choice != 0);

    }
}
