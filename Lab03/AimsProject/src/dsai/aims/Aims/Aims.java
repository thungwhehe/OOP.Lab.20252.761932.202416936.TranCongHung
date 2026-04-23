package hust.soict.dsai.aims.Aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // Thử nghiệm xóa đĩa ở bước 11
        // Thử xóa đĩa dvd2 (Star Wars)
        System.out.println("\nRemoving 'Star Wars' from the cart...");
        anOrder.removeDigitalVideoDisc(dvd2);

        // In lại tổng tiền sau khi xóa để kiểm tra
        System.out.print("Total Cost after removal: ");
        System.out.println(anOrder.totalCost());  // chỗ này in ra 38.94 laf đúng (63.89 - 24.95 = 38.94)

        // Thử xóa một đĩa không có trong giỏ (để test trường hợp lỗi)
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avatar", "Sci-Fi", 20.0f);
        System.out.println("\nTrying to remove 'Avatar' (not in cart)...");
        anOrder.removeDigitalVideoDisc(dvd4);
    }
}