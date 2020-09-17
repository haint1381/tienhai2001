package bai_hoc.introduction_to_java.thuc_hanh;
import java.util.Scanner;
public class Nam_Nhuan {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("nhập năm cần kiểm tra");
        int nam=scanner.nextInt();
        if(nam%4==0){
            if(nam%100==0){
                if(nam%400==0){
                    System.out.printf("%d là năm nhuận ",nam);
                }else {
                    System.out.printf("%d không phải là năm nhuận ",nam);
                }
            }else {
                System.out.printf("%d là năm nhuận ",nam);
            }
        }else {
            System.out.printf("%d không phải là năm nhuận ",nam);
        }
    }
}
