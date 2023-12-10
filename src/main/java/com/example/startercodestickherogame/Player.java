//package com.example.startercodestickherogame;
//
//public class Player implements Revivable {
//    private String name;
//    private boolean isAlive;
//
//    public Player(String name) {
//        this.name = name;
//        this.isAlive = true;
//    }
//
//
//    public String getName() {
//        return name;
//    }
//
//
//    public boolean isAlive() {
//        return isAlive;
//    }
//
//
//    public void setAlive(boolean isAlive) {
//        this.isAlive = isAlive;
//    }
//
//
//    @Override
//    public boolean isRevivable() {
//
//        return !isAlive;
//    }
//
//    @Override
//    public void revive() {
//
//        if (!isAlive) {
//            System.out.println(name + " has been revived!");
//            isAlive = true;
//        }
//    }
//
//
//    public void setName(String name) {
//        this.name=name;
//    }
//}


package com.example.startercodestickherogame;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Player implements Revivable {
    private String name="StickHero";

    public ImageView getCartoonCharacter() {
        return cartoonCharacter;
    }

    public void setCartoonCharacter(ImageView cartoonCharacter) {
        this.cartoonCharacter = cartoonCharacter;
    }

    @FXML
    private ImageView cartoonCharacter;
    private boolean isAlive;

    public Player(String name){
//        this.cartoonCharacter = cartoonCharacter;
        this.name=name;
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