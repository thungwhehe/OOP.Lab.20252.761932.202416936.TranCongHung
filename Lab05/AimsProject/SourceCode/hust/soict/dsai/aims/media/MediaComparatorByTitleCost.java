package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        // So sánh theo tiêu đề (alphabetical)
        int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleCompare != 0) {
            return titleCompare;
        }
        // Nếu trùng tiêu đề, sắp xếp theo giá giảm dần (m2 trước, m1 sau)
        return Float.compare(m2.getCost(), m1.getCost());
    }
}