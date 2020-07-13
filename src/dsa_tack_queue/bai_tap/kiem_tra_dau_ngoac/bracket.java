package dsa_tack_queue.bai_tap.kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class bracket {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter math expression: ");
        String string = scanner.nextLine();
        boolean check = true;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '(') {
                stack.push(string.charAt(i));
            }
            if (string.charAt(i) == ')') {
                if (stack.size() <= stack1.size()) {
                    check = false;
                    break;
                } else {
                    stack1.push(string.charAt(i));
                }
            }
        }
        if (stack.size() != stack1.size()) {
            check = false;

        }
        if (check == false) {
            System.out.println("Invalid mathematical expression");
        } else {
            System.out.println("Valid mathematical expression");
        }
    }
}
