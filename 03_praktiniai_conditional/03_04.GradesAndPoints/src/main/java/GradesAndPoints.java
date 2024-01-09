
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give points [0-100]:");
        int num = sc.nextInt();

        if (num < 0) {
            System.out.println("Grade: impossible!");
        } else if (num > 100) {
            System.out.println("Grade: incredible!");
        } else if (num >= 90) {
            System.out.println("Grade: 5");
        } else if (num >= 80) {
            System.out.println("Grade: 4");
        } else if (num >= 70) {
            System.out.println("Grade: 3");
        } else if (num >= 60) {
            System.out.println("Grade: 2");
        } else if (num >= 50) {
            System.out.println("Grade: 1");
        } else if (num >= 0) {
            System.out.println("Grade: failed");
        }
    }
}