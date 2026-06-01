package hust.soict.dsai.test.disc;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // 1. Test swap cũ (Kết quả: Không đổi vị trí ô nhớ gốc)
        swap(jungleDVD, cinderellaDVD);
        System.out.println("After swap - jungle: " + jungleDVD.getTitle());

        // 2. Test correctSwapXịn (Tráo đổi bằng cách tạo mảng hoặc tạo đối tượng mới wrapper)
        // Vì không còn hàm setTitle() nên ta sẽ bọc chúng vào một mảng để hoán đổi tham chiếu thực sự ngoài hàm main
        DigitalVideoDisc[] dvds = {jungleDVD, cinderellaDVD};
        correctSwap(dvds, 0, 1);

        System.out.println("After correct swap - jungle: " + dvds[0].getTitle());
        System.out.println("After correct swap - cinderella: " + dvds[1].getTitle());
    }

    // Hàm swap lỗi (Pass-by-value đối với tham chiếu) -> Giữ nguyên để test lý thuyết
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // Hàm hoán đổi chính xác bằng cách tráo đổi vị trí trong mảng tham chiếu
    public static void correctSwap(DigitalVideoDisc[] dvdArray, int idx1, int idx2) {
        DigitalVideoDisc tmp = dvdArray[idx1];
        dvdArray[idx1] = dvdArray[idx2];
        dvdArray[idx2] = tmp;
    }
}