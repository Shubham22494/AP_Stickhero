//package com.example.startercodestickherogame;
//
////public class GameScreen implements Updatable{
////    private StickHeroGame stickHeroGame;  // Composition
////
//////    public GameScreen(StickHeroGame stickHeroGame) {
//////        this.stickHeroGame = stickHeroGame;
//////
//////    }
////    public GameScreen(StickHeroEngine engine, StickHeroController controller) {
////        this.stickHeroGame = stickHeroGame;
////    }
////
////    public void show() {
////
////    }
////    @Override
////    public void updateGame() {
////
////    }
////
////    public void handleInput() {
////
////    }
////
////    public void startGame() {
////
////        show();
////    }
////}
//// GameScreen.java
////package com.example.startercodestickherogame;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class GameScreen extends Node implements Updatable {
//    private StickHeroApp stickHeroApp;
//
//    public GameScreen(StickHeroApp stickHeroApp) {
//        this.stickHeroApp = stickHeroApp;
//    }
//
//    public void showGameScreen() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("game_screen.fxml"));
//            Parent root = loader.load();
////            GameScreenController controller = loader.getController();
////            controller.setGameScreen(this);
//
////            Stage stage = stickHeroApp.getPrimaryStage();
////            stage.setScene(new Scene(root));
////            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void updateGame() {
//
//    }
//
//    @Override
//    public Node getStyleableNode() {
//        return super.getStyleableNode();
//    }
//}




package com.example.startercodestickherogame;



import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class GameScreen extends Node implements Updatable{

    private StickHeroApp stickHeroApp;
    private StickHeroEngine engine=new StickHeroEngine();
    private StickHeroController controller;

    public void setCherryCount(int cherryCount) {
        CherryCount = cherryCount;
    }

    private int CherryCount;
//    private Label sc

    public int getCherryCount() {
        return CherryCount;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private int score;

    public GameScreen(StickHeroApp stickHeroApp) {
        this.stickHeroApp = stickHeroApp;
    }

    public void show(Stage stage) throws Exception {
        // Initialize game elements


        // Load FXML file and controller
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hi.fxml"));
        Parent root = fxmlLoader.load();
        StickHeroController controller = fxmlLoader.getController();
        controller.generatePillars();// Corrected variable name
        controller.generateCherries();

        // Set stage and scene
        Scene scene = new Scene(root);
        stage.setTitle("Stick Hero Game");
        stage.setScene(scene);

        // Pass stick hero app to controller
//        controller.setStickHeroApp(stickHeroApp);

        // Show game screen
        stage.show();
    }

    @Override
    public void updateGame(){

    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

//    public void setCherryCount(Label cherrycount) {
//        this.CherryCount=cherrycount;
//    }


//    public void handleInput(String input) {
//        engine.handleInput(input);
//    }
    // Generate game elements

}
//import java.io.IOException;
//
//public class GameScreen extends Node implements Updatable {
//    private StickHeroApp stickHeroApp;
//
//    public GameScreen(StickHeroApp stickHeroApp) {
//        this.stickHeroApp = stickHeroApp;
//    }
//
//    public void showGameScreen() {
//        try {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("game_screen.fxml"));
//            Parent root = loader.load();
////            GameScreenController controller = loader.getController();
////            controller.setGameScreen(this);
//
////            Stage stage = stickHeroApp.getPrimaryStage();
////            stage.setScene(new Scene(root));
////            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void updateGame() {
//
//    }
//
//    @Override
//    public Node getStyleableNode() {
//        return super.getStyleableNode();
//    }
//}