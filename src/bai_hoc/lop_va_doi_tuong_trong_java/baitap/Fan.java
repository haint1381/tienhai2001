package bai_hoc.lop_va_doi_tuong_trong_java.baitap;

import java.util.Scanner;

public class Fan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fan1 fan1 = new Fan1(1, true, "yellow", 10);
        System.out.println("quạt gốc");
        System.out.println(fan1.toString());
        System.out.println();

        System.out.println("thiết đặt lại cho quạt");


        System.out.print("nhập tốc độ quạt :");
        int number = scanner.nextInt();
        fan1.setSpeed(number);

        scanner.nextLine();

        System.out.print("Nhập màu quạt đi nèo: ");
        String color = scanner.nextLine();
        fan1.setColor(color);

        System.out.print("nhập bán kính quạt :");
        double r = scanner.nextDouble();
        fan1.setRadius(r);

        System.out.print("nhập trạng thái quạt :");
        boolean status = scanner.nextBoolean();
        fan1.setOn(status);

        System.out.println("thông tin quạt của quạt ");
        System.out.println(fan1.toString());
    }
}

class Fan1 {
    private static final int SLOW = 1;
    private static final int MEDIUM = 2;
    private static final int FAST = 3;
    private int speed = 1;
    private boolean on = false;
    private String color = "blue";
    private double radius = 5;

    public Fan1(int speed, boolean on, String color, double radius) {
        this.speed = speed;
        this.on = on;
        this.color = color;
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean getisOn() {
        return on;
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        String display = "";
        if (this.getisOn()) {
            display += ("Fan is on\n");
            display += ("Speed: " + this.speed + "\n");
        } else {
            display += ("Fan is off \n");
        }
        display += ("Color: " + this.color + "\n");
        display += ("Radius: " + this.radius + "\n");
        return display;
    }
}
