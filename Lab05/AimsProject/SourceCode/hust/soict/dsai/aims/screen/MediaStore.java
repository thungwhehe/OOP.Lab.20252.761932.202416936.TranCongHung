package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("Add to cart");
        container.add(addToCartBtn);

        // Xử lý sự kiện thêm vào giỏ hàng thực tế
        addToCartBtn.addActionListener(e -> {
            try {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(null, "Added " + media.getTitle() + " to cart!");
            } catch (LimitExceededException ex) {
                // Hiển thị lỗi ra màn hình thay vì crash
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        if (media instanceof Playable) {
            JButton playBtn = new JButton("Play");
            container.add(playBtn);

            // Xử lý sự kiện Play media dạng đối thoại Swing
            playBtn.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JDialog dialog = new JDialog();
                    // ... (phần code hiển thị dialog giữ nguyên) ...
                    dialog.setVisible(true);
                } catch (PlayerException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Play Error", JOptionPane.ERROR_MESSAGE);
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}