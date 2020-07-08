package abstract_class_interface.baitap.trien_khai_interface_colorable;

public class Square extends Shape implements Colorable {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public Square() {

    }

    public Square(String color, boolean filled, double side) {
        super(color, filled);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "A Square with side = " + getSide()
                + ", subclass of shape , "
                + super.toString()
                + ", Area=" +
                + getArea()
               ;
    }
    double getArea() {
        return side * side;
    }
    @Override
    public void howToColor() {
        System.out.println("Colorable side fourt");
    }
}
