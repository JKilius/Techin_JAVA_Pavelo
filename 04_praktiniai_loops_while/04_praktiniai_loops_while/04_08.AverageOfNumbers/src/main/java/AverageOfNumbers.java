
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int nr = 1;
        int i = -1;
        while (nr != 0) {
            System.out.println("Give a number:");
            nr = scanner.nextInt();
            sum = sum + nr;
            i++;
        }
        System.out.println("Average of the numbers: " + ((double) sum / i));
    }
}
