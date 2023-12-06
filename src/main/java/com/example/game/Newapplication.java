package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Newapplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("new.fxml"));
        Parent root = fxmlLoader.load();
        Newcontroller controller = fxmlLoader.getController(); // Corrected variable name
        controller.generatePillars();
        Scene scene = new Scene(root);
        stage.setTitle("Stick Hero Game(Invisible Button to increase stick press on or above character )");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}