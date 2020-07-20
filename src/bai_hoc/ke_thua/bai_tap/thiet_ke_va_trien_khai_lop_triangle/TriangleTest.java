package bai_hoc.ke_thua.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input side1: ");
        double side1=scanner.nextDouble();
        System.out.println("input side1: ");
        double side2=scanner.nextDouble();
        System.out.println("input side1: ");
        double side3=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("input color: ");
        String color=scanner.nextLine();
        System.out.println("fill");
        boolean fill=scanner.nextBoolean();
        Triangle triangle=new Triangle(side1,side2,side3,color,fill);
        System.out.println(triangle.toString());
    }
}
