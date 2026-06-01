package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;

    // Các ô nhập liệu chung mà Book, CD, DVD đều có
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String titleHeader) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // 1. Thêm Menu Bar chung
        setJMenuBar(createMenuBar());

        // 2. Tiêu đề màn hình
        JPanel headerPanel = new JPanel();
        headerPanel.add(new JLabel(titleHeader, JLabel.CENTER));
        cp.add(headerPanel, BorderLayout.NORTH);

        // 3. Form nhập liệu (Dùng GridLayout)
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField(20);
        formPanel.add(tfTitle);

        formPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField(20);
        formPanel.add(tfCategory);

        formPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField(20);
        formPanel.add(tfCost);

        // Hàm này để các class con tự thêm các trường riêng của chúng vào formPanel
        addCustomFields(formPanel);

        // Nút Add chung
        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> addBtnPressed());
        formPanel.add(new JLabel("")); // Ô trống giữ chỗ
        formPanel.add(btnAdd);

        cp.add(formPanel, BorderLayout.CENTER);

        setTitle(titleHeader);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // Thanh menu bar điều hướng quay lại Store
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreMenu = new JMenuItem("View Store");

        viewStoreMenu.addActionListener(e -> {
            this.dispose(); // Đóng màn hình thêm đồ
            new StoreScreen(store, cart); // Quay lại màn hình Store
        });

        menu.add(viewStoreMenu);
        menuBar.add(menu);
        return menuBar;
    }

    // Các phương thức trừu tượng để class con tự định nghĩa
    protected abstract void addCustomFields(JPanel panel);
    protected abstract void addBtnPressed();
}