import java.util.Scanner;

public class FindTheNumberOfYears {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of minutes:");
        int numMins = Integer.parseInt(scanner.nextLine());
        System.out.println(numMins+" minutes is approximately "+(numMins/60/24/365)+" years and "+(numMins%(60*24*365)/60/24)+" days");
    }
}
