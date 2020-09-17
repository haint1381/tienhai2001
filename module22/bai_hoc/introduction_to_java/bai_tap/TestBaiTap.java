package bai_hoc.introduction_to_java.bai_tap;
import java.util.Scanner;
public class TestBaiTap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;
        do {
            password = sc.nextLine();
            if(password != "hello"){
                System.out.println("sai mk");
            }
        } while (password != "hello");
        }
    }
