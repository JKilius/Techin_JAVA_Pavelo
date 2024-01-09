
import java.sql.SQLOutput;
import java.util.Scanner;

public class Password {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Password?");
        String passIn = scan.nextLine();
        String passDef = "Caput Draconis";
        if (passIn.equals(passDef)) {
            System.out.println("Welcome!");
        } else System.out.println("Off with you!");

    }
}
