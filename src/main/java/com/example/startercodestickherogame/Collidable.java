package com.example.startercodestickherogame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Shape;

public abstract class Collidable {
    private double x;
    private double y;
    private Shape shape;

    public Collidable(double x, double y, Image image) {
    }

    public Collidable() {

    }

//    public Collidable(double x, double y, Shape shape) {
//        this.x = x;
//        this.y = y;
//        this.shape = shape;
//    }

    public abstract void checkAndHandle();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    // You might want to add additional methods or properties based on your requirements
}

