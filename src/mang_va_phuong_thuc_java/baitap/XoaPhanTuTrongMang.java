package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class XoaPhanTuTrongMang {
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
        System.out.println("nhập phần tử cần xóa: ");
        int number= scanner.nextInt();
        int index=0;
        for(int k=0;k<array.length;k++){
            if(number==array[k]){
                index=k;
                break;
            }
        }
        for (int h=index ; h<array.length-1; h++){
            array[h]=array[(h+1)];
        }
        int []array1= new int[array.length-1];
        for(int z=0;z<array.length-1;z++){
            array1[z]=array[z];
        }
        System.out.println("danh sách các phần tử sau khi xóa: ");
        for (int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + "\t");
        }
    }
}
