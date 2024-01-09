import java.util.Scanner;

import static java.lang.String.format;

public class ConvertMileToKilometer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter miles");
        double numDbl = Double.parseDouble(scanner.nextLine());
        System.out.println(numDbl + " is " + format("%.1f", (numDbl * 1.6)) + " kilometers");
    }
}
