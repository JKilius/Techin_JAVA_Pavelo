
import java.util.Scanner;

public class FromWhereToWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Where to? ");
        int whereTo = scanner.nextInt();
        System.out.print("Where from? ");
        int from = scanner.nextInt();


        for (int i = from; i <= whereTo ; i++) {
            System.out.println(i);
        }
    }
}
