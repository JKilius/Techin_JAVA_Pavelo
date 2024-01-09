import java.util.ArrayList;
import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<String>();
        System.out.print("Type a input: ");
        String input = reader.nextLine();
        while (!input.isEmpty()) {
            words.add(input);
            System.out.print("Type a input: ");
            input = reader.nextLine();
        }
        System.out.println("You typed the following words: ");
        for (String word:words) {
            System.out.println(word);

        }
    }
}
/*
ArrayList<String> words = new ArrayList<>();

        while (true) {
            System.out.println("Enter a word:");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            words.add(input);
        }

        System.out.println("You entered:");
        for (String word : words) {
            System.out.println(word);
        }
 */