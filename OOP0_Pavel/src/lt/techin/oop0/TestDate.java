package lt.techin.oop0;

public class TestDate {
    public static void main(String[] args) {
        Date date1 = new Date(1,1,1900);
        Date date2 = new Date(31,12,9999);
        System.out.println(date1+"\n"+date2);
        date1.setDate(15,11,1999);
        System.out.println(date1);
    }
}
