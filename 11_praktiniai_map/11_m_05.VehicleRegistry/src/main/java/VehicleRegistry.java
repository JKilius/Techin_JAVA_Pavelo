import java.rmi.registry.Registry;
import java.util.*;

public class VehicleRegistry {
    private HashMap <LicensePlate, String > hashMap;

    public VehicleRegistry() {
        hashMap=new HashMap<>();
    }

    public boolean add (LicensePlate licensePlate, String owner){
        if (hashMap.containsKey(licensePlate)) {
            return false;
        }
        hashMap.put(licensePlate,owner);
        return true;
    }
    public String get(LicensePlate licensePlate){
        if (hashMap.containsKey(licensePlate)) return hashMap.get(licensePlate);
        return null;
    }

    public boolean remove (LicensePlate licensePlate){
        if (hashMap.containsKey(licensePlate)){
            hashMap.remove(licensePlate);
            return true;
        }
        return false;
    }
    public void printLicensePlates(){
        hashMap.keySet().forEach(System.out::println);
    }
    public void printOwners(){
        Set<String> presentOwners= new HashSet<>(hashMap.values());
        presentOwners.forEach(System.out::println);
//        List<String> presentOwners = new ArrayList<>();
//        for (String value: hashMap.values()){
//            if (!hashMap.containsValue(value)) presentOwners.add(value);
//        }
//        presentOwners.forEach(System.out::println);

    }
}
