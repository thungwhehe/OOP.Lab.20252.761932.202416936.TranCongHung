package hust.soict.dsai.aims.screen;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.transformation.FilteredList;

public class CartScreenController {
    private Cart cart;
    // Khai báo FilteredList làm thuộc tính lớp để dùng chung
    private FilteredList<Media> filteredData;

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotalCost;
    @FXML private TextField tfFilter;
    @FXML private RadioButton radioBtnFilterId;
    @FXML private RadioButton radioBtnFilterTitle;

    // Gán dữ liệu cart vào thuộc tính lớp
    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        // Thiết lập các cột
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Khởi tạo FilteredList một lần duy nhất khi mở màn hình
        if (this.cart != null) {
            this.filteredData = new FilteredList<>(this.cart.getItemsOrdered(), p -> true);
            tblMedia.setItems(this.filteredData); // Đổ FilteredList vào bảng luôn
            lblTotalCost.setText(this.cart.totalCost() + " $");
        }

        // Ẩn nút khi chưa chọn gì
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự kiện chọn dòng
        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            }
        });

        // 1. Lắng nghe sự kiện khi người dùng GÕ CHỮ
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });

        // 2. Lắng nghe sự kiện khi người dùng CLICK chọn nút "By ID"
        radioBtnFilterId.selectedProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(tfFilter.getText());
        });

        // 3. Lắng nghe sự kiện khi người dùng CLICK chọn nút "By Title"
        radioBtnFilterTitle.selectedProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(tfFilter.getText());
        });
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnRemovePressed(javafx.event.ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            lblTotalCost.setText(cart.totalCost() + " $");
        }
    }

    @FXML
    void btnPlayPressed(javafx.event.ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            javax.swing.JOptionPane.showMessageDialog(null, "Playing: " + media.getTitle());
        }
    }

    // Hàm lọc logic đã được tối ưu lại gọn gàng và chạy real-time
    private void showFilteredMedia(String filterString) {
        if (this.filteredData == null) return;

        this.filteredData.setPredicate(media -> {
            // Nếu ô tìm kiếm trống, hiển thị tất cả
            if (filterString == null || filterString.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filterString.toLowerCase();

            // Nếu người dùng chọn lọc theo Title
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }

            // Nếu người dùng chọn lọc theo ID
            else if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            }

            return false;
        });
    }
    @FXML
    void btnPlaceOrderPressed(javafx.event.ActionEvent event) {
        if (cart.getItemsOrdered().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Giỏ hàng đang trống rỗng ông ơi!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Đặt hàng thành công! Tổng tiền: " + cart.totalCost() + " $");
            cart.getItemsOrdered().clear(); // Xóa sạch giỏ hàng
            lblTotalCost.setText("0.0 $"); // Reset tiền về 0
        }
    }
    @FXML
    void menuViewStorePressed(javafx.event.ActionEvent event) {
        // 1. Đóng màn hình Cart hiện tại (JavaFX)
        tfFilter.getScene().getWindow().hide();

        // 2. Mở lại màn hình StoreScreen (Swing) có sẵn của ông
        // Giả sử ông có một thực thể store dùng chung, truyền nó vào đây
        // new StoreScreen(store, cart);
    }
}