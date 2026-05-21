package hust.soict.dsai.aims.media;
import java.util.Comparator;

public abstract class Media {
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    private int id;
    private String title;
    private String category;
    private float cost;

    // 1. THÊM CONSTRUCTOR ĐẦY ĐỦ THAM SỐ (Thay thế cho Constructor trống cũ)
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // 2. CHỈ GIỮ LẠI CÁC HÀM GETTER
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public boolean isMatch(String title) {
        // Tránh lỗi NullPointerException nếu title của đối tượng bị null
        if (this.title == null || title == null) return false;
        // So sánh không phân biệt hoa thường
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    public boolean equals(Object obj) {
        // 1. Nếu hai đối tượng cùng trỏ vào một ô nhớ thì chắc chắn bằng nhau
        if (this == obj) return true;

        // 2. Kiểm tra nếu đối tượng truyền vào bị null hoặc không phải là thực thể (instance) của Media
        if (obj == null || !(obj instanceof Media)) {
            return false; // Trả về false đúng như câu hỏi "If the passing object is not an instance of Media..."
        }

        // 3. Ép kiểu (Cast) Object obj về kiểu Media để so sánh thuộc tính
        Media other = (Media) obj;

        // 4. So sánh thuộc tính 'title' (Tránh lỗi NullPointerException nếu title bị null)
        if (this.title == null) {
            return other.title == null;
        }

        // So sánh không phân biệt hoa thường cho linh hoạt
        return this.title.equalsIgnoreCase(other.title);
    }
}