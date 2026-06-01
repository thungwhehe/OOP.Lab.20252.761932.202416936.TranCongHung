package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");
    }

    @Override
    protected void addCustomFields(JPanel panel) {
        panel.add(new JLabel("Authors (comma separated):"));
        tfAuthors = new JTextField(20);
        panel.add(tfAuthors);
    }

    @Override
    protected void addBtnPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        // Tự động sinh id bằng tổng số item trong kho + 1
        int id = store.getItemsInStore().size() + 1;

        // Truyền thêm id vào vị trí đầu tiên đúng như constructor yêu cầu
        Book book = new Book(id, title, category, cost);
        String[] authors = tfAuthors.getText().split(",");
        for (String author : authors) {
            book.addAuthor(author.trim());
        }

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Đã thêm Sách thành công!");
        this.dispose();
        new StoreScreen(store, cart);
    }
}