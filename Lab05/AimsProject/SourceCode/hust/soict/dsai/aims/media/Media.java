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

    @Override
    public boolean equals(Object obj) {
        // 1. Kiểm tra chính nó
        if (this == obj) return true;

        // 2. Kiểm tra null hoặc khác class (dùng instanceof để an toàn)
        if (obj == null || !(obj instanceof Media)) return false;

        // 3. Ép kiểu và so sánh title (dùng equalsIgnoreCase để linh hoạt)
        Media other = (Media) obj;
        return this.getTitle() != null && this.getTitle().equalsIgnoreCase(other.getTitle());
    }
    @Override
    public int hashCode() {
        return this.getTitle() != null ? this.getTitle().toLowerCase().hashCode() : 0;
    }
}