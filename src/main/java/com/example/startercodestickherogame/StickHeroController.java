package com.example.startercodestickherogame;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class StickHeroController {

    @FXML
    private Rectangle stick;
    private double inc_rate = 50.0; // Adjust the increase rate as needed
    private Timeline press;
    private long startTime;

    @FXML
    protected void startPressTime(MouseEvent event) {
        startTime = System.currentTimeMillis();
        press = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> increaseStickLength()));
        press.setCycleCount(Timeline.INDEFINITE);
        press.play();
    }

    @FXML
    protected void stopPressTime(MouseEvent event) {
        if (press != null) {
            press.stop();
        }
    }

    private void increaseStickLength() {
        // Calculate the time difference in seconds
        double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;

        // Increase the stick length based on the rate and elapsed time
        stick.setHeight(stick.getHeight() + inc_rate * elapsedTime);
    }

    // Other methods...
}

//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.SequentialTransition;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.shape.Rectangle;
//import javafx.animation.RotateTransition;
//import javafx.util.Duration;
//
//
//
//import javafx.animation.*;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.input.KeyCode;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.shape.Rectangle;
//import javafx.util.Duration;
//
//
////import javax.swing.*;
//
//public class StickHeroController {
//    @FXML
//
//
//    private Rectangle stick;
//    private double inc_rate = 50.0; // Adjust the increase rate as needed
//    private Timeline press;
//    private long startTime;
//
////    @FXML
////    protected void onHelloButtonClick() {
////        welcomeText.setText("Welcome to JavaFX Application!");
////    }
//
//
//    @FXML
//    protected void increaseStickLength(ActionEvent e) {
//        double currentHeight = stick.getHeight();
//        double newHeight = currentHeight + 10.0;
//
//        // Adjust the layoutY to maintain the bottom anchor point
//        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));
//
//        // Increase the stick height
//        stick.setHeight(newHeight);
//    }
//
//
//    @FXML
//    protected void increase_Stick_Length() {
//        // Calculate the time difference in seconds
//        double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
//
//        // Increase the stick length based on the rate and elapsed time
//        stick.setHeight(stick.getHeight() + inc_rate * elapsedTime);
//    }
//
//    private void start_press_time() {
//        startTime = System.currentTimeMillis();
//        press = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> increase_Stick_Length()));
//        press.setCycleCount(Timeline.INDEFINITE);
//        press.play();
//    }
//
//    private void stop_press_time() {
//        if (press != null) {
//            press.stop();
//        }
//    }
//
//    @FXML
//    protected void handleKeyPress(KeyEvent event) {
//
//        if (event.getCode() == KeyCode.UP) {
//            start_press_time();
//        }
//    }
//
//    @FXML
//    protected void handleKeyReleased(KeyEvent event) {
//
//        if (event.getCode() == KeyCode.UP) {
//            stop_press_time();
//        }
//    }
//}


