package abstract_class_interface.baitap.trien_khai_interface_resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(10, "yellow", false);
        shapes[1] = new Rectangle(10, 20, "red", true);
        shapes[2] = new Square(10, "blue", true);
        System.out.println();
        System.out.println("Pre-sorted:");
        for (Shape a : shapes){
            System.out.println(a);
        }

        for (Shape a : shapes) {
            if(a instanceof Circle){
                Circle circle=(Circle)a;
                circle.resize(Math.random()*100);
            }
            if(a instanceof Square){
                Square square=(Square)a;
                square.resize(Math.random()*100);
            }
            if(a instanceof Rectangle){
                Rectangle rectangle=(Rectangle) a;
                rectangle.resize(Math.random()*100);
            }
        }
        System.out.println();
        System.out.println("After-sorted:");
        for (Shape a : shapes){
            System.out.println(a);
        }
    }
}
