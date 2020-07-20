package bai_hoc.introduction_to_java.bai_tap;

import  java.util.Scanner;
public class UngDungChuyenTien {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("nhập trị giá usd cần chuyển");
        double exchangerate= scanner.nextDouble();
        double answer=23000*exchangerate;
        System.out.println("giá trị vnd: "+answer);
    }

}
