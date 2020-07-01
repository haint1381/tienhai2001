package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class TongCacSoO1CotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = {{1, 2}, {3, 4, 6, 8}, {5, 6, 9}};
        int dem = 0;
        System.out.println("cần tính tổng các phần tử của cột thứ: ");
        int cot = scanner.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (cot == i) {
                for (int j = 0; j < arr[i].length; j++) {
                    dem++;
                }
            }
        }
        System.out.println("số phần tử trong mảng " + dem);
        int size;
        int size1;
        System.out.println("tạo mảng mới: ");
        do {
            System.out.print("nhập vào số dòng của mảng:");
            size = scanner.nextInt();
            System.out.print("nhập vào số cột của mảng:");
            size1 = scanner.nextInt();
            if (size > 5 && size1 > 5)
                System.out.println("không được quá 5 ");
        } while (size > 5 && size1 > 5);
        int[][] array = new int[size][size1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("nhập phần tử thứ: " + "[" + i + "]" + "[" + j + "]" + " : ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("danh sách mảng 2 chiều bạn vừa nhập: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print("[");
            for(int i=0;i<array[j].length;i++){
                System.out.print(array[j][i] + "\t");
            }
            System.out.print("]");
            System.out.println();
        }
        int dem1=0;
        System.out.println("nhập cột cần tính đi nèo:  ");
        int cot1 = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (cot1 == i) {
                for (int j = 0; j < array[i].length; j++) {
                    dem1++;
                }
            }
        }
        System.out.println("số phần tử trong mảng " + dem1);
    }

}
