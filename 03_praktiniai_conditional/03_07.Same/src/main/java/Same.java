
import java.util.Scanner;

public class Same {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String st1 = scan.nextLine();
        System.out.println("Enter the second string:");
        String st2 = scan.nextLine();

        String passDef = "Caput Draconis";
        if (st1.equals(st2)) {
            System.out.println("Same");
        } else System.out.println("Different");
    }
}
