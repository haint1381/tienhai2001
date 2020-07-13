package dsa_tack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.Scanner;
import java.util.Stack;

public class ArrayString {
    static Stack<Character> stack=new Stack<>();
    static Stack<Character> stack1=new Stack<>();
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter String:");
        String str =scanner.nextLine();
        for (int i=0; i<str.length();i++){
            stack.push(str.charAt(i));
        }
        for (int i=stack.size()-1;i>=0;i--){
            stack1.push(stack.pop());
        }
        System.out.println(stack1);
    }
}
