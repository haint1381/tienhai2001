package abstract_class_interface.baitap.trien_khai_interface_resizeable;
import abstract_class_interface.baitap.trien_khai_interface_resizeable.Resizeable;
public class Square extends Shape implements Resizeable{
    private double side;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side, String color, boolean filled) {
        super(color,filled);
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
        return "A Square with side="
                + getSide()
                + ", subclass of shape "
                + super.toString()
                + ", Area=" +
                + getArea();
    }

    double getArea() {
        return side * side;
    }
    @Override
    public void resize(double percent) {
        this.side += (percent / 100)* this.side;
    }
}