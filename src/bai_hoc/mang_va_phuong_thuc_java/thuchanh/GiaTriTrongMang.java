package bai_hoc.mang_va_phuong_thuc_java.thuchanh;

import java.util.Scanner;

public class GiaTriTrongMang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("nhập tên học sinh:");
        String input_name = scanner.nextLine();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("vị trí của sinh viên " + input_name + " trong danh sách là: " + (i));
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("không có " + input_name + " trong danh sách.");
    }
}
