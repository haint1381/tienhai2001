package bai_hoc.ke_thua.bai_tap.lop_point2d_va_lop_point3d;

import java.util.Scanner;

public class Point2DTest  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X");
        float x = scanner.nextFloat();
        System.out.println("Enter Y");
        float y = scanner.nextFloat();
        Point2D point2D=new Point2D(x,y);
        System.out.println(point2D.toString());
    }
}
