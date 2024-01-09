
import java.util.Scanner;

public class Positivity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give number:");
        int num = sc.nextInt();
        if (num > 0) {
            System.out.println("The number is positive");

        } else System.out.println("The number is not positive");
    }
}
