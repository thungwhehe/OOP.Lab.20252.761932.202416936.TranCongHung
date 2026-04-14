public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // 1. Test swap cũ (Kết quả: Không đổi)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap - jungle: " + jungleDVD.getTitle());

        // 2. Test changeTitle (Kết quả: jungle biến thành Cinderella)
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("After changeTitle - jungle: " + jungleDVD.getTitle());

        // setup lại tên cho jungle để test swap xịn ---
        jungleDVD.setTitle("Jungle");

        // 3. Test correctSwap (Kết quả: Jungle thành Cinderella và ngược lại)
        correctSwap(jungleDVD, cinderellaDVD);
        System.out.println("After correct swap - jungle: " + jungleDVD.getTitle());
        System.out.println("After correct swap - cinderella: " + cinderellaDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void correctSwap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        // Tráo đổi nội dung bên trong thay vì tráo đổi địa chỉ
        String tmpTitle = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmpTitle);
    }
}