package bai_hoc.mang_va_phuong_thuc_java.baitap;

import java.util.Scanner;

public class KyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập vào đây 1 chuỗi ");
        String chuoi= scanner.nextLine();
        System.out.println("nhập ký tự cần tìm trong chuỗi vừa nhập ở trên");
       char kyTu='h';
        int count=0;
        String index="";
        int i;
        for( i=0;i<chuoi.length();i++){
            char cacKyTuTrongChuoi=chuoi.charAt(i);
            if(kyTu==cacKyTuTrongChuoi){
                count++;
                index += i +",";
            }
        }
        if(count>0){
            System.out.println("có ký tự này số lần lặp:  "+count +" ở các vị trí "+ index);
        }else {
            System.out.println("ký tự bạn nhập không có trong chuỗi");
        }

    }
}
