
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First number? ");
        int numberFirst = scanner.nextInt();
        System.out.print("Last number? ");
        int numberLast = scanner.nextInt();
        int sum = 0;
        for (int i = numberFirst; i <= numberLast ; i++) {
            sum = sum + i;
        }
        System.out.println("The sum is "+sum);

    }
}
