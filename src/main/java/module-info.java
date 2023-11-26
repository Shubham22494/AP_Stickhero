module com.example.gameoverscreen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gameoverscreen to javafx.fxml;
    exports com.example.gameoverscreen;
}