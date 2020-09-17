package bai_hoc.introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("a:  ");
        int a = scanner.nextInt();
        System.out.println("b:  ");
        int b = scanner.nextInt();
        System.out.println("c:  ");
        int c = scanner.nextInt();

        if (a != 0) {
            int solution = -b / a;
            System.out.printf("The solution is: %d!", solution);
        }
        if (a != 0) {
            int answer = (c - b) / a;
            System.out.printf("Equation pass with x = %d!\n", answer);
        } else {
            if (b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.print("No solution!");
            }
        }

    }
}
