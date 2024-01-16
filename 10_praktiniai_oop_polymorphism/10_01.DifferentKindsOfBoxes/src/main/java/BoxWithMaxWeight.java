import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private int capacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if ((item.getWeight() + getTotalWeight()) <= capacity) items.add(item);

    }

    public int getTotalWeight() {
        int totalWeigth = 0;
        for (Item item : items) totalWeigth += item.getWeight();
        return totalWeigth;
    }


    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}
