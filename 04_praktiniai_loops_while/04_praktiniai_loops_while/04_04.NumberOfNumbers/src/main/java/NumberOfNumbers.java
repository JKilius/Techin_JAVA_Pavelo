
import java.util.Scanner;

public class NumberOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr = 0;
        int nrInputs = 0;
        do {
            System.out.println("Give a number:");
            nr = scanner.nextInt();
            nrInputs++;
        } while (nr != 0);
        System.out.println("Number of numbers: "+(nrInputs-1));
    }
}