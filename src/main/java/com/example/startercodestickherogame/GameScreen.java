package com.example.startercodestickherogame;

//public class GameScreen implements Updatable{
//    private StickHeroGame stickHeroGame;  // Composition
//
////    public GameScreen(StickHeroGame stickHeroGame) {
////        this.stickHeroGame = stickHeroGame;
////
////    }
//    public GameScreen(StickHeroEngine engine, StickHeroController controller) {
//        this.stickHeroGame = stickHeroGame;
//    }
//
//    public void show() {
//
//    }
//    @Override
//    public void updateGame() {
//
//    }
//
//    public void handleInput() {
//
//    }
//
//    public void startGame() {
//
//        show();
//    }
//}
// GameScreen.java
//package com.example.startercodestickherogame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameScreen extends Node implements Updatable {
    private StickHeroApp stickHeroApp;

    public GameScreen(StickHeroApp stickHeroApp) {
        this.stickHeroApp = stickHeroApp;
    }

    public void showGameScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("game_screen.fxml"));
            Parent root = loader.load();
//            GameScreenController controller = loader.getController();
//            controller.setGameScreen(this);

//            Stage stage = stickHeroApp.getPrimaryStage();
//            stage.setScene(new Scene(root));
//            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGame() {

    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
