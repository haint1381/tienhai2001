package ke_thua.circle_va_cylinder;

import java.util.Scanner;

public class CylinderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter cylinder radius:");
        double radius = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter cylinder color:");
        String color = scanner.nextLine();
        System.out.println("Enter cylinder height:");
        double height = scanner.nextDouble();
        Cylinder cylinder = new Cylinder(radius, color, height);
        System.out.println(cylinder.volume());
    }
}
