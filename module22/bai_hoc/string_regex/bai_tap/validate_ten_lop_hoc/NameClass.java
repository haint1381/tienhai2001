package bai_hoc.string_regex.bai_tap.validate_ten_lop_hoc;

import java.util.Scanner;

public class NameClass {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("input class name");
        String name=scanner.nextLine();
        ValidateClass validateClass=new ValidateClass();
        System.out.println(validateClass.validate(name));
    }
}
