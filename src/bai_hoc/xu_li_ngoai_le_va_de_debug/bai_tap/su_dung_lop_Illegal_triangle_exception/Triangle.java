package bai_hoc.xu_li_ngoai_le_va_de_debug.bai_tap.su_dung_lop_Illegal_triangle_exception;

import java.util.Scanner;

public class Triangle {
    public static void rightTriangle(int side1, int side2, int side3) throws IllegalRightTriangleException {
        if (side1<0 ||side2<0||side3<0) {
            throw new IllegalRightTriangleException("edge is negative number");
        } else if(side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1){
            throw new IllegalRightTriangleException("Not a triangle ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter side Triangle ");
        try {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            Triangle.rightTriangle(a,b,c);

        }catch (IllegalRightTriangleException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println("enter is not number");
        }
        System.out.println("ok");
    }
}
