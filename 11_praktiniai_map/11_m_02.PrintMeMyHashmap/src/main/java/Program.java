
import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
        HashMap<String, String> map = new HashMap<>();
        map.put("abbreviation", "explanation");
        map.put("abbreviate", "shorten");
        map.put("example", "sample");

        printKeysWhere(map, "abbrev");
        printValuesOfKeysWhere(map, "abbrev");
    }

    public static void printKeys(HashMap<String, String> hashmap) {
        for (String key : hashmap.keySet()) {
            System.out.println(key);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        hashmap.entrySet().stream().filter(entry -> entry.getKey().contains(text)).map(Map.Entry::getKey).forEach(System.out::println);
//    for (String key:hashmap.keySet()){
//        if(key.contains(text)) System.out.println(key);
//    }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        hashmap.entrySet().stream().filter(entry -> entry.getKey().contains(text)).map(Map.Entry::getValue).forEach(System.out::println);
//    for (String key:hashmap.keySet()){
//        if(key.contains(text)) System.out.println(hashmap.get(key));
//    }
    }
}
