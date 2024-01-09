import java.util.Scanner;
import java.lang.Math;

public class DistanceBetweenPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter x1:");
        double x1 = input.nextDouble();
        System.out.println("Enter y1:");
        double y1 = input.nextDouble();

        System.out.println("Enter x2:");
        double x2 = input.nextDouble();
        System.out.println("Enter y2:");
        double y2 = input.nextDouble();

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        System.out.println("The distance between the two points is " + distance);
    }
}