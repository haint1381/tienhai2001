package dsa_tack_queue.bai_tap.thap_phan_sang_he_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class BinarySystem {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> stack1=new Stack<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number:");
        int number=scanner.nextInt();
        while ( number!=0 ){
            stack.push((number%2));
           number=number/2;
        }
        System.out.println("result: "+stack);

         String string="";
        for (int i=stack.size()-1;i>=0;i--){
            stack1.push(stack.pop());
        }
         for (int i=stack1.size();i>0;i--){
             string+=stack1.pop();
         }
        System.out.println(string);
    }
}
