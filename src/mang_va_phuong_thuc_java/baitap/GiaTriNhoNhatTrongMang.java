package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class GiaTriNhoNhatTrongMang {
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
        System.out.println("danh sách của mảng: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int min = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
                index = j;
            }
        }
        System.out.println("giá trị nhỏ nhất trong mảng là " + min + " ,vị trí thứ: " + index);
    }
}
