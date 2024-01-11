
import java.util.ArrayList;
import java.util.Scanner;

public class Items {

    public static void main(String[] args) {
        // implement here your program that uses the class Item

        ArrayList<Item> itemsArray = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String name = scanner.nextLine();
            if (name.isEmpty() || name.trim().isEmpty()) {
                break;
            } else {
//                Item itemObject = new Item(name);
//                itemsArray.add(itemObject);
                itemsArray.add(new Item(name));
            }

        }
        for (Item item : itemsArray) {
            System.out.println(item.toString());
        }
//        for (int i = 0; i < itemsArray.size(); i++) {
//            itemsArray.get(i).getName()
//        }
    }
}
