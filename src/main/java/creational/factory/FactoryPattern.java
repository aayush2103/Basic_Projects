package creational.factory;

// Factory - A component responsible solely for the wholesale (not piecewise) creation of objects
// usually a static method that creates objects
// takes care of creation of the object
// a factory can be external or reside inside the object as an inner class
// hierarchies of factories can be used to create related objects
public class FactoryPattern {
    public static void main(String[] args) {
        Point p1 = Point.newCartesianPoint(2,3);
        Point p2 = Point.newPolarPoint(2, 3);
    }
}

// assume a class which can have member variables represented in different ways
class Point {

    private double x, y;

    // 1. A class cannot have below 2 types of constructors in Java as only argument names cannot differ
    /*
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double rho, double theta) {
        this.x = rho * Math.cos(theta);
        this.y = rho * Math.sin(theta);
    }
    */

    // 2. below constructor looks ugly and also confuses the user as to x and y represent which type of values ?!
    /*
    public Point(double x, double y, String type) {
        if (type.equals("cartesian")) {
            this.x = x;
            this.y = y;
        } else if (type.equals("polar")) {
            this.x = x * Math.cos(y);
            this.y = x * Math.sin(y);
        }
    }
    */

    // 3. now comes the 'Factory pattern' to solve above 2 issues
    // private constructor as to enforce the user to use below factory methods
    private Point(double a, double b) {
        x = a;
        y = b;
    }

    public static Point newCartesianPoint(double x, double y) {
        return new Point(x, y);
    }

    public static Point newPolarPoint(double rho, double theta) {
        return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
    }
}
