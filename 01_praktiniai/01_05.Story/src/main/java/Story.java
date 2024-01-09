
import java.util.Scanner;

public class Story {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("I will tell you a story, but I need some information first.\nWhat is the main character called?");
        String name = scanner.nextLine();
        System.out.println("What is their job?");
        String profession = scanner.nextLine();
        System.out.println("Here is the story:\nOnce upon a time there was " + name + ", who was " + profession + ".\nOn the way to work, " + name + " reflected on life.\nPerhaps " + name + " will not be " + profession + " forever.");
    }
}
