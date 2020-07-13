package dsa_tack_queue.bai_tap.dao_nguoc_phan_tu;

import java.util.Scanner;
import java.util.Stack;

public class ArrayInteger {
    static  Stack<Integer> stack=new Stack<>();
    static  Stack<Integer> stack1=new Stack<>();
    public static Stack reverse(){
        for(int i=stack.size()-1;i>=0;i--){
            stack1.push(stack.pop());
        }
        return stack1;
    }
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);


        int size;
        do {
            System.out.println("Enter the number of elements");
            size=scanner.nextInt();
            if(size>10){
                System.out.println("The number of elements must be less than 10");
            }
        }while (size>10);
         for (int i=0;i<size;i++){
             System.out.println("Enter the number "+(i+1));
             stack.push(scanner.nextInt());
         }
        System.out.println("hello "+reverse());
    }

}
