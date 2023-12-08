package com.example.startercodestickherogame;
import java.util.*;
//StickHeroEngine class
public class StickHeroEngine implements Updatable{
    private Player player;  //Aggregation
    private List<Platform> platforms;  // Aggregation
    private List<Reward> rewards;  // Composition
    private ReviveFeature reviveFeature;  // Composition
    private PlayerSetupScreen playerSetUpScreen;
    private int score;
    public StickHeroEngine() {
//        this.player = new Player(player.getName());
        this.platforms = new ArrayList<>();
        this.rewards = new ArrayList<>();
        this.reviveFeature = new ReviveFeature(2);
        this.score = 0;
    }
    public void initializeGame() {

        playerSetUpScreen.displaySetupScreen();

    }

    public void updateGame() {

    }

    public void updatePlayerDetails(String name){
        player.setName(name);
    }

    public void handleCollisions() {

    }

    public void collectReward(Reward reward) {

    }

    public void revivePlayer() {

    }

    public int getScore() {
        return 0;
    }
}
