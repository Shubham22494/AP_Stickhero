package com.example.startercodestickherogame;



// StartScreen.java
//package com.example.startercodestickherogame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


class StartScreen {

    private StickHeroApp stickHeroApp;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private Stage primaryStage;

    public StartScreen(StickHeroApp stickHeroApp) {
//            this.stickHeroApp = stickHeroApp;
        this.primaryStage = new Stage();
    }

    public void show() {
        try {
            showTutorial();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("startscreen.fxml"));
            Parent root = loader.load();
            StickHeroController controller = loader.getController();
            //controller.setStartScreen(this);

            Scene scene = new Scene(root);
            primaryStage.setTitle("StickHeroGame");
            Image icon =new Image("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\resources\\com\\example\\startercodestickherogame\\cartoonicon.png");
            primaryStage.getIcons().add(icon);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//        public void playWithPlayerName() {
//            // Implement logic to start the game with a specific player name.
//        }

    public void showTutorial() {
        System.out.println("Stick Hero Game Quick Guide:\n" +
                "1. Start Game:\n" +
                "\n" +
                "Launch the Stick Hero game and select \"Play\" on the Start Screen.\n" +
                "2. Gameplay Basics:\n" +
                "\n" +
                "Control a character with a stick.\n" +
                " click for  extending the stick.\n" +
                "3. Cross Platforms:\n" +
                "\n" +
                "Navigate platforms with gaps.\n" +
                "Adjust stick length to cross safely.\n" +
                "4. Score Points:\n" +
                "\n" +
                "Collect cherries for extra points.\n" +
                "Score based on successful crossings.\n" +
                "5. Game Over and Restart:\n" +
                "\n" +
                "Falling ends the game.\n" +
                "View Game Over screen for score.\n" +
                "Choose to restart or return to the main menu.");

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}