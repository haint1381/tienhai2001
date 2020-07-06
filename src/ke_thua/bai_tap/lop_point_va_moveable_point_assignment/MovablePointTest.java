package ke_thua.bai_tap.lop_point_va_moveable_point_assignment;

import java.util.Scanner;

public class MovablePointTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter X");
        float x = scanner.nextFloat();
        System.out.println("Enter Y");
        float y = scanner.nextFloat();
        System.out.println("Enter XSpeed");
        float xSpeed = scanner.nextFloat();
        System.out.println("Enter YSpeed");
        float ySpeed = scanner.nextFloat();
        MoveablePoint moveablePoint= new MoveablePoint(x,y,xSpeed,ySpeed);
        System.out.println(moveablePoint.toString());
        float[] array = {x,y};
        System.out.println(moveablePoint.movablePointMove(array));
    }
}
