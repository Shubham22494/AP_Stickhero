package com.example.startercodestickherogame;
//package com.example.game;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StickHeroController {

    private int characterFlippedUp = 1;
    double gap;
    GameScreen gamescreen;
    StartScreen startscreen;
    GameOverScreen gameoverscreen;
    private int cherriesDisappearedCount = 0;
    @FXML
    private  Label cherrycount;
    double lenght;
    @FXML
    private Rectangle stick;
    @FXML
    private Label score;
    int currscore;
    @FXML
    private StackPane rootPane;

    private Stage primaryStage;

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
    private Platform[] platforms = new Platform[2000];
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

        // Add generated pillars to the
        try {
            gamePane.getChildren().add(G1);
        }catch(Exception e){


        }


    }


    public void generatePillars2() {
        double xPosition = 0.0;
        double gapWidth = 250;

        for (int i = 0; i < platforms.length; i++) {
            double pillarWidth = Math.random() * 50 + 50;
            double pillarHeight = 213;

            platforms[i] = new Platform(pillarWidth, pillarHeight);
            platforms[i].getRectangle().setLayoutY(381);
            platforms[i].getRectangle().setLayoutX(xPosition);

            xPosition += gapWidth;
            gamePane.getChildren().add(platforms[i].getRectangle());
        }
    }
    public List<Cherry> cherries = new ArrayList<>();

    protected void generateCherries() {
        Image cherryImage = new Image("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\resources\\com\\example\\startercodestickherogame\\berry.png");

        for (int i = 2; i < rectangles.length; i += 2) {
            double cherryX = rectangles[i].getLayoutX() + rectangles[i].getWidth() / 2;
            double cherryY = rectangles[i].getLayoutY() - 50; // Adjust the Y position as needed

            Cherry cherry = new Cherry(cherryX, cherryY, cherryImage);
            cherries.add(cherry);

            ImageView cherryImageView = new ImageView(cherryImage);
            cherry.setImageview(cherryImageView);
            cherryImageView.setX(cherryX + 80);
            cherryImageView.setY(cherryY + 60);
            cherryImageView.setFitHeight(25);
            cherryImageView.setFitWidth(30);

            // Add the cherry to the gamePane
            gamePane.getChildren().add(cherryImageView);
        }
    }

//    public List<Cherry> cherries = new ArrayList<>();
//    protected void generateCherries(){
//        Group G1 = new Group();
//        Image cherryImage = new Image("C:\\Users\\lalit\\IdeaProjects\\StartercodeStickHeroGame\\src\\main\\resources\\com\\example\\startercodestickherogame\\cherry4.jpg");
//
//
//        for(int i=2; i<rectangles.length; i+=2){
//            double cherryX = rectangles[i].getLayoutX() + rectangles[i].getWidth() /2;
//            double cherryY = rectangles[i].getLayoutY() - 50; // Adjust the Y position as needed
//
//            Cherry cherry = new Cherry(cherryX, cherryY, cherryImage);
//            cherries.add(cherry);
//
//            ImageView cherryviewing = new ImageView(cherryImage);
//            cherryviewing.setX(cherryX+80);
//            cherryviewing.setY(cherryY+60);
//            cherryviewing.setFitHeight(25);
//            cherryviewing.setFitWidth(30);
//            double gapWidth = 250;
//            cherryX += gapWidth;
//
//            // Add the cherry to the gamePane
////            gamePane.getChildren().add(cherryviewing);
//
//            G1.getChildren().add(cherryviewing);
//        }
//    }


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
        for (Cherry cherry : cherries) {
            TranslateTransition translatec = new TranslateTransition(Duration.seconds(0.5), cherry.getImageView());
            translatec.setByX(distanceToMove);
            translatec.setCycleCount(1);
            translatec.play();
        }

        pillarcount+=1;

    }



    //    private void transitionCherries() {
//        double distanceToMove = -250;
//        for (Cherry cherry : cherries) {
//            TranslateTransition translate = new TranslateTransition(Duration.seconds(0.5), cherry.getImageView());
//            translate.setByX(distanceToMove);
//            translate.setCycleCount(1);
//            translate.play();
//        }
//    }
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
//                transitionCherries();
                //cartoonCharacter.setLayoutX(x);
                moveCartoonToEnd();
            });
        }

        translateTransition.setCycleCount(1);
        translateTransition.play();

    }
    private void checkCherryCollision() {
//        System.out.println(cartoonCharacter.getBoundsInParent());
//        System.out.println(cherries.get(cherriesDisappearedCount).getImageView().getBoundsInParent());

            if (cartoonCharacter.getBoundsInParent().intersects(cherries.get(cherriesDisappearedCount).getImageView().getBoundsInParent())) {
                cherries.get(cherriesDisappearedCount).getImageView().setVisible(false);
                cherriesDisappearedCount++;
                cherrycount.setText(Integer.toString(cherriesDisappearedCount));
                //System.out.println(cherriesDisappearedCount);
            }

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

    public void switchToStartScreen() {
        try {
            StartScreen startScreen = startscreen;
            rootPane.getChildren().clear();
//            rootPane.getChildren().add(startScreen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToGameScreen() {
        try {
            GameScreen GameScreen = gamescreen;
            rootPane.getChildren().clear();
            rootPane.getChildren().add(GameScreen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchToGameOverScreen() {
        try {
//            Parent gameOverScreen = ;
            rootPane.getChildren().clear();
            rootPane.getChildren().add(gameoverscreen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void tapScreen(MouseEvent event) {
        if (characterFlippedUp==1) {
            flipCharacterDown();
        } else if(characterFlippedUp ==2){
            flipCharacterUp();
        }
    }
    public void cartoonturn(KeyEvent eve){
        if (eve.getCode() == KeyCode.F) {
            if (characterFlippedUp == 1) {
                flipCharacterDown();
            } else if (characterFlippedUp == 2) {
                flipCharacterUp();
            }
        }
    }



    private void flipCharacterDown() {
        cartoonCharacter.setScaleY(-1);
//        System.out.println("down");
        cartoonCharacter.setLayoutY(380);
        TranslateTransition moveDownTransition = new TranslateTransition(Duration.seconds(0.5), cartoonCharacter);
        moveDownTransition.setByY(0);
        moveDownTransition.setCycleCount(1);
        moveDownTransition.play();
        checkCherryCollision();
        // Update the character state
        characterFlippedUp = 2;
    }

//    private void flipCharacterDown() {
//        // Create a sequential transition to perform the two animations in sequence
//        SequentialTransition sequentialTransition = new SequentialTransition();
//
//        // First, add a translation to move down by 10 units
//        TranslateTransition moveDownTransition = new TranslateTransition(Duration.seconds(0.2), cartoonCharacter);
//        moveDownTransition.setByY(50);
//
//        // Set an event handler to be executed after the translation is finished
//        moveDownTransition.setOnFinished(event -> {
//            // Second, add the scale transition to flip vertically
//            ScaleTransition flipTransition = new ScaleTransition(Duration.seconds(0.3), cartoonCharacter);
//            flipTransition.setToY(-1); // Flip vertically
//
//            // Set an event handler to be executed after the flip is finished
//            flipTransition.setOnFinished(flipEvent -> {
//                // Update the character state
//                characterFlippedUp = 2;
//            });
//
//            // Play the flip transition
//            flipTransition.play();
//        });
//
//        // Add the move down transition to the sequence
//        sequentialTransition.getChildren().add(moveDownTransition);
//
//        // Play the entire sequence
//        sequentialTransition.play();
//    }
//    private void flipCharacterUp() {
//        // Create a sequential transition to perform the two animations in sequence
//        SequentialTransition sequentialTransition = new SequentialTransition();
//
//        // First, add a translation to move up by 10 units
//        TranslateTransition moveUpTransition = new TranslateTransition(Duration.seconds(0.2), cartoonCharacter);
//        moveUpTransition.setByY(-10);
//
//        // Set an event handler to be executed after the translation is finished
//        moveUpTransition.setOnFinished(event -> {
//            // Second, add the scale transition to reset the scale
//            ScaleTransition flipTransition = new ScaleTransition(Duration.seconds(0.3), cartoonCharacter);
//            flipTransition.setToY(1); // Reset the scale
//
//            // Set an event handler to be executed after the flip is finished
//            flipTransition.setOnFinished(flipEvent -> {
//                // Update the character state
//                characterFlippedUp = 1;
//            });
//
//            // Play the flip transition
//            flipTransition.play();
//        });

    // Add the move up transition to the sequence
//        sequentialTransition.getChildren().add(moveUpTransition);
//
//        // Play the entire sequence
//        sequentialTransition.play();
//    }


    private void flipCharacterUp() {
//        System.out.println("up");
        cartoonCharacter.setScaleY(1);
        cartoonCharacter.setLayoutY(295);
        characterFlippedUp = 1;
    }
//private void flipCharacterDown() {
//    // Code to flip the character down
//    TranslateTransition flipDownTransition = new TranslateTransition(Duration.seconds(0.5), cartoonCharacter);
//    flipDownTransition.setToY(stick.getHeight());
//    flipDownTransition.setCycleCount(1);
//    flipDownTransition.play();
//
//    // Update the character state
//    characterFlippedUp = 2;
//}
//
//    private void flipCharacterUp() {
//        // Code to flip the character up
//        TranslateTransition flipUpTransition = new TranslateTransition(Duration.seconds(0.5), cartoonCharacter);
//        flipUpTransition.setToY(0);
//        flipUpTransition.setCycleCount(1);
//        flipUpTransition.play();
//
//        // Update the character state
//        characterFlippedUp = 1;
//    }

//    private void flipCharacterDown() {
//        // Code to flip the character down
//        RotateTransition flipDownTransition = new RotateTransition(Duration.seconds(0.5), cartoonCharacter);
//        flipDownTransition.setByAngle(180);
//        flipDownTransition.setCycleCount(1);
//        flipDownTransition.play();
//
//        // Update the character state
//        characterFlippedUp = 2;
//    }
//
//    private void flipCharacterUp() {
//        // Code to flip the character up
//        RotateTransition flipUpTransition = new RotateTransition(Duration.seconds(0.5), cartoonCharacter);
//        flipUpTransition.setByAngle(180);
//        flipUpTransition.setCycleCount(1);
//        flipUpTransition.play();
//
//        // Update the character state
//        characterFlippedUp = 1;
//    }







}
