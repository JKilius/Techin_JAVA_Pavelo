
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalInformationCollection {

    public static void main(String[] args) {
        // implement here your program that uses the PersonalInformation class

        ArrayList<PersonalInformation> infoCollection = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("First name:");
            String firstName = scanner.nextLine();
            if (firstName.isEmpty()) {
                break;
            } else {
                System.out.print("Last name:");
                String lastName = scanner.nextLine();
                System.out.print("Identification number:");
                String idNumber = scanner.nextLine();
                infoCollection.add(new PersonalInformation(firstName, lastName, idNumber));
            }
        }
        System.out.println();
        for (PersonalInformation object : infoCollection) {
            System.out.println(object.getFirstName() + " " + object.getLastName());

        }

    }
}
