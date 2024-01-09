package lt.techin.oop0;

public class TestInvoiceItem {

    public static void main (String[] args) {
        InvoiceItem apple = new InvoiceItem("001", "Golden apple", 100, 2.0);
        System.out.println(apple);
        apple.setUnitPrice(2.5);
        System.out.println(apple);
        apple.setQty(500);
        System.out.println(apple);
    }
}
