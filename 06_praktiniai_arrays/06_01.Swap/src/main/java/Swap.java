
import java.util.Scanner;

public class Swap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[5];

        array[0] = 1;
        array[1] = 3;
        array[2] = 5;
        array[3] = 7;
        array[4] = 9;

        int index = 0;
        while (index < array.length) {
            System.out.println(array[index]);
            index++;
        }
        System.out.println("");
        System.out.println("Give two indices to swap");
        int indice1 = scanner.nextInt();
        int indice2 = scanner.nextInt();
        int temp1 = array [indice1];
        int temp2 = array [indice2];
        array [indice1] = temp2;
        array [indice2] = temp1;


        System.out.println("");
        index = 0;
        while (index < array.length) {
            System.out.println(array[index]);
            index++;
        }
    }

}
