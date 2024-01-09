
import java.util.Scanner;

public class OnlyPositives {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nr = 0;
        do {
            System.out.println("Give a number:");
            nr = scanner.nextInt();
            if (nr < 0) {
                System.out.println("Unsuitable number:");
            } else if (nr > 0) {
                System.out.println(nr * nr);
            }
        } while (nr != 0);
    }
}