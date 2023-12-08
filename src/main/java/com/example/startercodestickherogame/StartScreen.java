package com.example.startercodestickherogame;



// StartScreen.java
//package com.example.startercodestickherogame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreen extends Application {
    private StickHeroApp stickHeroApp;

//    public StartScreen(StickHeroApp stickHeroApp) {
//        this.stickHeroApp = stickHeroApp;
//    }

    public static void main(String[] args) {
        launch();
    }

//    public void show(){}
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startscreen.fxml"));
            Parent root = loader.load();
            StickHeroController controller = loader.getController();
//            controller.setStartScreen(this);
//            Stage stage = stickHeroApp.getPrimaryStage();
            Scene scene = new Scene(root);
            stage.setTitle("Start Screen For StickHeroGame");
            stage.setScene(scene);
            stage.show();

//            Stage stage = stickHeroApp.getPrimaryStage();
//            stage.setScene(new Scene(root));
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void playAsDefaultPlayer() {
//        showPlayerSetupScreen(null);
//    }

    public void playWithPlayerName() {
//        showPlayerSetupScreen(new Player());
    }

//    private void showPlayerSetupScreen(Player player) {
////        PlayerSetupScreen playerSetupScreen = new PlayerSetupScreen(stickHeroApp, player);
////        playerSetupScreen.displaySetupScreen();
//    }

    class Tutorial{
        public void Tutorial() throws IOException {
            System.out.println("Instructions on how to play this Game");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startscreen_tut.fxml"));
            Parent root = loader.load();
            StickHeroController controller = loader.getController();
//            controller.setStartScreen(this);
////            Stage stage = stickHeroApp.getPrimaryStage();
//            Scene scene = new Scene(root);
//            stage.setTitle("Tut on how to play StickHeroGame");
//            stage.setScene(scene);
//            stage.show();

        }
    }
}

//public class StartScreen {
//    private StickHeroGame game; //composition
//
//    public StartScreen(StickHeroGame game) {
//        this.game = game;
//    }
//
//
//
//    public void show() {
//
//        game.showGameScreen();
//    }
//
//    public void startButtonClicked() {
//
//    }
//
//   //ineer class
//    class Tutorial {
//        public void specificLogic() {
//
//        }
//    }
//}
