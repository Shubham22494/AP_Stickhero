package com.example.startercodestickherogame;

import javafx.scene.shape.Rectangle;

public class Platform {
    private double width;
    private double height;
    private Rectangle rectangle;

    public Platform(double width, double height) {
        this.width = width;
        this.height = height;
        this.rectangle = new Rectangle(width, height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}

