package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // giữ biến static để đếm số lượng DVD
    private static int nbDigitalVideoDiscs = 0;

    // Constructor đầy đủ tham số
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        // Tăng số lượng đĩa trước để lấy ID mới, sau đó truyền vào super cùng với các thuộc tính của Disc/Media
        super(++nbDigitalVideoDiscs, title, category, cost, director, length);
    }

    // Constructor rút gọn 1 tham số (title)
    public DigitalVideoDisc(String title) {
        // Những thuộc tính chưa có thì mình truyền tạm giá trị mặc định (null hoặc 0) lên lớp cha
        super(++nbDigitalVideoDiscs, title, null, 0.0f, null, 0);
    }

    /// Constructor 3 tham số
    public DigitalVideoDisc(String title, String category, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost, null, 0);
    }

    // 3. CÁC PHƯƠNG THỨC RIÊNG CỦA DVD

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() +
                " - " + getLength() + ": " + getCost() + " $";
    }

    public boolean isMatch(String title) {
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}