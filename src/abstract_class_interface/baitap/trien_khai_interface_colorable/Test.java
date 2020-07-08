package abstract_class_interface.baitap.trien_khai_interface_colorable;

import abstract_class_interface.thuchanh.lop_animal_va_interface_edible.Chicken;

public class Test {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];
        shapes[0] = new Square("blue", true, 3);
        shapes[1] = new Circle(3.0, "orange", true);

        System.out.println(shapes[0]);

        System.out.println();

         System.out.println(shapes[1]);

        System.out.println();
        for (Shape a : shapes) {
            if (a instanceof Square) {
                Square abc = (Square) a;
                System.out.println(abc);
               abc.howToColor();
            }
        }
    }
}
