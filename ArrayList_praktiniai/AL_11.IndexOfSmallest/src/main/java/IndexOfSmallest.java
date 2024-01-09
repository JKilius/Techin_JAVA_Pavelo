
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 9999) break;
            list.add(input);
        }
        System.out.println("");
        Integer min = Collections.min(list);
        System.out.println("Smallest number: "+min);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == min){
                System.out.println(" is at index " + i);
            }
        }

        // implement here a program that reads user input
        // until the user enters 9999

        // after that, the program prints the smallest number
        // and its index -- the smallest number
        // might appear multiple times


    }
}
