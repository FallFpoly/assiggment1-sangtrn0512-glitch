/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assigment12;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Assigment2 {

    ArrayList<NhanVien> danhSachNV = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Assigment2 ql = new Assigment2();
        ql.menu();
    }

    public void menu() {
        while (true) {
            System.out.println("--- CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN ---");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Xuất danh sách nhân viên");
            System.out.println("3. Tìm nhân viên theo mã");
            System.out.println("4. Xóa nhân viên theo mã");
            System.out.println("5. Cập nhật nhân viên theo mã");
            System.out.println("6. Tìm nhân viên theo khoảng thu nhập");
            System.out.println("7. Sắp xếp nhân viên theo họ tên");
            System.out.println("8. Sắp xếp nhân viên theo thu nhập");
            System.out.println("9. Xuất 5 NV thu nhập cao nhất");
            System.out.println("0. Thoát");
            System.out.print("Mời bạn chọn chức năng: ");

            // Thêm try-catch để bắt lỗi nhập sai (ví dụ nhập chữ)
            try {
                int luaChon = Integer.parseInt(scanner.nextLine());

                switch (luaChon) {
                    case 1:
                        nhapDanhSach();
                        break;
                    case 2:
                        xuatDanhSach();
                        break;
                    case 3:
                        timNhanVien();
                        break;
                    case 4:
                        xoaNhanVien();
                        break;
                    case 5:
                        capNhatNhanVien();
                        break;
                    case 6:
                        timTheoKhoangThuNhap();
                        break;
                    case 7:
                        sapXepTheoHoTen();
                        break;
                    case 8:
                        sapXepTheoThuNhap();
                        break;
                    case 9:
                        xuatTop5ThuNhap();
                        break;
                    case 0:
                        System.out.println("Đã thoát chương trình.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số!");
            }
        }
    }

    private void nhapDanhSach() {
        while (true) {
            System.out.println("Chọn loại nhân viên muốn nhập (1-Hành chính, 2-Trưởng phòng, 3-Tiếp thị):");
            int loaiNV = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập mã NV: ");
            String ma = scanner.nextLine();
            System.out.print("Nhập họ tên: ");
            String ten = scanner.nextLine();
            System.out.print("Nhập lương: ");
            double luong = Double.parseDouble(scanner.nextLine());

            switch (loaiNV) {
                case 1:
                    NhanVien hanhChinh = new NhanVien(ma, ten, luong);
                    danhSachNV.add(hanhChinh);
                    break;
                case 2:
                    System.out.print("Nhập lương trách nhiệm: ");
                    double trachNhiem = Double.parseDouble(scanner.nextLine());
                    TruongPhong truongPhong = new TruongPhong(ma, ten, luong, trachNhiem);
                    danhSachNV.add(truongPhong);
                    break;
                case 3:
                    System.out.print("Nhập doanh số: ");
                    double doanhSo = Double.parseDouble(scanner.nextLine());
                    System.out.print("Nhập huê hồng (%): ");
                    double hueHong = Double.parseDouble(scanner.nextLine());
                    TiepThi tiepThi = new TiepThi(ma, ten, luong, doanhSo, hueHong);
                    danhSachNV.add(tiepThi);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

            System.out.print("Bạn có muốn nhập tiếp không? (Y/N): ");
            if (scanner.nextLine().equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    private void xuatDanhSach() {
        if (danhSachNV.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }
        System.out.println("--- DANH SÁCH NHÂN VIÊN ---");
        for (NhanVien nv : danhSachNV) {
            nv.xuatThongTin();
            System.out.println("--------------------");
        }
    }

    private void timNhanVien() {
        System.out.print("Nhập mã nhân viên cần tìm: ");
        String maTim = scanner.nextLine();

        NhanVien nvTimThay = null;
        for (NhanVien nv : danhSachNV) {
            if (nv.getManv().equalsIgnoreCase(maTim)) {
                nvTimThay = nv;
                break;
            }
        }

        if (nvTimThay != null) {
            System.out.println("Đã tìm thấy nhân viên:");
            nvTimThay.xuatThongTin();
        } else {
            System.out.println("Không tìm thấy nhân viên với mã: " + maTim);
        }
    }

    private void xoaNhanVien() {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String maXoa = scanner.nextLine();

        NhanVien nvCanXoa = null;
        for (NhanVien nv : danhSachNV) {
            if (nv.getManv().equalsIgnoreCase(maXoa)) {
                nvCanXoa = nv;
                break;
            }
        }

        if (nvCanXoa != null) {
            danhSachNV.remove(nvCanXoa);
            System.out.println("Đã xóa nhân viên có mã: " + maXoa);
        } else {
            System.out.println("Không tìm thấy nhân viên với mã: " + maXoa);
        }
    }

    /**
     * Y5. Cập nhật thông tin nhân viên theo mã
     */
    private void capNhatNhanVien() {
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        String maTim = scanner.nextLine();

        NhanVien nvTimThay = null;
        for (NhanVien nv : danhSachNV) {
            if (nv.getManv().equalsIgnoreCase(maTim)) {
                nvTimThay = nv;
                break;
            }
        }

        if (nvTimThay != null) {
            System.out.println("--- Thông tin cũ ---");
            nvTimThay.xuatThongTin();
            System.out.println("--- Nhập thông tin mới (Để trống nếu không muốn đổi) ---");

            System.out.print("Nhập họ tên mới: ");
            String tenMoi = scanner.nextLine();
            if (!tenMoi.isEmpty()) {
                nvTimThay.setHoten(tenMoi);
            }

            System.out.print("Nhập lương cơ bản mới: ");
            String luongMoiStr = scanner.nextLine();
            if (!luongMoiStr.isEmpty()) {
                nvTimThay.setLuong(Double.parseDouble(luongMoiStr));
            }

            // Cập nhật riêng cho từng loại
            if (nvTimThay instanceof TruongPhong) {
                System.out.print("Nhập lương trách nhiệm mới: ");
                String trachNhiemMoiStr = scanner.nextLine();
                if (!trachNhiemMoiStr.isEmpty()) {
                    ((TruongPhong) nvTimThay).setTrachNhiem(Double.parseDouble(trachNhiemMoiStr));
                }
            } else if (nvTimThay instanceof TiepThi) {
                System.out.print("Nhập doanh số mới: ");
                String doanhSoMoiStr = scanner.nextLine();
                if (!doanhSoMoiStr.isEmpty()) {
                    ((TiepThi) nvTimThay).setDoanhSo(Double.parseDouble(doanhSoMoiStr));
                }

                System.out.print("Nhập huê hồng mới: ");
                String hueHongMoiStr = scanner.nextLine();
                if (!hueHongMoiStr.isEmpty()) {
                    ((TiepThi) nvTimThay).setHueHong(Double.parseDouble(hueHongMoiStr));
                }
            }

            System.out.println("Đã cập nhật thông tin nhân viên!");

        } else {
            System.out.println("Không tìm thấy nhân viên với mã: " + maTim);
        }
    }

    /**
     * Y6. Tìm các nhân viên theo khoảng thu nhập
     */
    private void timTheoKhoangThuNhap() {
        System.out.print("Nhập khoảng thu nhập tối thiểu: ");
        double min = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập khoảng thu nhập tối đa: ");
        double max = Double.parseDouble(scanner.nextLine());

        boolean timThay = false;
        System.out.println("--- Các nhân viên có thu nhập từ " + min + " đến " + max + " ---");

        for (NhanVien nv : danhSachNV) {
            if (nv.getThuNhap() >= min && nv.getThuNhap() <= max) {
                nv.xuatThongTin();
                System.out.println("--------------------");
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy nhân viên nào trong khoảng thu nhập này.");
        }
    }

    /**
     * Y7. Sắp xếp nhân viên theo họ và tên
     */
    private void sapXepTheoHoTen() {
        Collections.sort(danhSachNV, (nv1, nv2) -> nv1.getHoten().compareTo(nv2.getHoten()));

        System.out.println("Đã sắp xếp danh sách theo họ tên.");
        xuatDanhSach();
    }

    /**
     * Y8. Sắp xếp nhân viên theo thu nhập
     */
    private void sapXepTheoThuNhap() {
        Collections.sort(danhSachNV, (nv1, nv2) -> Double.compare(nv1.getThuNhap(), nv2.getThuNhap()));

        System.out.println("Đã sắp xếp danh sách theo thu nhập (tăng dần).");
        xuatDanhSach();
    }

    /**
     * Y9. Xuất 5 nhân viên có thu nhập cao nhất
     */
    private void xuatTop5ThuNhap() {
        if (danhSachNV.isEmpty()) {
            System.out.println("Danh sách trống, không thể xuất Top 5.");
            return;
        }

        // Sắp xếp giảm dần theo thu nhập
        Collections.sort(danhSachNV, (nv1, nv2) -> Double.compare(nv2.getThuNhap(), nv1.getThuNhap()));

        System.out.println("--- TOP 5 NHÂN VIÊN CÓ THU NHẬP CAO NHẤT ---");

        int top = Math.min(5, danhSachNV.size());

        for (int i = 0; i < top; i++) {
            danhSachNV.get(i).xuatThongTin();
            System.out.println("--------------------");
        }
    }
}
