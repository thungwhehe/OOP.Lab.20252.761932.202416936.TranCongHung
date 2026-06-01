package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null); // Giúp màn hình hiển thị chính giữa máy tính
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // Tạo menu con Update Store
        JMenu smUpdateStore = new JMenu("Update Store");

        // Định nghĩa các item cụ thể thay vì tạo ẩn danh
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            this.dispose(); // Đóng Store hiện tại
            new AddBookToStoreScreen(this.store, this.cart); // Mở màn hình thêm Book
        });

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            this.dispose(); // Đóng Store hiện tại
            new AddCompactDiscToStoreScreen(this.store, this.cart); // Mở màn hình thêm CD
        });

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            this.dispose(); // Đóng Store hiện tại
            new AddDigitalVideoDiscToStoreScreen(this.store, this.cart); // Mở màn hình thêm DVD
        });

        // Thêm các item vào menu Update Store
        smUpdateStore.add(addBookItem);
        smUpdateStore.add(addCDItem);
        smUpdateStore.add(addDVDItem);
        menu.add(smUpdateStore);

        // Thêm nút View Store (Màn hình hiện tại nên không cần xử lý gì đặc biệt)
        JMenuItem viewStoreItem = new JMenuItem("View store");
        menu.add(viewStoreItem);

        // Thêm nút View Cart trên Menu Bar và xử lý sự kiện
        JMenuItem viewCartItem = new JMenuItem("View cart");
        viewCartItem.addActionListener(e -> {
            this.setVisible(false); // Ẩn màn hình Store đi chứ không xóa hoàn toàn

            CartScreen cartScreen = new CartScreen(this.cart);
            cartScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Chỉ đóng cửa sổ giỏ hàng

            // Lắng nghe sự kiện tắt cửa sổ của CartScreen để hiện lại StoreScreen
            cartScreen.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    StoreScreen.this.setVisible(true); // Hiện lại Store cũ
                }
            });
        });
        menu.add(viewCartItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));

        // Cập nhật sự kiện nút View Cart to đùng ở Header
        cartBtn.addActionListener(e -> {
            this.setVisible(false); // Ẩn màn hình Store đi

            CartScreen cartScreen = new CartScreen(this.cart);
            cartScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Chỉ đóng cửa sổ giỏ hàng

            // Lắng nghe sự kiện tắt cửa sổ của CartScreen để hiện lại StoreScreen
            cartScreen.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    StoreScreen.this.setVisible(true); // Hiện lại Store cũ
                }
            });
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < Math.min(mediaInStore.size(), 9); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), this.cart);
            center.add(cell);
        }

        return center;
    }
}