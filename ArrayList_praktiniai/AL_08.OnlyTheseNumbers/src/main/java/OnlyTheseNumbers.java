
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlyTheseNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == -1) {
                break;
            }

            numbers.add(number);
        }
        System.out.print("From where? ");
        int startNr = scanner.nextInt();
        System.out.print("To where? ");
        int endNr = scanner.nextInt();
        List<Integer> sublist = numbers.subList(startNr,endNr+1);
        System.out.println(sublist);
    }
}
