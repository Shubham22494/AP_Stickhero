package com.example.startercodestickherogame;

import javafx.stage.Stage;

public class StickHeroGame {
    private StickHeroEngine engine;//composition+dependency
    private StickHeroController controller;//composition
    private Stage primaryStage;
    public StickHeroGame() {
        this.engine = new StickHeroEngine();
        this.controller = new StickHeroController();
    }
    public void startGame() {

        showStartScreen();
    }
    public void showStartScreen() {

    }

    public void showGameScreen() {
        // Assuming you have a GameScreen class
//        GameScreen gameScreen = new GameScreen(engine, controller);
//        gameScreen.show();
    }
//    public void showGameOverScreen(int score) {
//        GameOverScreen gameOverScreen = new GameOverScreen();
//        gameOverScreen.displayGameOver(score);
//    }
    public void updateGame() {
        engine.updateGame();
//        controller.processInput();

    }
    public void replay() {
        engine.initializeGame();

    }
}