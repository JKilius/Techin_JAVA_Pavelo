public class Product {
    private double price;
    private int quantity;
    private  String name;

    public Product(String initialName, double initialPrice, int initialQuantity) {
        this.name=initialName;
        this.price=initialPrice;
        this.quantity=initialQuantity;
    }
    public void printProduct(){
        System.out.println(name+", price "+price+", "+quantity+" pcs");
    }
}
