package lt.techin.oop0;

public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new Account("001","Kirkilas Tomas");
        Account account2= new Account("002","Maryte Babyte",1000);
        System.out.println(account1+"\n"+account2);
        int transfer = 100;
        System.out.println("Transfering: "+transfer+", from "+account2.getID()+" to "+account1.getID());
        account2.transferTo(account1,transfer);
        System.out.println(account1+"\n"+account2);
        int transfer2 = 200;
        System.out.println("Transfering: "+transfer2+", from accID = "+account1.getID()+" to accID = "+account2.getID());
        account1.transferTo(account2,transfer2);
    }
}
