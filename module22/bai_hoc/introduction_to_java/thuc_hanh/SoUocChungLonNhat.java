package bai_hoc.introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class SoUocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số thứ nhất: ");
        int number1 = scanner.nextInt();
        System.out.println("nhập số thứ hai: ");
        int number2 = scanner.nextInt();
        number2 = Math.abs(number2);
        number1 = Math.abs(number1);


        if (number1 == number2) {
            System.out.println("ước chung lớn nhất là: " + number1);
        }
        if (number1 == 0 && number2 == 0) {
            System.out.println("không có ước chung lớn nhất ");
        }
        if (number1 == 0 && number2 != 0) {
            System.out.println(" ước chung lớn nhất là " + number2);
        } else System.out.println(" ước chung lớn nhất là " + number1);
        while (number1 != number2) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        }
        System.out.println("ước chung lớn nhất là " + number1);
    }
}

