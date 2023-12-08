package com.example.startercodestickherogame;
//package com.example.startercodestickherogame;
//

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StickHeroApp extends Application {
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StickHeroApp.class.getResource("hi.fxml"));
        Parent root = fxmlLoader.load();
        StickHeroController controller = fxmlLoader.getController();
        controller.generatePillars();// Corrected variable name
        controller.generateCherries();
        Scene scene = new Scene(root);
        stage.setTitle("Stick Hero Game(Invisible Button to increase stick press on or above character )");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public Stage getPrimaryStage() {

        return stage;
    }
}
//import javafx.animation.KeyFrame;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.StackPane;
////import javafx.scene.media.AudioClip;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//
//import java.io.IOException;

//public class StickHeroApp extends Application {
//
//    private static final String BACKGROUND_MUSIC = "";
//    private StartScreen sc;
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//
//    @Override
//    public void start(Stage primarystage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(StickHeroApp.class.getResource("hello-view.fxml"));
//        Parent root = fxmlLoader.load();
//        Object controller = fxmlLoader.getController(); // Corrected variable name
//        Scene scene = new Scene(root);
//        primarystage.setTitle("Stick Hero Game(Invisible Button to increase stick press on or above character )");
//        primarystage.setScene(scene);
//        primarystage.show();
//    }





//    public static void main(String[] args) {
//        launch();
//    }


//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Stick Hero");
//        Button startButton = new Button("Start Game");
//        startButton.setOnAction(event->StartingGame());
//        Scene startScene;
//        startScene=new Scene(startButton,300,200);
//        primaryStage.setScene(startScene);
//        //For BONUS _USING THREADS
//        Thread musicThread = new Thread(() -> playBackgroundMusic());
//        musicThread.start();
//        primaryStage.show();
//
//
//
//    }
//
//    private void playBackgroundMusic() {
////        MediaPlayer music=new MediaPlayer(new Media(new File(BACKGROUND_MUSIC).toURI().tostring()));
////
////        music.setCycleCount(music.INDEFINITE);
////        music.play();
//
//    }
//
//    private void StartingGame(){
//        StickHeroGame stickherogame=new StickHeroGame();
////        Scene gamescene=new Scene(sc ,800,600);
////        primaryStage.setScene(gameScene);
//
//
//
//
//    }
//
////    private void playGameAnimation() {
////
////
////    }
//
//}
