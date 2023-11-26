package com.example.startercodestickherogame;

public class StartScreen {
    private StickHeroGame game; //composition

    public StartScreen(StickHeroGame game) {
        this.game = game;
    }

    public void show() {

        game.showGameScreen();
    }

    public void startButtonClicked() {

    }

   //ineer class
    class Tutorial {
        public void specificLogic() {

        }
    }
}
