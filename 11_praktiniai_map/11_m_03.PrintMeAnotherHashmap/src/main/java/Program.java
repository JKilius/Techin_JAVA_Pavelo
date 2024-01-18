
import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        // Test your program here!

    }


    public static void printValues (HashMap<String,Book>hashMap){

        hashMap.values().stream().forEach(System.out::println);
//        for (Book value: hashMap.values()){
//            System.out.println(value);
//        }

    }
    public static void  printValueIfNameContains (HashMap<String,Book> hashmap, String text){
        hashmap.values().stream()
                .filter(value-> value.getName().contains(text))
                .forEach(System.out::println);
    }
}
