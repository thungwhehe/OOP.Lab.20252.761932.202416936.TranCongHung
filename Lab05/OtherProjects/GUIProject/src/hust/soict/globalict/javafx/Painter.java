package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Tải file giao diện Painter.fxml lên
        // Lưu ý: Tên file "Painter.fxml" phải viết đúng từng chữ hoa chữ thường
        Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));

        // Tạo một khung cảnh (Scene) chứa giao diện đã tải
        Scene scene = new Scene(root);

        // Thiết lập các thuộc tính cho cửa sổ (Stage)
        stage.setTitle("Painter App - Lab 05");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Gọi lệnh khởi chạy ứng dụng JavaFX
        launch(args);
    }
}