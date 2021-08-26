package com.pluralsight.org.bridge.shape2;

public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        //color in constructor to utilize 'Composition'
        this.color = color;
    }

    abstract public void applyColor();
}
