package bai_hoc.loop_java.baitap;

import java.util.Scanner;

public class InCacloaiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1.hình chữ nhật");
        System.out.println("2.tam giác 1");
        System.out.println("3. tam giác 2");
        System.out.println("4. tam giác cân");
        System.out.println("5. tam giác cân2");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("hình chữ nhật");
                    for (int i = 1; i < 6; i++) {
                        for (int j = 1; j < 8; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    System.out.println("tam giác 1");
                    for (int i = 6; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    System.out.println("tam giác 2");
                    for (int i = 1; i < 6; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.out.println("tam giác cân");
                    String result = "";
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            if (j > i && j < (6 - i)) {
                                result += "*";
                            } else {
                                result += " ";
                            }
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    break;
                case 5:
                    System.out.println("tam giác cân");
                    String result1="";
                    for (int i = 2; i <= 6; i++) {
                        for (int j = (6 - i); j >= 1; j--) {
                           result1+=" ";
                        }
                        for (int k = 1; k < i; k++) {
                            result1+="*";
                        }

                        for (int c = i - 1; c > 1; c--) {
                          result1+="*";
                      }
                        result1+="\n";
                    }
                    System.out.println(result1);
            break;
                case 6:
                    for (int i = 0; i < 5; i++) {
                    System.out.println();
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print("_");
                    }
                    for (int k = 0; k < 2 * i + 1; k++) {
                        System.out.print("*");
                    }
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