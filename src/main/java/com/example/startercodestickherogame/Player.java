package com.example.startercodestickherogame;

public class Player implements Revivable {
    private String name;
    private boolean isAlive;

    public Player(String name) {
        this.name = name;
        this.isAlive = true;
    }


    public String getName() {
        return name;
    }


    public boolean isAlive() {
        return isAlive;
    }


    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }


    @Override
    public boolean isRevivable() {

        return !isAlive;
    }

    @Override
    public void revive() {

        if (!isAlive) {
            System.out.println(name + " has been revived!");
            isAlive = true;
        }
    }


    public void setName(String name) {
        this.name=name;
    }
}
