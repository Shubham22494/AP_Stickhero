package com.example.startercodestickherogame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.animation.RotateTransition;
import javafx.util.Duration;

public class StickHeroController {
    @FXML

    private Rectangle stick;
    private StickHeroGame stickHeroGame;  // Composition

    public StickHeroController() {
        this.stickHeroGame = stickHeroGame;
    }



    public void processInput() {
    }

    @FXML
    protected void increaseStickLength(ActionEvent e) {
        double currentHeight = stick.getHeight();
        double newHeight = currentHeight + 10.0;

        // Adjust the layoutY to maintain the bottom anchor point
        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));

        // Increase the stick height
        stick.setHeight(newHeight);
    }
}