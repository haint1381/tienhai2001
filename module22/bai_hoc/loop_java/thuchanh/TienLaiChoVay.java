package bai_hoc.loop_java.thuchanh;

import java.util.Scanner;

public class TienLaiChoVay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số tiền cho vay");
        double sotienchovay = scanner.nextDouble();
        System.out.println("nhập  lãi suất theo tháng");
       double laisuat = scanner.nextDouble();
        System.out.println("số tháng cho vay");
        int sothangchovay = scanner.nextInt();
        double sotienlai= sotienchovay*(laisuat/100)/(12*sothangchovay);
        System.out.println("số tiền lãi "+ sotienlai);
    }
}
