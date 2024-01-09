
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int nrEven = 0;
        int nrOdd = 0;
        int i = 0;
        while (true) {
            System.out.println("Give numbers:");
            int nr = scanner.nextInt();
            if (nr == -1) {
                System.out.println("Thx! Bye!");
                break;
            }
            if (nr % 2 == 0) {
                sum = sum + nr;
                nrEven++;
                i++;
            } else {
                sum = sum + nr;
                nrOdd++;
                i++;
            }

        }
        System.out.println("Sum: "+sum);
        System.out.println("Numbers: "+i);
        System.out.println("Average: "+((double)sum/i));
        System.out.println("Even: "+nrEven);
        System.out.println("Odd: "+nrOdd);
    }
}
