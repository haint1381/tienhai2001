package bai_hoc.access_modifier.baitap;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle=new Circle();
        System.out.println(circle.getColor());
        System.out.println(circle.getRadius());
        Circle circle1=new Circle(2);
        System.out.println(circle1.getColor());
        System.out.println(circle1.getRadius());
    }
}

class Circle {
    public double radius = 1.0;
    private String color = "blue";

    public Circle() {

    }

    public Circle(double radius) {
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }
}
