package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    //  tự động tăng ID cho CD giống bên DVD
    private static int nbCompactDiscs = 0;

    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }

    // 2. Constructor số 1
    public CompactDisc(int id, String title, String category, float cost, String director, int length, String artist) {
        super(id, title, category, cost, director, length);
        this.artist = artist;
    }

    // 3. Constructor số 2
    public CompactDisc(String title, String category, String director, float cost, String artist) {
        // Tăng ID tự động, độ dài length ban đầu truyền tạm là 0 vì sẽ tính bằng tổng các track sau
        super(++nbCompactDiscs, title, category, cost, director, 0);
        this.artist = artist;
    }

    // addTrack
    public void addTrack(Track inputTrack) {
        boolean isExist = false;
        for (Track t : tracks) {
            if (t.getTitle().equalsIgnoreCase(inputTrack.getTitle()) && t.getLength() == inputTrack.getLength()) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            System.out.println("Track \"" + inputTrack.getTitle() + "\" đã tồn tại trong CD!");
        } else {
            tracks.add(inputTrack);
            System.out.println("Đã thêm thành công track: " + inputTrack.getTitle());
        }
    }

    //removeTrack
    public void removeTrack(Track inputTrack) {
        Track trackToRemove = null;
        for (Track t : tracks) {
            if (t.getTitle().equalsIgnoreCase(inputTrack.getTitle()) && t.getLength() == inputTrack.getLength()) {
                trackToRemove = t;
                break;
            }
        }

        if (trackToRemove != null) {
            tracks.remove(trackToRemove);
            System.out.println("Đã xóa thành công track: " + inputTrack.getTitle());
        } else {
            System.out.println("Không thể xóa! Track \"" + inputTrack.getTitle() + "\" không có trong CD.");
        }
    }

    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track t : tracks) {
            totalLength += t.getLength();
        }
        return totalLength;
    }

    public void play() {
        // In ra một số thông tin cơ bản của CD ra console
        System.out.println("Playing CD: " + this.getTitle() + " by " + this.getArtist());
        System.out.println("CD director: " + this.getDirector());
        System.out.println("CD total length: " + this.getLength() + " minutes");
        System.out.println("----------------------------------------");

        // vòng lặp duyệt qua từng track trong ArrayList và gọi hàm play() của Track đó
        for (Track t : tracks) {
            t.play();
        }
    }

    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - Artist: " + artist + " - Length: " + getLength() + ": " + getCost() + " $";
    }
}