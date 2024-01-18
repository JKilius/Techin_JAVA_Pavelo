import java.util.HashMap;

public class IOU {
    private HashMap<String,Double> hashMap;
    public IOU() {
        hashMap= new HashMap<>();
    }
    public void setSum(String toWhom, double amount){
       hashMap.put(toWhom,amount);
       //hashMap.replace(toWhom,amount);
    }
    public double howMuchDoIOweTo (String toWhom){
        if (toWhom == null || toWhom.isBlank()) return 0.0;
        if (!hashMap.containsKey(toWhom)) return 0.0;
        return hashMap.get(toWhom);
    }
}
