package com.example.startercodestickherogame;


public class ReviveFeature implements Revivable {
    private int cherriesRequired;

    public ReviveFeature(int cherriesRequired) {
        this.cherriesRequired = cherriesRequired;
    }

    @Override
    public boolean isRevivable() {
        return true;

    }

    @Override
    public void revive() {
        if (isRevivable()) {

//
        } else {

        }
    }
}

