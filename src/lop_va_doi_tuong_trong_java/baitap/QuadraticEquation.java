package lop_va_doi_tuong_trong_java.baitap;

import java.util.Scanner;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập a ");
        double a = scanner.nextDouble();
        System.out.print("nhập b ");
        double b = scanner.nextDouble();
        System.out.print("nhập c ");
        double c = scanner.nextDouble();
        PhuongTrinh phuongTrinh=new PhuongTrinh(a,b,c);
        if(phuongTrinh.getDiscriminant()>0){
            System.out.println("phương trình có 2 nghiệm:");
            System.out.println("X1= "+phuongTrinh.getRoot1());
            System.out.println("X2= "+phuongTrinh.getRoot2());
        }else if(phuongTrinh.getDiscriminant()==0){
            System.out.println("phương trình có 1 nghiệm:");
            System.out.println("X1= X2 ="+phuongTrinh.getRoot1());
        }else {
            System.out.println("phương trình vô nghiệm");
        }
    }
}

class PhuongTrinh {
    double a, b, c;

    public PhuongTrinh(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        return (-b + Math.pow(getDiscriminant(), 0.5)) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.pow(getDiscriminant(), 0.5)) / (2 * a);
    }
}