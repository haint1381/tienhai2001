package bai_hoc.string_regex.bai_tap.validate_so_dien_thoai;

import java.util.Scanner;

public class TelephoneTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        TelephoneNumber telephoneNumber=new TelephoneNumber();
        System.out.println("enter telerphone number:");
        String telephone=scanner.nextLine();
        System.out.println(telephoneNumber.validate(telephone));
    }
}
