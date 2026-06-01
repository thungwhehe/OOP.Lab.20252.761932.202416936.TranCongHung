package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Artist:"));
        tfArtist = new JTextField(20);
        panel.add(tfArtist);
    }

    @Override
    protected void addBtnPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();

        CompactDisc cd = new CompactDisc(title, category, artist, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "Đã thêm CD thành công!");
        this.dispose();
        new StoreScreen(store, cart);
    }
}