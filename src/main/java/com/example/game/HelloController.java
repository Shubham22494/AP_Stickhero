package com.example.game;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.Random;

public class HelloController {
    double gap;

    double lenght;
    @FXML
    private Rectangle stick;
    @FXML
    private Label score;
    int currscore;

    //@FXML
    //private Font score;
//    @FXML
//    private Rectangle pillar1;
//    @FXML
//    private Rectangle pillar2;
//    @FXML
//    private Rectangle pillar3;
//    @FXML
//    private Rectangle pillar4;
//    @FXML
//    private Rectangle pillar5;
    @FXML
    private ImageView cartoonCharacter;
    //double ycord=stick.getTranslateY();
    @FXML
    private AnchorPane gamePane;

    int pillarcount=0;
    Rectangle[] rectangles = new Rectangle[2000];
    public void generatePillars() {
        //gamePane.getChildren().removeIf(node -> node instanceof Group);

        // Rectangle[] rectangles = new Rectangle[2000];
        double xPosition = 0.0;
        double gapWidth = 250;
        Group G1 = new Group();

        for (int i = 0; i < 2000; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setWidth(Math.random() * 50 + 50);
            rectangles[i].setHeight(213);
            rectangles[i].setLayoutY(381);
            rectangles[i].setLayoutX(xPosition);

            xPosition += gapWidth; // Adjust the gap width as needed
            G1.getChildren().add(rectangles[i]);
        }

        // Add generated pillars to the gamePane
        gamePane.getChildren().add(G1);


    }


    private boolean buttonPressed = false;
    protected void gapdecide(){
        gap=136;
    }
    @FXML
    protected void incresestickPressed(MouseEvent eve) {

        buttonPressed = true;
        incresestick();
    }

    @FXML
    protected void incresestickReleased(MouseEvent ee) {
        buttonPressed = false;
        gapdecide();
        incresestick();
    }
    private void fallDownCartoonCharacter() {

        // For example, you can use a separate TranslateTransition to move the character downwards
        TranslateTransition fallTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
        fallTransition.setByY(200); // Adjust the Y distance as needed
        fallTransition.play();
    }
    @FXML
    protected void incresestick() {
        if (buttonPressed) {
            increaseStick();
        }
        else{
            //stick.setLayoutY(379.0);
            rotate();
        }
    }
    protected void resetStickTranslation(){
        stick.setTranslateX(0);
        stick.setTranslateY(0);
    }
    @FXML
    protected void rotate() {
        //resetStickTranslation();
        stick.setRotate(0);
//        System.out.println(stick.getHeight());
//        System.out.println(stick.getTranslateX()+"    "+stick.getTranslateY());
        stick.setTranslateY(stick.getHeight() /2.0);
        stick.setTranslateX(stick.getHeight() / 2.0);
        // System.out.println(stick.getTranslateX()+"    "+stick.getTranslateY());
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(0.2), stick);
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
        addDelay(0.001); // You can adjust the duration as needed
    }
    private void reposition(){
        double distanceToMove = -250;
        for (Rectangle pillar : rectangles) {
            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), pillar);
            translate.setByX(distanceToMove);
            translate.setCycleCount(1);
            translate.play();
        }
        pillarcount+=1;

    }
    private void animateCartoonCharacter() {
        //System.out.println(stick.getLayoutX());
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
        double x=cartoonCharacter.getLayoutX();
        //System.out.println(x);


        if (lenght < (rectangles[pillarcount+1].getLayoutX() - (rectangles[pillarcount].getLayoutX() + rectangles[pillarcount].getWidth())) || lenght>(rectangles[pillarcount+1].getLayoutX()+ rectangles[pillarcount+1].getWidth() - (rectangles[pillarcount].getLayoutX() + rectangles[pillarcount].getWidth()))) {
            translateTransition.setByX(stick.getHeight()+15);
//            translateTransition.setByY(200);
            translateTransition.setOnFinished(event -> {
                fallDownCartoonCharacter();
            });

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
        translate.setToX(x+rectangles[pillarcount].getWidth()/2-6);
        translate.setCycleCount(1);
        double ycord=stick.getHeight();

        // Set an event handler to be executed after the translation is finished
        translate.setOnFinished(event -> {
            // Decrease the stick's height to zero
            double ht=stick.getHeight();
            stick.setHeight(0);
            double xx= stick.getLayoutX();
            //System.out.println(xx);
            // Rotate the stick by -90 degrees
            stick.setRotate(0);
            stick.setTranslateY(0);
            stick.setLayoutY(379.0);
            stick.setLayoutX(0.0+rectangles[pillarcount].getWidth()/2);
            System.out.println((-50+rectangles[pillarcount].getWidth()-10)+"  "+ (0.0+rectangles[pillarcount].getWidth()/2));
            stick.setTranslateX(-50+rectangles[pillarcount].getWidth()-10);

        });

        // Start the translation animation
        translate.play();
        currscore++;
        score.setText(Integer.toString(currscore));

    }





    private void addDelay(double seconds) {
        //System.out.println(stick.getLayoutX()+" "+stick.getLayoutY());

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
