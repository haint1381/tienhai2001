package bai_hoc.ke_thua.bai_tap.circle_va_cylinder;

import java.util.Scanner;

public class CircleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter circle radius:");
        double radius = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter circle color:");
        String color = scanner.nextLine();
        System.out.println("Enter circle color:");
        double height = scanner.nextDouble();
        Circle circle = new Circle(radius, color,height );
        System.out.println(circle.toString());
    }
}