package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        // 1. Đổi sang hàm dùng chung addMedia
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);

        // 2. Đổi tên hàm hiển thị giỏ hàng cho chuẩn Lab 04 (printCart)
        cart.print();

        System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");

        // 3. Gọi các hàm tìm kiếm
        cart.searchById(2);

        cart.searchByTitle("Lion");
        cart.searchByTitle("Iron Man");
    }
}