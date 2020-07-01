package mang_va_phuong_thuc_java.thuchanh;

import java.util.Scanner;

public class PhanTuTrongMang {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int size;
        int[] array;
        do {
            System.out.print("nhập vào kích thước của mảng:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("không được quá 20 phần tử");
        } while (size > 20);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("nhập phần tử thứ: " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.printf("%-20s%s", "các phần tử của mảng: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        for (int j = 0; j < array.length / 2; j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.printf("%-20s%s", "Reverse array: ", "");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
