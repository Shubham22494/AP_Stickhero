package com.example.startercodestickherogame;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverScreen extends Node {
    int finalsc=0;
    private Stage stagee;
    //private GameOverScreen gamee;
    private StickHeroGame stickHeroGame;  // Composition
    public GameOverScreen(int score) {
//        this.stickHeroGame = stickHeroGame;
        this.finalsc=score;


    }
    public void display() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(StickHeroApp.class.getResource("GameOverScreen.fxml"));
        Parent root = fxmlLoader.load();
        StickHeroController gamee= fxmlLoader.getController();
        //controller.generatePillars();// Corrected variable name
        //controller.generateCherries();
        Image icon =new Image("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\resources\\com\\example\\startercodestickherogame\\cartoonicon.png");
        stagee.getIcons().add(icon);
        Scene scene = new Scene(root);
        stagee.setTitle("Stick Hero Game");
        stagee.setScene(scene);
        stagee.show();

    }




    public void displayGameOver(int score) {

     //inner class
    class ShareResults {
        public void displayShareResultsStage() {
            System.out.println("");
        }

        }
    }

    public void shareResults() {

    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

