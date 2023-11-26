package com.example.startercodestickherogame;

public class GameScreen implements Updatable{
    private StickHeroGame stickHeroGame;  // Composition

//    public GameScreen(StickHeroGame stickHeroGame) {
//        this.stickHeroGame = stickHeroGame;
//
//    }
    public GameScreen(StickHeroEngine engine, StickHeroController controller) {
        this.stickHeroGame = stickHeroGame;
    }

    public void show() {

    }
    @Override
    public void updateGame() {

    }

    public void handleInput() {

    }

    public void startGame() {

        show();
    }
}
