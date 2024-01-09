
import java.util.Scanner;

public class AreWeThereYet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr = 0;
        while (nr != 4) {
            System.out.println("Give a number:");
            nr = scanner.nextInt();
        }
    }
}
