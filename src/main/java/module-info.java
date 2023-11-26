module com.example.startercodestickherogame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example.startercodestickherogame to javafx.fxml;
    exports com.example.startercodestickherogame;
}