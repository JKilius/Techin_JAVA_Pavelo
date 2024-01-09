
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Give a year: ");
        int yr = scan.nextInt();
        if ((yr % 4 == 0 && yr % 100 !=0) || yr % 400 == 0) {
            System.out.println("This is a leap year");
        } else System.out.println("The year is not a leap year.");
        }
}
