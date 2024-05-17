package solid;

// Liskov Substitution Principle
//      idea of this principle is you should be able to substitute a subclass for a base class
//      meaning that the subclass should be working fine along with the base class methods as well
public class LSP {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(2 , 5);
        useIt(r);

        Rectangle s = new Square();
        s.setHeight(2);
        s.setWidth(5);
        useIt(s);

        /* 1. above code gives wrong answer for square due to the incorrect/abrupt implementation for Square class,
        *     and hence violates LSP
        *  2. rather use a method and proper class implementations (eg. factory pattern) to distinguish between the 2 classes */
    }

    static void useIt(Rectangle r) {
        int width = r.getWidth();
        r.setHeight(10);
        System.out.println("Expected area to be - " + (width * 10) +
                ", but actual area is - " + r.getArea());
    }
}

class Rectangle {
    public int height, width;

    public Rectangle() {}

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getArea() {
        return height * width;
    }

    // 2.
    public boolean isSquare() {
        return height == width;
    }
}

class Square extends Rectangle {
    public Square() {}
    public Square(int side) {
        this.height = this.width = side;
    }

    // 1. below 2 methods violate LSP
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
    @Override
    public void setWidth(int width) {
        super.setHeight(height);
        super.setWidth(height);
    }
}

// 2.
class RectangleFactory {
    public static Rectangle newRectangle(int height, int width) {
        return new Rectangle(height, width);
    }

    public static Rectangle newSquare(int side) {
        return new Rectangle(side, side);
    }
}
