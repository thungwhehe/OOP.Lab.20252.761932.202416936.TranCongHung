package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) {
        String duongDanFile = "D:\\OOP\\IdeaProjects\\Lab03\\text.txt";
        byte[] duLieuMangByte = { 0 };
        long thoiGianBatDau, thoiGianKetThuc;

        try {
            duLieuMangByte = Files.readAllBytes(Paths.get(duongDanFile));
            thoiGianBatDau = System.currentTimeMillis();

            StringBuilder chuoiXayDung = new StringBuilder();
            for (byte b : duLieuMangByte) {
                chuoiXayDung.append((char)b);
            }
            String chuoiKetQua = chuoiXayDung.toString();
            thoiGianKetThuc = System.currentTimeMillis();
            System.out.println("Thoi gian xu ly (No Garbage): " + (thoiGianKetThuc - thoiGianBatDau) + "ms");

        } catch (IOException e) {
            System.out.println("Loi: Khong tim thay hoac khong doc duoc file!");
        }
    }
}