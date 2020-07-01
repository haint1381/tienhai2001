package loop_java.baitap;

import java.util.Scanner;

public class SoNuyenToNhoHonMotTram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 2;
        String result = "";
        while (n<100) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if(check){
                if(n<100){
                result += n+",";
            }
            }
            n++;
        }
        System.out.println("các số nguyên tố nhỏ hơn 100");
        System.out.println(result);
    }
}



