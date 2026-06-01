package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.cart.Cart;
import java.io.IOException;

public class CartScreen extends JFrame {
    private Cart cart;

    public CartScreen(Cart cart) {
        super();
        this.cart = cart;

        // Tạo JFXPanel để nhúng JavaFX vào Swing
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);

        // Chạy JavaFX trên luồng (thread) riêng của nó
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));

                    // Khởi tạo Controller và truyền đối tượng cart vào
                    CartScreenController controller = new CartScreenController(cart);
                    loader.setController(controller);

                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Đảm bảo hiển thị sau khi cấu hình xong các luồng con
        this.setVisible(true);
    }
}