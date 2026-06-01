package hust.soict.globalict.swing; // Hoặc .dsai.swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10];
    private JButton btnDelete, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        // Căn lề phải cho text field (giống máy tính bỏ túi)
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelButtons, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200);
        setVisible(true);
    }

    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener();

        // Tạo các nút từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i);
            panelButtons.add(btnNumbers[i]);
            btnNumbers[i].addActionListener(btnListener);
        }

        // Nút DEL (Xóa 1 số cuối)
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Nút số 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Nút C (Clear - Xóa hết)
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    // Main method để bạn có thể chạy thử lớp này
    public static void main(String[] args) {
        new NumberGrid();
    }

    // --- ĐÂY LÀ PHẦN BẠN CẦN HOÀN THIỆN THEO YÊU CẦU TRANG 8-9 ---
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();

            // Trường hợp 1: Nhấn vào các phím số (0-9)
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button);
            }

            // Trường hợp 2: Nhấn vào nút DEL (Xóa ký tự cuối cùng)
            else if (button.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (currentText.length() > 0) {
                    // Cắt chuỗi từ vị trí 0 đến chiều dài cũ - 1
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            }

            // Trường hợp 3: Nhấn vào nút C (Xóa sạch màn hình)
            else { // Nút "C"
                tfDisplay.setText("");
            }
        }
    }
}