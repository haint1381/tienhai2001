package mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class PhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        //Scanner scanner =new Scanner(System.in);
        int[][] diem = {{1, 2}, {3, 4}, {5, 6}};
//        int[][] diem = new int[2][2];
//        for(int i =0; i < diem.length; i++){
//            for(int j =0; j< diem[i].length; j++){
//                diem[i][j] = (int)Math.floor(Math.random() * 10);
//            }
//        }
        for(int i =0; i < diem.length; i++){
            for(int j =0; j< diem[i].length; j++){
                System.out.print(diem[i][j] + "\t");
            }
            System.out.println();
        }

        int index1 = 0;
        int index2 =0;
        int max = diem[0][0];
        for (int i=0; i<diem.length; i++){
            for (int j=0; j<diem[i].length; j++){
                if (diem[i][j] > max) {
                    max = diem[i][j];
                    index1 = i;
                    index2 = j;
                }
            }
        }
        System.out.println(max+" vị trí "+"["+index1+"]"+"["+index2+"]");
    }
}
