package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];
        int i = 0;
        System.out.println("Mảng 1: ");
        while (i < array.length) {
            System.out.print("nhập phần tử thứ: " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        int[] array1 = new int[5];
        int j = 0;
        System.out.println("Mảng 2: ");
        while (j < array1.length) {
            System.out.print("nhập phần tử thứ: " + (j + 1) + " : ");
            array1[j] = scanner.nextInt();
            j++;
        }
        System.out.println("danh sách mảng 1: ");
        for (int v= 0; v < array.length; v++) {
            System.out.print(array[v] + "\t");
        }
        System.out.println();
        System.out.println("danh sách mảng 2: ");
        for (int v= 0; v < array1.length; v++) {
            System.out.print(array1[v] + "\t");
        }
        System.out.println();
        int[] array3 = new int[array1.length + array.length];
        for (int h = 0; h < array.length; h++) {
            array3[h] = array[h];
        }
        for (int e = 0; e < array1.length; e++) {
            array3[array.length + e] = array1[e];
        }
        System.out.println("danh sách sau khi gộp: ");
        for (int v= 0; v < array3.length; v++) {
            System.out.print(array3[v] + "\t");
        }
    }
}
