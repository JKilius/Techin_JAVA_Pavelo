
import java.util.Scanner;

public class SumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr = 0;
        int sum = 0;
        do {
            System.out.println("Give a number:");
            nr = scanner.nextInt();
            if (nr == 0) break;
            sum= sum + nr;
        } while (nr!=0);
        System.out.println("Sum of the numbers: "+sum);
    }
}
