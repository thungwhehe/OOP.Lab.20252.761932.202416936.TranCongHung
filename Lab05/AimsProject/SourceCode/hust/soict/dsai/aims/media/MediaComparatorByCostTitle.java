package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        // Sắp xếp theo giá giảm dần (m2 trước, m1 sau)
        int costCompare = Float.compare(m2.getCost(), m1.getCost());
        if (costCompare != 0) {
            return costCompare;
        }
        // Nếu trùng giá, sắp xếp theo tiêu đề (alphabetical)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}