package ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import ke_thua.thuc_hanh.doi_tuong_hinh_hoc.Square;

public class ShapeTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}
