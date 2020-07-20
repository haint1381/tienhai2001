package bai_hoc.loop_java.thuchanh;
import java.util.Scanner;
public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("nhập số kiểm tra ");
        int number= scanner.nextInt();
        int count=0;
        for (int i=1;i<number;i++){
            if(number%i==0){
                count++;
            }
        }
        if(count==1){
            System.out.println("là số nguyên tố");
        }else {
            System.out.println("không phải là số nguyên tố");
        }
    }
}
