import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // implement here the program that allows the user to enter 
        // book information and to examine them
        ArrayList<Book> programs = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Title:");
            String title = scanner.nextLine();
            if (title.isEmpty()) {
                break;
            } else {
                System.out.print("Pages:");
                int pages = Integer.parseInt(scanner.nextLine());
                System.out.print("Publication year:");
                int year = Integer.parseInt(scanner.nextLine());
                programs.add(new Book(title,pages,year));
            }
        }
        System.out.println();
        System.out.print("What information will be printed? ");
        String printOption = scanner.nextLine();
        for (Book object:programs) {
            if (printOption.equals("everything")) {
                System.out.println(object.toString());
            } else if(printOption.equals("name")) {
                System.out.println(object.getTitle());
            }
        }

        scanner.close();
    }
}

