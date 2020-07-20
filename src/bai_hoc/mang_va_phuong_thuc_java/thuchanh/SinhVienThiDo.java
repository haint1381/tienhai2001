package bai_hoc.mang_va_phuong_thuc_java.thuchanh;
import java.util.Scanner;
public class SinhVienThiDo {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("nhập vào kích thước:");
            size = scanner.nextInt();
            if (size > 30)
                System.out.println("kích thước không được quá 30");
        } while (size > 30);
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("nhập điểm của các sinh viên " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
            i++;
        }
        int count = 0;
        System.out.print("danh sách điểm: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\n các sinh viên đã đỗ: " + count);
    }
}
