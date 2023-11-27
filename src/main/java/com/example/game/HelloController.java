package com.example.game;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HelloController {
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
        translateTransition.setByX(stick.getHeight());
        translateTransition.setCycleCount(1);
        translateTransition.play();
        if(lenght>=(pillar2.getX()-pillar1.getX())){
            translateTransition.setByX(pillar2.getX());
            translateTransition.play();
        }
        else{
            translateTransition.setByY(0);
            translateTransition.play();
        }

    }

    private void addDelay(double seconds) {
        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
        delay.setOnFinished(event -> {
            if (buttonPressed) {
                increaseStick(); // Continue increasing only if the button is still pressed
            }
        });
        delay.play();
    }

}
