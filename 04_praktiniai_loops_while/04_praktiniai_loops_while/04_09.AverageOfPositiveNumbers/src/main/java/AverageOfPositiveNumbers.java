
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int i = 0;
        while (true) {
            System.out.println("Give a number:");
            int nr = scanner.nextInt();
            if (nr == 0) break;

            if (nr > 0) {
                sum = sum + nr;
                i++;
            }
        }
        if (i == 0) {
            System.out.println("Cannot calculate the average");
        } else System.out.println((double) sum / i);
    }
}
