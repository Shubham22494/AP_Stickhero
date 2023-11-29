package com.example.startercodestickherogame;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class StickHeroController {
    double lenght;
    @FXML
    private Rectangle stick;
    @FXML
    private Rectangle pillar1;
    @FXML
    private Rectangle pillar2;
    @FXML
    private ImageView cartoonCharacter;

    private boolean buttonPressed = false;

    @FXML
    protected void incresestickPressed(MouseEvent eve) {
        buttonPressed = true;
        incresestick();
    }

    @FXML
    protected void incresestickReleased(MouseEvent ee) {
        buttonPressed = false;
        incresestick();
    }

    @FXML
    protected void incresestick() {
        if (buttonPressed) {
            increaseStick();
        }
        else{
            rotate();
        }
    }

    @FXML
    protected void rotate() {
        stick.setRotate(0);
        stick.setTranslateY(stick.getHeight() / 2.0);
        stick.setTranslateX(stick.getHeight() / 2.0);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), stick);
        rotateTransition.setByAngle(90);
        rotateTransition.play();
        animateCartoonCharacter();
    }

    private void increaseStick() {
        double currentHeight = stick.getHeight();
        double newHeight = currentHeight + 1.0;
        lenght+=1.0;
        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));
        stick.setHeight(newHeight);

        // Add a pause to control the speed of height increase
        addDelay(0.02); // You can adjust the duration as needed
    }
    private void animateCartoonCharacter() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), cartoonCharacter);

        // Check if the stick length is more than the gap between pillars
        double gapBetweenPillars = pillar2.getX() - pillar1.getX() + pillar1.getWidth();

        if (lenght >= gapBetweenPillars) {
            // Move character to the end of pillar 2
            double characterEndX = pillar2.getX() + pillar2.getWidth() ;
            translateTransition.setToX(characterEndX);
        } else {
            // Move character based on stick length and then fall down
            double characterMoveX = stick.getLayoutX() + stick.getWidth() ; // Adjust as needed
            translateTransition.setByX(characterMoveX);
            // Add an event handler to handle falling animation if stick length is less than the gap
            translateTransition.setOnFinished(event -> {
                if (lenght < gapBetweenPillars) {
                    fallDownCartoonCharacter();
                }
            });
//            translateTransition.setOnFinished(event -> {
//                cartoonCharacter.setTranslateY(0); // Reset translateY
//                cartoonCharacter.setTranslateX(0); // Reset translateX
//                cartoonCharacter.setRotate(0); // Reset rotation
//            });
        }

        translateTransition.play();
    }

    private void fallDownCartoonCharacter() {
        // Implement falling animation or logic here
        // For example, you can use a separate TranslateTransition to move the character downwards
        TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
        fallTransition.setByY(200); // Adjust the Y distance as needed
        fallTransition.play();
    }

    private void setStartScreen(){

    }

//    private void animateCartoonCharacter() {
//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), cartoonCharacter);
//
//        // Check if the stick length is more than the gap between pillars
//        double gapBetweenPillars = pillar2.getX() - (pillar1.getX() + pillar1.getWidth());
//
//        if (lenght >= gapBetweenPillars) {
//            // Move character to the end of pillar 2
//            double characterEndX = pillar2.getX() - cartoonCharacter.getFitWidth();
//            translateTransition.setToX(characterEndX);
//        } else {
//            // Move character based on stick length and then fall down
//            double characterMoveX = stick.getLayoutX() + stick.getWidth(); // Adjust as needed
//            translateTransition.setByX(characterMoveX);
//            translateTransition.setOnFinished(event -> {
//                cartoonCharacter.setTranslateY(0); // Reset translateY
//                cartoonCharacter.setTranslateX(0); // Reset translateX
//                cartoonCharacter.setRotate(0); // Reset rotation
//            });
//        }
//
//        translateTransition.play();
//    }

        private void addDelay(double seconds) {
        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
        delay.setOnFinished(event -> {
            if (buttonPressed) {
                increaseStick(); // Continue increasing only if the button is still pressed
            }
        });
        delay.play();
    }
    private void addFallDelay(double seconds) {
        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
        delay.setOnFinished(event -> {
            // Fall down animation
            TranslateTransition fallDownTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
            fallDownTransition.setByY(300); // Adjust the fall distance as needed
            fallDownTransition.play();
        });
        delay.play();
    }


//    private void animateCartoonCharacter() {
//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), cartoonCharacter);
//        translateTransition.setByX(stick.getHeight());
//        translateTransition.setCycleCount(1);
//        translateTransition.play();
//        if(lenght>=(pillar2.getX()-pillar1.getX())){
//            translateTransition.setByX(pillar2.getX());
//            translateTransition.play();
//        }
//        else{
//            translateTransition.setByY(0);
//            translateTransition.play();
//        }
//
//    }

//    private void addDelay(double seconds) {
//        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
//        delay.setOnFinished(event -> {
//            if (buttonPressed) {
//                increaseStick(); // Continue increasing only if the button is still pressed
//            }
//        });
//        delay.play();
//    }

}
//package com.example.startercodestickherogame;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.shape.Rectangle;
//import javafx.util.Duration;
//
//public class StickHeroController {
//
//    @FXML
//    private Rectangle stick;
//    private double inc_rate = 50.0; // Adjust the increase rate as needed
//    private Timeline press;
//    private long startTime;
//
//    @FXML
//    protected void startPressTime(MouseEvent event) {
//        startTime = System.currentTimeMillis();
//        press = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> increaseStickLength()));
//        press.setCycleCount(Timeline.INDEFINITE);
//        press.play();
//    }
//
//    @FXML
//    protected void stopPressTime(MouseEvent event) {
//        if (press != null) {
//            press.stop();
//        }
//    }
//
//    private void increaseStickLength() {
//        // Calculate the time difference in seconds
//        double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;
//
//        // Increase the stick length based on the rate and elapsed time
//        stick.setHeight(stick.getHeight() + inc_rate * elapsedTime);
//    }
//
//    // Other methods...
//}

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


