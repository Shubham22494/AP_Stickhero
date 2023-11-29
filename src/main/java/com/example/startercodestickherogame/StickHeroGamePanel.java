package com.example.startercodestickherogame;





import javafx.scene.Group;

public class StickHeroGamePanel implements Updatable {
    private GameScreen gameScreen;  //composition
    private StartScreen startScreen;  // Aggregation
    private PlayerSetupScreen playerSetupScreen;  // Aggregation
    private GameOverScreen gameOverScreen;  // Composition
    private StickHeroEngine engine;  // dependency
    private StickHeroController stickHeroController;  // Composition
    private StatisticsPanel statisticsPanel;  // Aggregation

    public StickHeroGamePanel() {
//        Panel
    }

    @Override
    public void updateGame() {

        gameScreen.updateGame();
    }

    public void showGameOver() {

        gameOverScreen.displayGameOver(engine.getScore());
    }

    public void restart() {

        engine.initializeGame();
//        showStartScreen();
    }

//    public void showStartScreen() {
//
//        startScreen.show();
//    }

}


class StatisticsPanel {
    private int gamesPlayed;
    private int highScore;

    public StatisticsPanel() {

        gamesPlayed = 0;
        highScore = 0;
    }

    public void updateStatistics(int currentScore) {

    }

    public void displayStatistics() {

    }
}