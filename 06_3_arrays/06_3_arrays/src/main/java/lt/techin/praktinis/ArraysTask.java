package lt.techin.praktinis;

import java.util.Random;

public class ArraysTask {


    public static void main(String[] args) {
        // Įgyvendikite visus metodus (turi pažaliuoti unit testai)
        // Pateiktas masyvas ir pavyzdys programos patikrinimui. Masyvo elementų reikšmes galite keisti.

        int[] arr = {3, 2, 1, 4, 6, 5};

        int minMark = getMin(arr);
        System.out.printf("Min mark: %d\n", minMark);

    }

    // Parašykite metodą, kuris sukuria nustatyto dydžio sveikųjų skaičių masyvą
    // ir užpildo jį atsitiktinai sugeneruotais skaičiais iš nurodyto intervalo.
    public static int[] generateRandomArray(int size, int min, int max) {
        int[] arrX = new int[size];
        Random r = new Random();
        for (int i = 0; i < arrX.length; i++) {
            int randomNum = max == min ? min : r.nextInt(max - min) + min;
            arrX[i] = randomNum;
        }
        return arrX;
    }


    //Parašykite metodą, kuris pašalintų masyvo arr[n] k-tąjį elementą (su indeksu k),
    //surašant reikiamus elementus į naują masyvą b[n-1]. Metodas grąžina naują masyvą.
    //Jei k yra už masyvo ribų, metodas grąžina null (teisingiau būtų mesti exception, bet dar nesimokėm)
    public static int[] removeElementAndReturnNewArray(int[] arr, int k) {
        if (k < 0 || k > arr.length - 1) {
            return null;
        }
        int[] b = new int[arr.length - 1];
        for (int i = 0; i < arr.length; i++)
            if (i < k) {
                b[i] = arr[i];
            } else if (i > k) {
                b[i - 1] = arr[i];
            }
           return b;
    }

    //Parašykite metodą, kuris įterptų į masyvą arr[n] prieš k-tąjį elementą reikšmę x,
    //surašant reikiamus elementus į naują masyvą b[n+1]. Metodas grąžina naują masyvą.
    //Jei k yra už masyvo ribų, metodas grąžina null (teisingiau būtų mesti exception, bet dar nesimokėm)
    public static int[] insertElementAndReturnNewArray(int[] arr, int k, int x) {
        if (k < 0 || k > arr.length-1) {
            return null;
        }
        int[] b = new int[arr.length + 1];
        for (int i = 0; i < k; i++) {
            b[i] = arr[i];
        }
        b[k] = x;
        for (int i = k; i < arr.length; i++) {
            b[i + 1] = arr[i];
        }
        return b;
    }
    //Parašykite metodą, kuris grąžintų duoto masyvo apverstą kopija.
    public static int[] reverseArray(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i]= arr[arr.length-1-i];
        }

        return newArr;
    }

    //Parašykite metodą, kuris apverstu duotą masyvą (nekuriant naujo masyvo)
    public static void reverseInPlace(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length/2; i++) {
                temp = arr[i];
                arr[i] = arr[arr.length-i-1];
                arr[arr.length-i-1]= temp;
        }
    }


    //Metodas turi grąžinti pirmą masyvo elementą
    public static int getFirstElement(int[] arr) {
        //TODO
        return arr[0];
    }

    //Metodas turi grąžinti paskutinį masyvo elementą
    public static int getLastElement(int[] arr) {
        //TODO
        return 0;
    }

    //Raskite mažiausią masyvo elementą
    public static int getMin(int[] arr) {
        //TODO
        return 0;
    }

    //Raskite didžiausią masyvo elementą
    public static int getMax(int[] arr) {
        //TODO
        return 0;
    }

    //Suskaičiuokite masyvo elementų sumą
    public static int getSum(int[] arr) {
        //TODO
        return 0;
    }

    //Raskite masyvo elementų vidurkį
    public static int getAverage(int[] arr) {
        //TODO
        return 0;
    }


    //Suskaičiuokite kiek masyve yra skaičių, didesnių nei duotas skaičius n
    public static int countElements(int[] arr, int n) {
        //TODO
        return 0;
    }

    //Metodas turi grąžinti true, jei masyve yra elementas kurio reikšmė lygi n
    public static boolean contains(int[] arr, int n) {
        //TODO
        return false;
    }

    //Raskite elemento kurio reikšmė lygi n paskutinį indeksą
    public static int lastIndexOf(int[] arr, int n) {
        //TODO
        return 0;
    }


}
