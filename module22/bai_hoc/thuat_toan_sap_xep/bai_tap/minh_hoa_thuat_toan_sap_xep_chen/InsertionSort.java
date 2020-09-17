package bai_hoc.thuat_toan_sap_xep.bai_tap.minh_hoa_thuat_toan_sap_xep_chen;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập kích thước:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("nhập " + list.length + " giá trị:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("hiển thị mảng: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nxử lý sắp xếp...");
        InsertionSort(list);
        System.out.println("sắp xếp xong: ");
        for (int a=0;a<list.length;a++){
            System.out.print(list[a] + " ");
        }
    }
    public static void InsertionSort(int[] list){
        for (int i = 0; i < list.length; i++) {
            System.out.println();
            System.out.print("(");
            System.out.println("gán key tại i= "+i+" là: "+list[i]);
            int key = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > key; j--) {
                System.out.println("gán vị trí thứ "+(j+1)+" = "+list[j]);
                list[j + 1] = list[j];
            }
            System.out.println("gán vị trí thứ "+(j + 1)+" = "+key);
            list[j + 1] = key;
            for (int a=0;a<list.length;a++){
                System.out.print(list[a] + " ");
            }
            System.out.print(")");
            System.out.println();
        }
    }

}
