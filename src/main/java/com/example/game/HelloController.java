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
    //double ycord=stick.getTranslateY();


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
    protected void resetStickTranslation(){
        stick.setTranslateX(0);
        stick.setTranslateY(0);
    }
    @FXML
    protected void rotate() {
        resetStickTranslation();
        stick.setRotate(0);
        System.out.println(stick.getHeight());
        System.out.println(stick.getTranslateX()+"    "+stick.getTranslateY());
        stick.setTranslateY(stick.getHeight() / 2.0);
        stick.setTranslateX(stick.getHeight() / 2.0);
        System.out.println(stick.getTranslateX()+"    "+stick.getTranslateY());
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), stick);
        rotateTransition.setByAngle(90);
        rotateTransition.play();
        animateCartoonCharacter();
    }

    private void increaseStick() {
        double currentHeight = stick.getHeight();
        double newHeight = currentHeight + 1.0;
        lenght=newHeight;
        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));
        stick.setHeight(newHeight);

        // Add a pause to control the speed of height increase
        addDelay(0.02); // You can adjust the duration as needed
    }
    private void reposition() {
        double x=pillar1.getX();
        System.out.println(x);
        double xx=pillar2.getLayoutX();
        System.out.println(xx);
        pillar2.setLayoutX(x);

        double y=pillar1.getLayoutY();
        // Calculate the distance to move pillar2 back to its initial position
        double distanceToMove =(pillar2.getLayoutX()- pillar1.getLayoutX() );

        // Create a TranslateTransition to move pillar2 to the position of pillar1
        TranslateTransition translate = new TranslateTransition(Duration.seconds(1), pillar2);
        //translate.setByX(-distanceToMove); // Move to the left (negative distance)
        translate.setToX(x);
        translate.setCycleCount(1);
        translate.play();
//        pillar2.setLayoutY(y);
//        pillar2.setLayoutX(x);
        // Remove pillar1 from the scene
        pillar1.setVisible(false);
        pillar1.setManaged(false);
    }

    private void animateCartoonCharacter() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), cartoonCharacter);
        double x=cartoonCharacter.getLayoutX();
        //System.out.println(x);


        if (lenght < (pillar2.getLayoutX() - (pillar1.getLayoutX() + pillar1.getWidth())) || lenght>(pillar2.getLayoutX()+ pillar2.getWidth() - (pillar1.getLayoutX() + pillar1.getWidth()))) {
            translateTransition.setByX(stick.getHeight());
            translateTransition.setByY(200);

        } else {
            translateTransition.setByX(stick.getHeight());
            //double xx=cartoonCharacter.getLayoutX();
            //System.out.println(xx);

            translateTransition.setOnFinished(event -> {
                reposition();
                //cartoonCharacter.setLayoutX(x);
                moveCartoonToEnd();
            });
        }

        translateTransition.setCycleCount(1);
        translateTransition.play();
    }

    private void moveCartoonToEnd() {
        // Calculate the distance to move the cartoon character to the end of pillar2
        //double distanceToMove = pillar2.getLayoutX() - pillar2.getWidth();
        double distanceToMove = stick.getHeight()-8;
        double x=cartoonCharacter.getLayoutX();
        //System.out.println(x);

        // Create a TranslateTransition to move the cartoon character to the end of pillar2
        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), cartoonCharacter);
        translate.setToX(x+pillar2.getWidth()/2-6);
        translate.setCycleCount(1);
        double ycord=stick.getHeight();

        // Set an event handler to be executed after the translation is finished
        translate.setOnFinished(event -> {
            // Decrease the stick's height to zero
            stick.setHeight(0);
            double xx= stick.getLayoutX();
            System.out.println(xx);
            // Rotate the stick by -90 degrees
            stick.setRotate(0);
            stick.setTranslateY(ycord);
            stick.setTranslateX(pillar1.getLayoutX()+5);
        });

        // Start the translation animation
        translate.play();
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
