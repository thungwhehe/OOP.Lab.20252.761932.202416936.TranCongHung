package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    // Giữ nguyên tên biến danhSachDia nhưng đổi kiểu dữ liệu sang ArrayList<Media>
    private ArrayList<Media> danhSachDia = new ArrayList<Media>();

    // Phương thức thêm mặt hàng vào kho
    public void addMedia(Media media) {
        if (danhSachDia.contains(media)) {
            System.out.println("Mặt hàng \"" + media.getTitle() + "\" đã có sẵn trong cửa hàng rồi!");
        } else {
            danhSachDia.add(media);
            System.out.println("Da them dia/sach: " + media.getTitle() + " vao kho.");
        }
    }

    // Phương thức xóa mặt hàng khỏi kho
    public void removeMedia(Media media) {
        if (danhSachDia.contains(media)) {
            danhSachDia.remove(media);
            System.out.println("Da xoa dia/sach: " + media.getTitle() + " khoi kho.");
        } else {
            System.out.println("Khong tim thay mat hang nay trong cua hang.");
        }
    }

    public Media searchByTitle(String title) {
        // Sửa itemsInStore thành danhSachDia để khớp với thuộc tính của bạn
        for (Media media : danhSachDia) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
    public void printStore() {
        System.out.println("\n***********************STORE***********************");
        System.out.println("Items in Store:");
        if (danhSachDia.isEmpty()) {
            System.out.println("[Cửa hàng hiện đang trống]");
        } else {
            for (int i = 0; i < danhSachDia.size(); i++) {
                System.out.println((i + 1) + ". " + danhSachDia.get(i).toString());
            }
        }
        System.out.println("***************************************************");
    }
}