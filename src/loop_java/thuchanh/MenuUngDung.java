package loop_java.thuchanh;

import java.util.Scanner;

public class MenuUngDung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                 for(int i=6;i>0;i--){
                     for (int j=0;j<i;j++){
                         System.out.print("*");
                     }
                     System.out.print("\n");
                 }
                    break;
                case 2:
                    System.out.println("Draw the square");
                    for(int i=1;i<6;i++){
                        for (int j=1;j<12;j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    for(int i=1;i<6;i++){
                        for (int j=1;j<8;j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }

    }
}