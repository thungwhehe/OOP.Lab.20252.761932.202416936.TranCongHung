package hust.soict.dsai.aims.media;
import hust.soict.dsai.aims.exception.PlayerException;
public class Track implements Playable {
    private String title;
    private int length;

    public Track() {
    }

    //Constructor đầy đủ tham số để khởi tạo một bài hát mới
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    //Tạo các phương thức Getter ở dạng public
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            // Ném ra PlayerException nếu track bị lỗi độ dài
            throw new PlayerException("ERROR: Track \"" + this.getTitle() + "\" length is non-positive!");
        }
    }

    public boolean equals(Object obj) {
        // 1. Kiểm tra cùng ô nhớ
        if (this == obj) return true;

        // 2. Kiểm tra null và kiểu dữ liệu có phải là Track không
        if (obj == null || !(obj instanceof Track)) {
            return false;
        }

        // 3. Ép kiểu Object về kiểu Track
        Track other = (Track) obj;

        // 4. Kiểm tra điều kiện: Trùng cả title VÀ length
        if (this.length != other.length) return false;

        if (this.title == null) {
            return other.title == null;
        }
        return this.title.equalsIgnoreCase(other.title);
    }

}