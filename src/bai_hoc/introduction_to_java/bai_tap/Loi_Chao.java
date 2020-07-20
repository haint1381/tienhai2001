package bai_hoc.introduction_to_java.bai_tap;

import java.util.Scanner;
public class Loi_Chao {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập tên của bạn");
        String ten=scanner.nextLine();
        System.out.println("hello "+ten);
    }
}
