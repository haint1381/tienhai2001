package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        System.out.println("danh sách các phần tử đã nhập: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        System.out.println("nhập phần tử cần thêm: ");
        int number= scanner.nextInt();
        System.out.println("nhập vị trí phần tử cần thêm: ");
        int index=scanner.nextInt();
        int temp=0;
        for(int h=array.length-1;h>index;h--){
            array[h] = array[h-1];
        }
        array[index] = number;
        System.out.println("danh sách các phần tử sau khi thêm: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

    }
}
