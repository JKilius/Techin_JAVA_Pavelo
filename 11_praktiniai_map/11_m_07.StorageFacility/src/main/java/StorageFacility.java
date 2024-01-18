import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> units;

    public StorageFacility() {
        units = new HashMap<>();
    }

    public void add(String unit, String item) {
        ArrayList<String> items;
        if (units.containsKey(unit)) {
            items = units.get(unit);
        } else {
            items = new ArrayList<>();
        }
        items.add(item);
        units.put(unit, items);

    }

    public ArrayList<String> contents(String storageUnit) {
        if (units.containsKey(storageUnit)) return units.get(storageUnit);
        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item) {
        ArrayList<String> items;
        if (units.containsKey(storageUnit)) {
            items = units.get(storageUnit);
            items.remove(item);
            if (items.isEmpty()) units.remove(storageUnit);
        }
    }

    public ArrayList<String> storageUnits() {
        ArrayList<String> unitsNames = new ArrayList<>();
//        for (String key : units.keySet()) {
//            if (!units.get(key).isEmpty()) unitsNames.add(key);
//        }
        units.keySet().stream().filter(key -> !units.get(key).isEmpty()).forEach(unitsNames::add);
        return unitsNames;
    }
}
