package com.example.startercodestickherogame;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
//iimport javafx.scene.shape.Shape;

public class Cherry extends Collidable {
    private int value;
    private ImageView imageview;

//    public Cherry(double x, double y, int value) {
//        super(x, y);
//        this.value = value;
//    }

    public Cherry(double cherryX, double cherryY, Image cherryImage) {
        super(cherryX,cherryY,cherryImage);
    }

    private void initialize_cherries(){
        Image cherryImage = new Image("");
        imageview = new ImageView(cherryImage);
        imageview.setX(getX());
        imageview.setY(getY());


    }
    ////checking

    public void addToPane(Pane pane){
        pane.getChildren().add(imageview);
    }

//    public Node getNode() {
//        return imageView;
//    }

    public void gather() {
        // Add logic for what happens when the character gathers the cherry
        // For example, increase the score or perform any other actions
    }

    @Override
    public void checkAndHandle() {
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
