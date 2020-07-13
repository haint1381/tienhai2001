package dsa_tack_queue.bai_tap.kiem_tra_chuoi_palindrome;

import java.util.*;

public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter string: ");
        String str=scanner.nextLine().toLowerCase();
        Stack<Character> stack =new Stack<>();
        for (int i=0; i<str.length();i++){
            stack.push(str.charAt(i));
        }
        Queue<Character> queue = new LinkedList<>();
        for (int i=0; i<str.length();i++){
            queue.add(str.charAt(i));

        }
        boolean check=false;
        for (int i=0; i<stack.size();i++){
            if(stack.pop()==queue.poll()){
                check=true;
            }else check=false;
            break;
        }
        if(check==true){
            System.out.println("Palindrome");
        }else {
            System.out.println("Not Palindrome");
        }
    }
}
