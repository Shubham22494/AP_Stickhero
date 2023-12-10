//package com.example.startercodestickherogame;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.image.Image;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class GameOverScreen extends Node {
//    int finalsc=0;
//    private Stage stagee;
//    //private GameOverScreen gamee;
//    private StickHeroGame stickHeroGame;  // Composition
//    public GameOverScreen(int score) {
////        this.stickHeroGame = stickHeroGame;
//        this.finalsc=score;
//
//
//    }
//    public void display() throws IOException {
//
//        FXMLLoader fxmlLoader = new FXMLLoader(StickHeroApp.class.getResource("GameOverScreen.fxml"));
//        Parent root = fxmlLoader.load();
//        StickHeroController gamee= fxmlLoader.getController();
//        //controller.generatePillars();// Corrected variable name
//        //controller.generateCherries();
//        Image icon =new Image("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\resources\\com\\example\\startercodestickherogame\\cartoonicon.png");
//        stagee.getIcons().add(icon);
//        Scene scene = new Scene(root);
//        stagee.setTitle("Stick Hero Game");
//        stagee.setScene(scene);
//        stagee.show();
//
//    }
//
//
//
//
//    public void displayGameOver(int score) {
//
//     //inner class
//    class ShareResults {
//        public void displayShareResultsStage() {
//            System.out.println("");
//        }
//
//        }
//    }
//
//    public void shareResults() {
//
//    }
//
//    @Override
//    public Node getStyleableNode() {
//        return super.getStyleableNode();
//    }
//}


package com.example.startercodestickherogame;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverScreen extends Node {
    private StickHeroApp stickHeroApp;  // Composition
    public GameOverScreen(StickHeroApp stickHeroGame) {
        this.stickHeroApp = stickHeroGame;

    }
    @FXML
    public Label gamescore;

    public void show(Stage stage) throws Exception {
        //gamescore.setText("5");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameOverScreen.fxml"));
        Parent root = fxmlLoader.load();
        StickHeroController controller = fxmlLoader.getController();




        // Set stage and scene
        Scene scene = new Scene(root);
        stage.setTitle("Stick Hero Game");
        stage.setScene(scene);

        // Pass stick hero app to controller
//        controller.setStickHeroApp(stickHeroApp);

        // Show game screen
        stage.show();
    }
    public void displayGameOver(int score) {

        //inner class
        class ShareResults {
            public void displayShareResultsStage() {
                System.out.println("");
            }

        }
    }

    public void updateGame(int cherrycount, int score) {
        try {
            // Load FXML file and controller for GameScreen
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
            Parent root = fxmlLoader.load();
            GameScreen gameScreen = fxmlLoader.getController();

            // Set the previous cherry and score values
            gameScreen.setCherryCount(cherrycount);
            gameScreen.setScore(score);

            // Create a new stage and scene
            Stage newStage = new Stage();
            Scene scene = new Scene(root);

            // Set the stage title and scene
            newStage.setTitle("Stick Hero Game");
            newStage.setScene(scene);

            // Show the game screen
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reviveCharacter(StickHeroController stickHeroController) {
        // Check if there are enough cherries for revival
        int prevCherryCount = stickHeroController.getCherryCount();
        if (prevCherryCount >= 2) {
            // Subtract 2 cherries for revival
            prevCherryCount -= 2;

            // Update the game after revival using the StickHeroController
            updateGame(stickHeroController.getCherryCount(), stickHeroController.getScore());

            // Close the game over screen or perform other necessary actions
            closeGameOverScreen();
        } else {
            // Handle not enough cherries scenario (e.g., display a message)
            System.out.println("Not enough cherries to revive!");
        }
    }

    private void closeGameOverScreen() {
        System.out.println("game is over!");
    }

//    public void shareResults() {
//
//    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
