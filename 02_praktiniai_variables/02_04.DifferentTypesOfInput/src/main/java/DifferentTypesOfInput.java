
import java.util.Scanner;

public class DifferentTypesOfInput {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Give a string:");
        String strng = scan.nextLine();
        System.out.println("Give an integer:");
        int numInt = Integer.parseInt(scan.nextLine());
        System.out.println("Give a double:");
        double numDbl = Double.parseDouble(scan.nextLine());
        System.out.println("Give a boolean:");
        boolean bool = Boolean.parseBoolean(scan.nextLine());

        System.out.println("You gave the string "+strng);
        System.out.println("You gave the integer "+numInt);
        System.out.println("You gave the double "+numDbl);
        System.out.println("You gave the boolean "+bool);
    }
}
