package bai_hoc.clean_code_refactoring.thuc_hanh.refactoring_tach_phuong_thuc.refactoring_tach_bien;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean number1 = number % 3 == 0;
        boolean number2 = number % 5 == 0;
        if(number1 && number2)
            return "FizzBuzz";

        if(number1)
            return "Fizz";

        if(number2)
            return "Buzz";

        return number + "";
    }
}