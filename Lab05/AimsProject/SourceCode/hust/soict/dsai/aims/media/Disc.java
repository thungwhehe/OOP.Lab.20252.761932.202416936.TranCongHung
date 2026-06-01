package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    // 1. Constructor đầy đủ tham số để các lớp con như DigitalVideoDisc gọi tới
    public Disc(int id, String title, String category, float cost, String director, int length) {
        // Đẩy 4 thuộc tính cốt lõi lên thẳng lớp cha Media qua super
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    // Getter methods
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }
}