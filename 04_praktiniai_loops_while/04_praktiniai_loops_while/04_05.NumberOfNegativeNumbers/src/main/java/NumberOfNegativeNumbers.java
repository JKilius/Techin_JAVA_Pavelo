
import java.util.Scanner;

public class NumberOfNegativeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr = 0;
        int nrInputs = 0;
        do {
            System.out.println("Give a number:");
            nr = scanner.nextInt();
            if (nr < 0) nrInputs++;
        } while (nr != 0);
        System.out.println("Number of negative numbers: "+(nrInputs));
    }
}