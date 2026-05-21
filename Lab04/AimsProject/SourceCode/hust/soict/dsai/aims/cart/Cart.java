package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import java.util.Collections;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Cart {
    private java.util.ArrayList<hust.soict.dsai.aims.media.Media> itemsOrdered = new java.util.ArrayList<>();

    public void addMedia(hust.soict.dsai.aims.media.Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Mặt hàng \"" + media.getTitle() + "\" đã tồn tại trong giỏ hàng!");
        } else {
            itemsOrdered.add(media);
            System.out.println("Đã thêm thành công: " + media.getTitle());
        }
    }

    // Xóa một mặt hàng Media khỏi giỏ hàng
    public void removeMedia(hust.soict.dsai.aims.media.Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa thành công: " + media.getTitle());
        } else {
            System.out.println("Mặt hàng \"" + media.getTitle() + "\" không có trong giỏ hàng.");
        }
    }

    // tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (hust.soict.dsai.aims.media.Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // 4. In danh sách giỏ hàng sử dụng vòng lặp duyệt ArrayList
    public void print() {
        System.out.println("***********************GIỎ HÀNG***********************");
        System.out.println("Các mặt hàng đã đặt:");

        // Sử dụng biến chạy hoặc vòng lặp để lấy kích thước động thông qua itemsOrdered.size()
        for (int i = 0; i < itemsOrdered.size(); i++) {
            // Lấy phần tử trong ArrayList phải dùng .get(i) chứ không dùng [i] nữa Hưng nhé
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }

        System.out.println("Tổng chi phí: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // 5. Tìm kiếm mặt hàng theo ID
    public void searchById(int id) {
        boolean found = false;
        for (hust.soict.dsai.aims.media.Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Tìm thấy mặt hàng khớp với ID " + id + ": " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Rất tiếc, không tìm thấy mặt hàng nào có ID: " + id);
        }
    }

    // 6. Tìm kiếm mặt hàng theo tiêu đề
    public void searchByTitle(String title) {
        boolean found = false;
        for (hust.soict.dsai.aims.media.Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Tìm thấy mặt hàng khớp với tiêu đề '" + title + "': " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy kết quả phù hợp cho tiêu đề: " + title);
        }
    }
    public void sortByTitle() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Giỏ hàng đã được sắp xếp theo Title -> Cost.");
    }

    public void sortByCost() {
        Collections.sort(this.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Giỏ hàng đã được sắp xếp theo Cost -> Title.");
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
