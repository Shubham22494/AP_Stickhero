package com.example.project;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class HelloApplication extends Application {                             ////This code only create the game start page and I haven't added any functionalities in it.
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hero Game");
        Parent root=FXMLLoader.load(getClass().getResource("hello.fxml"));
        primaryStage.setTitle("Stick Hero");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        // Create UI components
//        Button startButton = new Button("Start Game");
//        Button settingsButton = new Button("Settings");
//        Button exitButton = new Button("Exit");
//
//
//        // Set up actions for buttons (similar to what was shown in the previous example)
//
//        // Arrange components in a vertical box
//        VBox menuLayout = new VBox(10);
//        menuLayout.getChildren().addAll(startButton, settingsButton, exitButton);
//
//        // Create scene
//        Scene menuScene = new Scene(menuLayout, 300, 200);
//
//        // Set the scene for the primary stage
//        primaryStage.setScene(menuScene);
//        primaryStage.show();
    }

}
