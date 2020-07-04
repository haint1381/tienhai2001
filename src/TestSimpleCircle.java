public class TestSimpleCircle {
    /**
     * Main method
     */
    public static void main(String[] args) {
        SimpleCircle circle1 = new SimpleCircle();
        System.out.println("The area of the circle of radius " + circle1.radius + " is " + circle1.getArea());
        SimpleCircle circle2 = new SimpleCircle(25);
        System.out.println("The area of the circle of radius " + circle2.radius + " is " + circle2.getArea());

        SimpleCircle circle3 = new SimpleCircle(125);
        System.out.println("The area of the circle of radius " + circle3.radius + " is " + circle3.getArea());
        circle2.radius = 100;
        System.out.println("The area of the circle of radius " +circle2.radius + " is " + circle2.getArea());
        SimpleCircle circle4 = new SimpleCircle(2);
        System.out.println("The area of the circle of radius " + circle4.radius + " is " + circle4.getArea());
    }
}
class SimpleCircle {
    int radius;
    /* Construct a circle with radius */

    SimpleCircle() {
        radius = 1;
    }

    SimpleCircle(double x) {
        radius = 1;
    }

    /* Construct a circle with a specified radius */
    SimpleCircle(int newRadius) {
        radius = newRadius;
    }

    /* Return the area of this circle */
    float getArea() {
        return (float) (radius * radius * Math.PI);
    }

    /* return the perimeter of this circle */
    double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /* set a new radius for this circle */
    void setRadius(int newRadius) {
        radius = newRadius;
    }
}
