public class ProductWarehouse extends Warehouse{
    private String name;
    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        name =productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    @Override
    public String toString() {
        return name+": "+super.toString();
    }
}
