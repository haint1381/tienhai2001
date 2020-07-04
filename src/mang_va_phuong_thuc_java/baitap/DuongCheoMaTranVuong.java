package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class DuongCheoMaTranVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("nhập vào kích thước của ma trận vuông:");
            size = scanner.nextInt();
            if (size > 6)
                System.out.println("không được quá 6 oke:");
        } while (size > 6);
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("nhập phần tử thứ: " + "[" + i + "]" + "[" + j + "]" + " : ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("danh sách mảng 2 chiều bạn vừa nhập: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print("[");
            for (int i = 0; i < array[j].length; i++) {
                System.out.print(array[j][i] + "\t");
            }
            System.out.print("]");
            System.out.println();
        }
        int tong=0;
        for (int i = 0; i < array.length; i++) {
            tong+=array[i][i];
        }
        System.out.println("tổng của các phần tử đường chéo:  " +tong);
    }
}
