import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WordsInReverseOrder {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        while (true) {
            System.out.print("Type a word: ");
            String word = reader.nextLine();
            if (word.isEmpty()) break;
            words.add(word);
        }
        System.out.println("You typed the following words:");
        for (int i = words.size()-1; i >= 0 ; i--) {
            System.out.println(words.get(i));
        }

    }
}
