package ke_thua.bai_tap.lop_point2d_va_lop_point3d;

import java.util.Scanner;

public class Point3DTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X");
        float x = scanner.nextFloat();
        System.out.println("Enter Y");
        float y = scanner.nextFloat();
        System.out.println("Enter Z");
        float z = scanner.nextFloat();
        Point3D point3D= new Point3D(x,y,z);
        System.out.println(point3D.toString());
    }
}
