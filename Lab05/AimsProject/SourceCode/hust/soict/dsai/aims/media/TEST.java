package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        // 1. Tạo danh sách chứa kiểu dữ liệu chung là Media
        List<Media> mediae = new ArrayList<Media>();

        // 2. Tạo các đối tượng cụ thể từ các lớp con (Book, DVD, CD)
        CompactDisc cd = new CompactDisc(1, "Starboy", "Pop", 15.5f, "The Weeknd", 0, "The Weeknd");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book(3, "Java Programming", "Education", 25.0f);
        book.addAuthor("Trần Công Hưng");

        // 3. Đưa tất cả các đối tượng khác loài này vào chung danh sách mediae
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // 4. Duyệt qua danh sách và gọi phương thức toString()
        System.out.println("\n=== KẾT QUẢ IN DANH SÁCH SỬ DỤNG ĐA HÌNH ===");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}