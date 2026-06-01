package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        // Gọi Constructor của lớp cha Media
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        boolean check = false;
        for (String author : authors) {
            if (author.equals(authorName)) {
                check = true;
                break;
            }
        }
        if (!check) {
            authors.add(authorName);
            System.out.println("Đã thêm tác giả: " + authorName);
        } else {
            System.out.println("Tác giả " + authorName + " đã tồn tại!");
        }
    }
    // xóa tác giả
    public void removeAuthor(String authorName) {
        boolean check = false;
        for (String author : authors) {
            if (author.equals(authorName)) {
                check = true;
                break;
            }
        }

        if (check) {
            authors.remove(authorName);
            System.out.println("Đã xóa tác giả: " + authorName);
        } else {
            System.out.println("Không tìm thấy tác giả: " + authorName);
        }
    }
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + ": " + getCost() + " $";
    }

}