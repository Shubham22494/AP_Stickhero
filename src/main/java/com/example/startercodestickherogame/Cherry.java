package com.example.startercodestickherogame;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
//iimport javafx.scene.shape.Shape;

public class Cherry extends Collidable {
    private int value;

    public ImageView getImageview() {
        return imageview;
    }

    private ImageView imageview;
    StickHeroController contro=new StickHeroController();



    public Cherry(double cherryX, double cherryY, Image cherryImage) {
        super(cherryX,cherryY,cherryImage);
    }



    public ImageView getImageView() {
        return imageview;
    }
    public void setImageview(ImageView img){
        this.imageview=img;
    }


    ////checking

    public void addToPane(Pane pane){
        pane.getChildren().add(imageview);
    }




    @Override
    public void checkAndHandle() {
        contro.checkCherryCollision();
        // Add collision detection logic and handling
        // This method will be called to check for collisions and handle them
        // For example, if the cherry collides with the character, call the gather method
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
