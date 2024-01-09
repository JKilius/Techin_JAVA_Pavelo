import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // write testcode here
//        int [] values = {6,5,8,7,11};
//        System.out.println("smallest: "+smallest(values));
//        System.out.println("Index of the smallest: "+indexOfTheSmallest(values));
//        System.out.println(indexOfTheSmallestStartingFrom(values,1));
//        System.out.println(indexOfTheSmallestStartingFrom(values, 2));
//        System.out.println(indexOfTheSmallestStartingFrom(values, 3));

//        int[] values = {3, 2, 5, 4, 8};
//        System.out.println(Arrays.toString (values) );
//        swap (values, 1, 0);
//        System.out.println( Arrays.toString (values) );
//        swap (values, 0, 3);
//        System.out.println( Arrays.toString (values) );
////[3, 2, 5, 4, 8] [2, 3, 5, 4, 8] [4, 3, 5, 2, 8]
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);
    }

    public static int smallest(int[] array) {
        int smallest = Integer.MAX_VALUE;
        for (int nr : array) {
            if (nr < smallest) {
                smallest = nr;
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array) {
        int smallest = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }
        return index;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int indexFrom) {
        int smallest = Integer.MAX_VALUE;
        int index = -1;
        for (int i = indexFrom; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int index1 = 0; index1 < array.length - 1; index1++) {
//            System.out.println(Arrays.toString(array));
            int index2 = indexOfTheSmallestStartingFrom(array, index1);
            if (array[index1] > array[index2]) {
                swap(array, index1, index2);
            }
        }
    }
}
