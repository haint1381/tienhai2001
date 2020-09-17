package bai_hoc.mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class GiaTriNhoNhatSuDungPhuongThuc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("nhập vào kích thước của mảng:");
            size = scanner.nextInt();
            if (size > 6)
                System.out.println("không được quá 6 oke:");
        } while (size > 6);
        int[] array= new int[size];
        for (int i = 0;i < array.length;i++) {
            System.out.print("nhập phần tử thứ: " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
        }
        System.out.print("[  ");
        for (int a:array){
            System.out.print(a + "\t");
        }
        System.out.println("]");
        int index = minValue(array);
        System.out.println("giá trị nhỏ nhất của mảng vừa nhập lòe: " + array[index]);
    }

    public static int minValue(int[] array) {
        int min=array[0];
        int index=0;
        for (int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
                index=i;
            }
        }
        return index;
    }
}
