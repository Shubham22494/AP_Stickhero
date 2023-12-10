package com.example.startercodestickherogame;
//package com.example.game;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StickHeroController {


    private List<Integer> scores = new ArrayList<>();
//    private int curr = 0;

    public void updateScore(int score) {
        currscore = score;
        scores.add(currscore);
    }

    // Method to get the current score
    public int getCurrentScore() {
        return currscore;
    }

    public int getBestScore() {
        //System.out.println(getCurrentScore());
        int bestScore = 5;
        for (int score : scores) {
            if (score > bestScore) {
                bestScore = score;
            }
        }
        return bestScore;
    }
    public void setscore(){
        score.setText(Integer.toString(2));
    }

    public void getBestScore2(){
        //System.out.println(getCurrentScore());
        int bestScore=0;
        for (int score : scores) {
            if (score > bestScore) {
                bestScore = score;
            }
        }
        //System.out.println(bestScore);

    }



    private int characterFlippedUp = 1;
    double gap;
    GameScreen gamescreen;
    StartScreen startscreen;
    GameOverScreen gameoverscreen;
    private int cherriesDisappearedCount = 0;
//    @FXML
//    private Label finalscore;
    @FXML
    private  Label cherrycount;
    public int scored;
    double lenght;
    @FXML
    private Rectangle stick;
    @FXML
    private Label score;
    int currscore;
//    @FXML
//    private Label gamescore;
    @FXML
    private StackPane rootPane;

    private Stage primaryStage;

    @FXML
    private ImageView cartoonCharacter;

    @FXML
    private AnchorPane gamePane;

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public double getGap() {
        return gap;
    }

    public void setGap(double gap) {
        this.gap = gap;
    }

    public GameScreen getGamescreen() {
        return gamescreen;
    }

    public void setGamescreen(GameScreen gamescreen) {
        this.gamescreen = gamescreen;
    }

    public StartScreen getStartscreen() {
        return startscreen;
    }

    public void setStartscreen(StartScreen startscreen) {
        this.startscreen = startscreen;
    }

    public GameOverScreen getGameoverscreen() {
        return gameoverscreen;
    }

    public void setGameoverscreen(GameOverScreen gameoverscreen) {
        this.gameoverscreen = gameoverscreen;
    }

    public int getCherriesDisappearedCount() {
        return cherriesDisappearedCount;
    }

    public void setCherriesDisappearedCount(int cherriesDisappearedCount) {
        this.cherriesDisappearedCount = cherriesDisappearedCount;
    }

    public Label getCherrycount() {
        return cherrycount;
    }

    public void setCherrycount(Label cherrycount) {
        this.cherrycount = cherrycount;
    }

    public int getScored() {
        return scored;
    }

    public void setScored(int scored) {
        this.scored = scored;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public Rectangle getStick() {
        return stick;
    }

    public void setStick(Rectangle stick) {
        this.stick = stick;
    }

    public void setScore(Label score) {
        this.score = score;
    }

    public int getCurrscore() {
        return currscore;
    }

    public void setCurrscore(int currscore) {
        this.currscore = currscore;
    }

    public StackPane getRootPane() {
        return rootPane;
    }

    public void setRootPane(StackPane rootPane) {
        this.rootPane = rootPane;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public ImageView getCartoonCharacter() {
        return cartoonCharacter;
    }

    public void setCartoonCharacter(ImageView cartoonCharacter) {
        this.cartoonCharacter = cartoonCharacter;
    }

    public AnchorPane getGamePane() {
        return gamePane;
    }

    public void setGamePane(AnchorPane gamePane) {
        this.gamePane = gamePane;
    }

    public int getPillarcount() {
        return pillarcount;
    }

    public void setPillarcount(int pillarcount) {
        this.pillarcount = pillarcount;
    }

    public Rectangle[] getRectangles() {
        return rectangles;
    }

    public void setRectangles(Rectangle[] rectangles) {
        this.rectangles = rectangles;
    }

    public Platform[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Platform[] platforms) {
        this.platforms = platforms;
    }

    public Label getGamescore() {
        return gamescore;
    }

    public void setGamescore(Label gamescore) {
        this.gamescore = gamescore;
    }

    public Label getGamee() {
        return gamee;
    }

    public void setGamee(Label gamee) {
        this.gamee = gamee;
    }

    public List<Cherry> getCherries() {
        return cherries;
    }

    public void setCherries(List<Cherry> cherries) {
        this.cherries = cherries;
    }

    public StickHeroApp getStickHeroApp() {
        return stickHeroApp;
    }

    public void setStickHeroApp(StickHeroApp stickHeroApp) {
        this.stickHeroApp = stickHeroApp;
    }

    //    @FXML
//    private Label finals;
    int pillarcount=0;
    Rectangle[] rectangles = new Rectangle[2000];
    private Platform[] platforms = new Platform[2000];
    public void generatePillars() {

        double xPosition = 0.0;
        double gapWidth = 250;
        Group G1 = new Group();

        for (int i = 0; i < 2000; i++) {
            rectangles[i] = new Rectangle();
            rectangles[i].setWidth(Math.random() * 50 + 50);
            rectangles[i].setHeight(213);
            rectangles[i].setLayoutY(381);
            rectangles[i].setLayoutX(xPosition);

            xPosition += gapWidth;
            G1.getChildren().add(rectangles[i]);
        }


        try {
            gamePane.getChildren().add(G1);
        }catch(Exception e){


        }


    }

    public Label gamescore;
    public Label gamee;


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


    public boolean isButtonPressed() {
        return buttonPressed;
    }

    public void setButtonPressed(boolean buttonPressed) {
        this.buttonPressed = buttonPressed;
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
    StickHeroApp stickHeroApp;
    @FXML
    private void switchToGameScreen(ActionEvent event) throws Exception {
        getBestScore2();
        // Load the FXML file for the game screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hi.fxml"));
        Parent gameScreenRoot = loader.load();

        GameScreen gameScreen = new GameScreen(stickHeroApp);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        gameScreen.show(stage);
    }

    @FXML
    private void revive(ActionEvent eve) throws Exception {                             ////Considering the minimum amount of cherry required is 2 and the game will start from zero zero scores if the revive condition met
        //System.out.println(cherriesDisappearedCount);
        List<Integer> scoreList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\java\\com\\example\\startercodestickherogame\\Scores"))) {
            String line;

            while ((line = reader.readLine()) != null) {

                scored = Integer.parseInt(line);
                scoreList.add(scored);
//                System.out.println(scored);
//                scoreList.add(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(scoreList.get(scoreList.size() - 1) >2){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hi.fxml"));
            Parent gameScreenRoot = loader.load();
            StickHeroController control=loader.getController();
            control.setscore();
            //control.cherrycount.setText(Integer.toString(5));

            GameScreen gameScreen = new GameScreen(stickHeroApp);
            Stage stage = (Stage) ((javafx.scene.Node) eve.getSource()).getScene().getWindow();
            gameScreen.show(stage);

        }
        else{
            System.out.println("Cannot Be revived cherry is insufficient!!!!");
        }

    }
    private void switchToGameOverScreen() throws Exception {
        getBestScore2();
        try {
            //gamee.setText("5");
            GameOverScreen gameoverscr = new GameOverScreen(stickHeroApp);
            Stage stage = (Stage) gamePane.getScene().getWindow();
            gameoverscr.show(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(getScore());
    }
    @FXML
    private void switchToStartScreen(ActionEvent event) throws Exception {
        // Load the FXML file for the start screen
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
        Parent startScreenRoot = loader.load();

        StartScreen startScreen = new StartScreen(stickHeroApp);
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        startScreen.show();
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
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\java\\com\\example\\startercodestickherogame\\Scores", true))) {
                    // Append each score to the file

                        writer.write(Integer.toString(cherriesDisappearedCount));
                        writer.newLine();


                    //System.out.println("Scores have been written to the file.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\shubh\\Downloads\\2022494_Shubham_Kumar_Dwivedi\\APStick\\src\\main\\java\\com\\example\\startercodestickherogame\\Final", true))) {
                    // Append each score to the file

                    writer.write(Integer.toString(currscore));
                    writer.newLine();


                    //System.out.println("Scores have been written to the file.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                PauseTransition pauseTransition = new PauseTransition(Duration.seconds(1));
                pauseTransition.setOnFinished(pauseEvent -> {
                    try {
                        switchToGameOverScreen();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
                pauseTransition.play();
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
    public void checkCherryCollision() {
//        System.out.println(cartoonCharacter.getBoundsInParent());
//        System.out.println(cherries.get(cherriesDisappearedCount).getImageView().getBoundsInParent());

        if (cartoonCharacter.getBoundsInParent().intersects(cherries.get(cherriesDisappearedCount).getImageView().getBoundsInParent())) {
            cherries.get(cherriesDisappearedCount).getImageView().setVisible(false);
            cherriesDisappearedCount++;
            cherrycount.setText(Integer.toString(cherriesDisappearedCount));
            currscore++;
            //finalscore.setText(Integer.toString(currscore));
            score.setText(Integer.toString(currscore));
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
        //gamescore.setText(Integer.toString(currscore));
        //finalscore.setText(Integer.toString(currscore));

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

//    public void switchToStartScreen() {
//        try {
//            StartScreen startScreen = startscreen;
//            rootPane.getChildren().clear();
////            rootPane.getChildren().add(startScreen);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public void setStartScreen(StartScreen scrn){
//
//    }
//    public void switchToGameScreen() {
//        try {
//            GameScreen GameScreen = gamescreen;
//            rootPane.getChildren().clear();
//            rootPane.getChildren().add(GameScreen);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }



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




    public int getCharacterFlippedUp() {
        return characterFlippedUp;
    }

    public void setCharacterFlippedUp(int characterFlippedUp) {
        this.characterFlippedUp = characterFlippedUp;
    }

    private void flipCharacterUp() {
//        System.out.println("up");
        cartoonCharacter.setScaleY(1);
        cartoonCharacter.setLayoutY(295);
        characterFlippedUp = 1;
    }

    public int getCherryCount() {
        return cherriesDisappearedCount;
    }

    public int getScore() {
        return currscore;
    }









}