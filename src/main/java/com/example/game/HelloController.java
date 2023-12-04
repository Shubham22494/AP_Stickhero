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
import java.util.Random;

public class HelloController {
    double lenght;
    @FXML
    private Rectangle stick;
    @FXML
    private Rectangle pillar1;
    @FXML
    private Rectangle pillar2;
    @FXML
    private Rectangle pillar3;
    @FXML
    private Rectangle pillar4;
    @FXML
    private Rectangle pillar5;
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
        double x1 = pillar1.getLayoutX();
        double x2 = pillar2.getLayoutX();
        double x3 = pillar3.getLayoutX();
        double x4 = pillar4.getLayoutX();
        double x5 =pillar5.getLayoutX();

        //pillar5.setLayoutX(x1);

        double distanceToMove = (x2 - x1);
//        TranslateTransition translate1 = new TranslateTransition(Duration.seconds(1), pillar1);
//        translate1.setToX(-2000);
//        translate1.setCycleCount(1);
//        translate1.play();
        pillar1.setVisible(false);

        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(0.5), pillar2);
        translate2.setToX(-distanceToMove);
        translate2.setCycleCount(1);
        translate2.play();

        TranslateTransition translate3 = new TranslateTransition(Duration.seconds(0.5), pillar3);
        translate3.setToX(-distanceToMove);
        translate3.setCycleCount(1);
        translate3.play();

        TranslateTransition translate4 = new TranslateTransition(Duration.seconds(0.5), pillar4);
        translate4.setToX(-distanceToMove);
        translate4.setCycleCount(1);
        translate4.play();

        TranslateTransition translate5 = new TranslateTransition(Duration.seconds(0.5), pillar5);
        translate5.setToX(-distanceToMove);
        translate5.setCycleCount(1);
        translate5.play();

        // Generate a new width for the next pillar
        double newPillarWidth = generateRandomPillarWidth();
        pillar4=pillar3;
        pillar3=pillar2;
        pillar2=pillar1;



        pillar5.setWidth(newPillarWidth);
        pillar5.setVisible(true);
        pillar5.setTranslateX(x5);
    }


    private void animateCartoonCharacter() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
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
            stick.setTranslateX(pillar1.getLayoutX()+6);
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
    private double generateRandomPillarWidth() {
        Random random = new Random();
        return random.nextDouble() * 50 + 50; // Random width between 50 and 100
    }

}
