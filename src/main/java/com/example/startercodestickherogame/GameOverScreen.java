package com.example.startercodestickherogame;

public class GameOverScreen {
    private StickHeroGame stickHeroGame;  // Composition
    public GameOverScreen(StickHeroGame stickHeroGame) {
        this.stickHeroGame = stickHeroGame;

    }

    public GameOverScreen(){

    }

    public void displayGameOver(int score) {

     //inner class
    class ShareResults {
        public void displayShareResultsStage() {
            System.out.println("");
        }

        }
    }

    public void shareResults() {

    }
}

