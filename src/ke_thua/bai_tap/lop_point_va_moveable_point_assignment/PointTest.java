package ke_thua.bai_tap.lop_point_va_moveable_point_assignment;

import ke_thua.bai_tap.lop_point_va_moveable_point_assignment.Point;

import java.util.Scanner;

public class PointTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X");
        float x = scanner.nextFloat();
        System.out.println("Enter Y");
        float y = scanner.nextFloat();
        Point point=new Point(x,y);
        System.out.println(point.toString());
    }
}
