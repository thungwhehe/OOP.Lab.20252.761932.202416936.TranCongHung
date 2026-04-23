package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc danhSachDia[] = new DigitalVideoDisc[100];
    private int soLuongHienTai = 0;

    // Phương thức thêm DVD
    public void addDVD(DigitalVideoDisc diaMoi) {
        if (soLuongHienTai < danhSachDia.length) {
            danhSachDia[soLuongHienTai] = diaMoi;
            soLuongHienTai++;
            System.out.println("Da them dia: " + diaMoi.getTitle() + " vao kho.");
        } else {
            System.out.println("Kho hang da day, khong the them!");
        }
    }

    // Phương thức xóa DVD
    public void removeDVD(DigitalVideoDisc diaCanXoa) {
        int viTriTimThay = -1;
        for (int i = 0; i < soLuongHienTai; i++) {
            if (danhSachDia[i] == diaCanXoa) {
                viTriTimThay = i;
                break;
            }
        }

        if (viTriTimThay != -1) {
            for (int i = viTriTimThay; i < soLuongHienTai - 1; i++) {
                danhSachDia[i] = danhSachDia[i + 1];
            }
            danhSachDia[soLuongHienTai - 1] = null;
            soLuongHienTai--;
            System.out.println("Da xoa dia: " + diaCanXoa.getTitle() + " khoi kho.");
        } else {
            System.out.println("Khong tim thay dia nay trong cua hang.");
        }
    }
}