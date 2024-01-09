
import java.util.Scanner;

public class AverageOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the first number:");
        int num1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the second number:");
        int num2 = Integer.parseInt(scanner.nextLine());
        System.out.println("Give the third number:");
        int num3 = Integer.parseInt(scanner.nextLine());
        System.out.println("The average is "+(double)(num1+num2+num3)/3);

    }
}
