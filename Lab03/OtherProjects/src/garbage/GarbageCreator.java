package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String duongDanFile = "D:\\OOP\\IdeaProjects\\Lab03\\text.txt";
        byte[] duLieuMangByte = { 0 };
        long thoiGianBatDau, thoiGianKetThuc;

        try {
            duLieuMangByte = Files.readAllBytes(Paths.get(duongDanFile));
            thoiGianBatDau = System.currentTimeMillis();

            String chuoiKetQua = "";
            for (byte b : duLieuMangByte) {
                chuoiKetQua += (char)b;
            }
            thoiGianKetThuc = System.currentTimeMillis();
            System.out.println("Thoi gian xu ly (Garbage): " + (thoiGianKetThuc - thoiGianBatDau) + "ms");

        } catch (IOException e) {
            System.out.println("Loi: Khong tim thay hoac khong doc duoc file!");
        }
    }
}