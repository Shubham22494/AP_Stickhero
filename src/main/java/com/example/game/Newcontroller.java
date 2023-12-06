//package com.example.game;
//
//import javafx.animation.PauseTransition;
//import javafx.animation.TranslateTransition;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.shape.Rectangle;
//import javafx.util.Duration;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class HelloController {
//    private double gap;
//    private double length;
//
//    @FXML
//    private Rectangle stick;
//    @FXML
//    private ImageView cartoonCharacter;
//    private List<Rectangle> pillars = new ArrayList<>();
//
//    private boolean buttonPressed = false;
//
//    @FXML
//    protected void initialize() {
//        gap = 136;
//        createPillars();
//    }
//
//    private void createPillars() {
//        double pillarX = 54.0;
//        for (int i = 0; i < 5; i++) {
//            Rectangle pillar = new Rectangle(pillarX, 381.0, generateRandomPillarWidth(), 213.0);
//            pillar.setArcWidth(5.0);
//            pillar.setArcHeight(5.0);
//            pillar.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
//            pillar.setStroke(javafx.scene.paint.Color.BLACK);
//            pillar.setOpacity(0.82);
//
//            pillars.add(pillar);
//            pillarX += gap;
//        }
//    }
//
//    @FXML
//    protected void incresestickPressed(MouseEvent event) {
//        buttonPressed = true;
//        incresestick();
//    }
//
//    @FXML
//    protected void incresestickReleased(MouseEvent event) {
//        buttonPressed = false;
//        incresestick();
//    }
//
//    @FXML
//    protected void incresestick() {
//        if (buttonPressed) {
//            increaseStick();
//        } else {
//            rotate();
//        }
//    }
//
//    private void increaseStick() {
//        double currentHeight = stick.getHeight();
//        double newHeight = currentHeight + 1.0;
//        length = newHeight;
//        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));
//        stick.setHeight(newHeight);
//
//        addDelay(0.002); // You can adjust the duration as needed
//    }
//
//    @FXML
//    protected void rotate() {
//        resetStickTranslation();
//        stick.setRotate(0);
//        stick.setTranslateY(stick.getHeight() / 2.0);
//        stick.setTranslateX(stick.getHeight() / 2.0);
//        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), stick);
//        rotateTransition.setByAngle(90);
//        rotateTransition.play();
//        animateCartoonCharacter();
//    }
//
//    private void resetStickTranslation() {
//        stick.setTranslateX(0);
//        stick.setTranslateY(0);
//    }
//
//    private void animateCartoonCharacter() {
//        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
//        double x = cartoonCharacter.getLayoutX();
//
//        if (length < (pillars.get(1).getLayoutX() - (pillars.get(0).getLayoutX() + pillars.get(0).getWidth()))
//                || length > (pillars.get(1).getLayoutX() + pillars.get(1).getWidth()
//                - (pillars.get(0).getLayoutX() + pillars.get(0).getWidth()))) {
//            translateTransition.setByX(stick.getHeight());
//            translateTransition.setByY(200);
//        } else {
//            translateTransition.setByX(stick.getHeight());
//            translateTransition.setOnFinished(event -> {
//                reposition();
//                moveCartoonToEnd();
//            });
//        }
//
//        translateTransition.setCycleCount(1);
//        translateTransition.play();
//    }
//
//    private void reposition() {
//        for (int i = 0; i < 4; i++) {
//            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), pillars.get(i));
//            translate.setByX(-gap);
//            translate.setCycleCount(1);
//            translate.play();
//        }
//
//        double newPillarWidth = generateRandomPillarWidth();
//        pillars.remove(0);
//        Rectangle newPillar = new Rectangle(pillars.get(3).getLayoutX() + gap, 381.0, newPillarWidth, 213.0);
//        newPillar.setArcWidth(5.0);
//        newPillar.setArcHeight(5.0);
//        newPillar.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
//        newPillar.setStroke(javafx.scene.paint.Color.BLACK);
//        newPillar.setOpacity(0.82);
//        pillars.add(newPillar);
//    }
//
//    private void moveCartoonToEnd() {
//        double distanceToMove = stick.getHeight() - 8;
//        double x = cartoonCharacter.getLayoutX();
//
//        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), cartoonCharacter);
//        translate.setToX(x + pillars.get(1).getWidth() / 2 - 6);
//        translate.setCycleCount(1);
//
//        translate.setOnFinished(event -> {
//            stick.setHeight(0);
//            stick.setRotate(0);
//            stick.setTranslateY(0);
//            stick.setLayoutY(379.0);
//            stick.setTranslateX(pillars.get(0).getLayoutX() + 6);
//        });
//
//        translate.play();
//    }
//
//    private void addDelay(double seconds) {
//        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
//        delay.setOnFinished(event -> {
//            if (buttonPressed) {
//                increaseStick();
//            }
//        });
//        delay.play();
//    }
//
//    private double generateRandomPillarWidth() {
//        Random random = new Random();
//        return random.nextDouble() * 50 + 50; // Random width between 50 and 100
//    }
//}
////package com.example.game;
////
////import javafx.animation.PauseTransition;
////import javafx.animation.TranslateTransition;
////import javafx.event.ActionEvent;
////import javafx.fxml.FXML;
////import javafx.scene.image.ImageView;
////import javafx.scene.input.MouseEvent;
////import javafx.scene.shape.Rectangle;
////import javafx.util.Duration;
////
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Random;
////
////public class Newcontroller {
////
////    private double gap;
////    private double length;
////    private boolean buttonPressed = false;
////    private List<Rectangle> pillars = new ArrayList<>();
////    private int currentPillarIndex = 0;
////
////    @FXML
////    private Rectangle stick;
////
////    @FXML
////    private ImageView cartoonCharacter;
////
////    @FXML
////    protected void initialize() {
////        // Add five pillars to the list
////        for (int i = 0; i < 5; i++) {
////            Rectangle pillar = new Rectangle();
////            pillars.add(pillar);
////        }
////        resetPillars();
////    }
////
////    protected void gapDecide() {
////        gap = 136;
////    }
////
////    @FXML
////    protected void increaseStickPressed(MouseEvent eve) {
////        buttonPressed = true;
////        increaseStick();
////    }
////
////    @FXML
////    protected void increaseStickReleased(MouseEvent ee) {
////        buttonPressed = false;
////        gapDecide();
////        increaseStick();
////    }
////
////    @FXML
////    protected void increaseStick() {
////        if (buttonPressed) {
////            increaseStickHeight();
////        } else {
////            rotate();
////        }
////    }
////
////    protected void resetStickTranslation() {
////        stick.setTranslateX(0);
////        stick.setTranslateY(0);
////    }
////
////    @FXML
////    protected void rotate() {
////        resetStickTranslation();
////        stick.setRotate(0);
////        stick.setTranslateY(stick.getHeight() / 2.0);
////        stick.setTranslateX(stick.getHeight() / 2.0);
////
////        TranslateTransition rotateTransition = new TranslateTransition(Duration.seconds(1), stick);
////        rotateTransition.setByAngle(90);
////        rotateTransition.play();
////        animateCartoonCharacter();
////    }
////
////    private void increaseStickHeight() {
////        double currentHeight = stick.getHeight();
////        double newHeight = currentHeight + 1.0;
////        length = newHeight;
////        stick.setLayoutY(stick.getLayoutY() - (newHeight - currentHeight));
////        stick.setHeight(newHeight);
////
////        // Add a pause to control the speed of height increase
////        addDelay(0.002);
////    }
////
////    private void resetPillars() {
////        double initialX = 50.0;
////        double y = 400.0;
////        for (Rectangle pillar : pillars) {
////            pillar.setWidth(generateRandomPillarWidth());
////            pillar.setHeight(20);
////            pillar.setLayoutX(initialX);
////            pillar.setLayoutY(y);
////            pillar.setVisible(true);
////            initialX += gap;
////        }
////    }
////
////    private void repositionPillars() {
////        double distanceToMove = -gap;
////        for (Rectangle pillar : pillars) {
////            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), pillar);
////            translate.setByX(distanceToMove);
////            translate.setCycleCount(1);
////            translate.play();
////        }
////
////        currentPillarIndex = (currentPillarIndex + 1) % pillars.size();
////        Rectangle newPillar = pillars.get(currentPillarIndex);
////        newPillar.setWidth(generateRandomPillarWidth());
////        newPillar.setLayoutX(pillars.get((currentPillarIndex - 1 + pillars.size()) % pillars.size()).getLayoutX() + gap);
////    }
////
////    private void animateCartoonCharacter() {
////        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), cartoonCharacter);
////
////        if (length < (pillars.get(currentPillarIndex).getLayoutX() -
////                (pillars.get((currentPillarIndex - 1 + pillars.size()) % pillars.size()).getLayoutX() +
////                        pillars.get((currentPillarIndex - 1 + pillars.size()) % pillars.size()).getWidth())) ||
////                length > (pillars.get(currentPillarIndex).getLayoutX() +
////                        pillars.get(currentPillarIndex).getWidth() -
////                        (pillars.get((currentPillarIndex - 1 + pillars.size()) % pillars.size()).getLayoutX() +
////                                pillars.get((currentPillarIndex - 1 + pillars.size()) % pillars.size()).getWidth()))) {
////            translateTransition.setByX(stick.getHeight());
////            translateTransition.setByY(200);
////
////        } else {
////            translateTransition.setByX(stick.getHeight());
////
////            translateTransition.setOnFinished(event -> {
////                repositionPillars();
////                moveCartoonToEnd();
////            });
////        }
////
////        translateTransition.setCycleCount(1);
////        translateTransition.play();
////    }
////
////    private void moveCartoonToEnd() {
////        double distanceToMove = stick.getHeight() - 8;
////        double x = cartoonCharacter.getLayoutX();
////
////        TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), cartoonCharacter);
////        translate.setToX(x + pillars.get(currentPillarIndex).getWidth() / 2 - 6);
////        translate.setCycleCount(1);
////
////        translate.setOnFinished(event -> {
////            stick.setHeight(0);
////            stick.setRotate(0);
////            stick.setTranslateY(0);
////            stick.setLayoutY(379.0);
////            stick.setTranslateX(pillars.get(0).getLayoutX() + 6);
////        });
////
////        translate.play();
////    }
////
////    private void addDelay(double seconds) {
////        PauseTransition delay = new PauseTransition(Duration.seconds(seconds));
////        delay.setOnFinished(event -> {
////            if (buttonPressed) {
////                increaseStickHeight();
////            }
////        });
////        delay.play();
////    }
////
////    private double generateRandomPillarWidth() {
////        Random random = new Random();
////        return random.nextDouble() * 50 + 50;
////    }
////}



package com.example.game;

import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.util.Random;

public class Newcontroller {
    double gap;

    double lenght;
    @FXML
    private Rectangle stick;
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
//    private void reposition() {
//        double x1 = pillar1.getLayoutX();
//        double x2 = pillar2.getLayoutX();
//        //System.out.println(x2+" "+x1);
//        double x3 = pillar3.getLayoutX();
//        double x4 = pillar4.getLayoutX();
//        double x5 =pillar5.getLayoutX();
//
//        //pillar5.setLayoutX(x1);
//
//        double distanceToMove = (x2 - x1);
////        TranslateTransition translate1 = new TranslateTransition(Duration.seconds(1), pillar1);
////        translate1.setToX(-2000);
////        translate1.setCycleCount(1);
////        translate1.play();
//        pillar1.setVisible(false);
//
//        TranslateTransition translate2 = new TranslateTransition(Duration.seconds(0.5), pillar2);
//        //translate2.setToX(-distanceToMove);
//        translate2.setByX(-gap);
//        translate2.setCycleCount(1);
//        translate2.play();
//
//        TranslateTransition translate3 = new TranslateTransition(Duration.seconds(0.5), pillar3);
//        //translate3.setToX(-distanceToMove);
//        translate3.setByX(-gap);
//        translate3.setCycleCount(1);
//        translate3.play();
//
//        TranslateTransition translate4 = new TranslateTransition(Duration.seconds(0.5), pillar4);
//        // translate4.setToX(-distanceToMove);
//        translate4.setByX(-gap);
//        translate4.setCycleCount(1);
//        translate4.play();
//
//        TranslateTransition translate5 = new TranslateTransition(Duration.seconds(0.5), pillar5);
//        //translate5.setToX(-distanceToMove);
//        translate5.setByX(-gap);
//        translate5.setCycleCount(1);
//        translate5.play();
//
//        // Generate a new width for the next pillar
//        double newPillarWidth = generateRandomPillarWidth();
//        System.out.println(pillar1.getLayoutX()+" "+pillar2.getLayoutX()+" "+pillar3.getLayoutX()+" "+pillar4.getLayoutX()+" "+pillar5.getLayoutX());
////        pillar1=pillar2;
////        pillar2=pillar3;
////        pillar3=pillar4;
////        pillar4=pillar5;
//
//
//
//
//        System.out.println(pillar1.getLayoutX()+" "+pillar2.getLayoutX()+" "+pillar3.getLayoutX()+" "+pillar4.getLayoutX()+" "+pillar5.getLayoutX());
//
//
//
//        pillar5.setWidth(newPillarWidth);
//        pillar5.setVisible(true);
//        pillar5.setTranslateX(x5);
//        System.out.println(pillar1.getLayoutX()+" "+pillar2.getLayoutX()+" "+pillar3.getLayoutX()+" "+pillar4.getLayoutX()+" "+pillar5.getLayoutX());
////        double newPillarWidth = generateRandomPillarWidth();
////        pillar1 = pillar2;
////        pillar2 = pillar3;
////        pillar3 = pillar4;
////        pillar4 = pillar5;
////
////        pillar5.setWidth(newPillarWidth);
////        pillar5.setVisible(true);
////        pillar5.setTranslateX(pillar4.getTranslateX() + distanceToMove);
//    }

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

            stick.setTranslateX(rectangles[0].getLayoutX()+6);

        });

        // Start the translation animation
        translate.play();

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

