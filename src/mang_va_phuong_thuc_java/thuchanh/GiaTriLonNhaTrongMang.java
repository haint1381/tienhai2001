package mang_va_phuong_thuc_java.thuchanh;

import java.util.Scanner;

public class GiaTriLonNhaTrongMang {
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
            System.out.print("nhập phần tử thứ: " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.println("danh sách tài sản: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("tỉ phú trong danh sách là " + max + " ,vị trí thứ: " + index);
    }
}
