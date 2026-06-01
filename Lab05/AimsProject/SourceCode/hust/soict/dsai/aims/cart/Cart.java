package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.Collections;
import java.util.ArrayList;
// THÊM 2 IMPORT MỚI NÀY
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import hust.soict.dsai.aims.exception.LimitExceededException;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    // 1. Sửa kiểu dữ liệu từ ArrayList sang ObservableList
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // 2. Thêm hàm này để CartScreenController gọi được
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media m) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m);
            System.out.println("The media " + m.getTitle() + " has been added.");
        } else {
            // Ném lỗi ra khi giỏ hàng quá tải
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa thành công: " + media.getTitle());
        } else {
            System.out.println("Mặt hàng \"" + (media != null ? media.getTitle() : "null") + "\" không có trong giỏ hàng.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************GIỎ HÀNG***********************");
        System.out.println("Các mặt hàng đã đặt:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Tổng chi phí: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tìm thấy: " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Không tìm thấy ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Tìm thấy: " + media.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy tiêu đề: " + title);
    }

    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Đã sắp xếp theo Title.");
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Đã sắp xếp theo Cost.");
    }

    public Media searchByTitleReturnMedia(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }

    public int getQuantity() {
        return itemsOrdered.size();
    }
}