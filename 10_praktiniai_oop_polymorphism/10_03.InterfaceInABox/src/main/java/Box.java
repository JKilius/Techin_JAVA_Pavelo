import java.util.ArrayList;
import java.util.List;

public class Box implements Packable {
    private List<Packable> items;
    private double maxWeight;

    public Box(double maxWeightKg) {
        maxWeight = maxWeightKg;
        items = new ArrayList<>();

    }

    public void add(Packable item) {
        if ((item.weight() + weight()) <= maxWeight) items.add(item);
    }



    @Override
    public double weight() {
        double weight = 0;
        for (Packable item:items){
            weight+= item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        return "Box: "+items.size()+" items, total weight "+weight()+" kg";
    }
}
