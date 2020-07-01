package loop_java.baitap;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng số cần hiển thị");
        int number = scanner.nextInt();
        int count = 0;
        int n = 2;
        String result = "";
        while (count < number) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
                if (count == number) {
                    result += n;
                } else {
                    result += n + ",";
                }
            }
            n++;
        }
        System.out.println(result);
    }
}
