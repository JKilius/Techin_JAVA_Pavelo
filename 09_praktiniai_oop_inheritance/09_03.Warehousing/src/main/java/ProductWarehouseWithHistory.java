public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory changeHistory = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        changeHistory.add(initialBalance);
    }

    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        changeHistory.add(getBalance());
    }

    public double takeFromWarehouse(double amount) {
        double result = super.takeFromWarehouse(amount);
        changeHistory.add(getBalance());
        return result;
    }

    public void printAnalysis(){
        System.out.println(
                "Product:"+ getName()+ "\n" +
                        "History: "+changeHistory+"\n" +
                        "Largest amount of product: "+ changeHistory.maxValue()+"\n" +
                        "Smallest amount of product: "+changeHistory.minValue()+"\n" +
                        "Average: "+changeHistory.average()
        );
    }
    public String history() {
        return changeHistory.toString();
    }
}
