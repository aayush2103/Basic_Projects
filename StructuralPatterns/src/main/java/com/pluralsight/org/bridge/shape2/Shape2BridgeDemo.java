package com.pluralsight.org.bridge.shape2;

public class Shape2BridgeDemo {

    public static void main(String[] args) {

        // now adding new color will only require implementation of a new Color class only !!
        // Here color and shape are independent of each other unlike previous example !!
        Color blue = new BlueColor();
        Shape square = new Square(blue);

        Color red = new RedColor();
        Shape circle = new Circle(red);

        square.applyColor();
        circle.applyColor();
    }
}
