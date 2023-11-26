package com.example.game;


import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Rectangle stick;
    @FXML
    private ImageView cartoonCharacter;

    @FXML
    protected void incresestick(ActionEvent event) {
        handleStickChange();
    }

    @FXML
    protected void incresestick(MouseEvent event) {
        handleStickChange();
    }
    @FXML
    protected void rotate(MouseEvent e){
        stick.setRotate(0);
        stick.setTranslateY(stick.getHeight()/2.0);  // Adjust the translation
        stick.setTranslateX(stick.getHeight()/2.0 );
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), stick);
        rotateTransition.setByAngle(90);
        rotateTransition.play();
        animateCartoonCharacter();

    }
    private void handleStickChange() {
        double currentHeight = stick.getHeight();
        double newHeight = currentHeight + 10.0;

        // Adjust the layoutY to maintain the bottom anchor point
        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));

        // Increase the stick height
        stick.setHeight(newHeight);
    }
    private void animateCartoonCharacter() {
        // Create a TranslateTransition for the cartoon character
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), cartoonCharacter);

        // Set the movement along the X-axis
        translateTransition.setByX(stick.getHeight());

        // Set the cycle count to indefinite for continuous animation
        translateTransition.setCycleCount(1);

        // Set auto-reverse to true for back-and-forth movement
//        translateTransition.setAutoReverse(true);

        // Start the animation
        translateTransition.play();
    }
}
