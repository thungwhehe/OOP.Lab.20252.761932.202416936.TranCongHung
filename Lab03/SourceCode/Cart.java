public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;

    // thêm đĩa vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    /* 1. Nạp chồng: Thêm một mảng các DVD
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            // Gọi lại hàm thêm 1 đĩa để tận dụng logic kiểm tra
            addDigitalVideoDisc(disc);
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full. Cannot add more.");
                break;
            }
        }
    }*/

    /* 2. Nạp chồng: Thêm số lượng tham số tùy biến (Varargs)
       Cách này cho phép  truyền bao nhiêu DVD tùy ý: add(d1, d2, d3...)*/
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc disc : dvds) {
            addDigitalVideoDisc(disc);
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                break;
            }
        }
    }

    // 3. Nạp chồng: Thêm đúng 2 DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // xóa đĩa khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int index = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc was not found in the cart.");
        }
    }

    // tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        System.out.println("Total Cost: " + total);
        return total;
    }
}

