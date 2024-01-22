package lt.techin.exam;

public class Main {
    public static void main(String[] args) {
        Tasks.convertToMeters(2,20);
        Tasks.convertCentsToEuros(849);
        System.out.println(Tasks.averageOf(3,4,5));
        System.out.println(Tasks.isEven(1,3,5));
        System.out.println(Tasks.isEven(1,3,4));
        Tasks.printOddNumbers(8);
    }

}
