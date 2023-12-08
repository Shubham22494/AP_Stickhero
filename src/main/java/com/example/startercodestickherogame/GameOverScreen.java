package com.example.startercodestickherogame;

import javafx.scene.Node;

public class GameOverScreen extends Node {
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

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}

