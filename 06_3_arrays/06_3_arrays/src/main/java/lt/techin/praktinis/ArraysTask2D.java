package lt.techin.praktinis;

public class ArraysTask2D {

    public static void main(String[] args) {

        // (Papildomai) Įgyvendikite visus metodus (turi pažaliuoti unit testai).
        //  Pateiktas dvimatis masyvas programos patikrinimui. Elementų reikšmes galite keisti.

        int[][] marks = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        double averageMark = getAverageMark(marks);
        System.out.printf("Average mark: %f\n", averageMark);
        int minMark = getMinMark(marks);
        System.out.printf("Min mark: %d\n", minMark);
        int maxMark = getMaxMark(marks);
        System.out.printf("Max mark: %d\n", maxMark);
    }


    public static double getAverageMark(int[][] marks) {
        int sum = 0;
        int count = 0;
        for (int[] mark : marks) {
            for (int i : mark) {
                sum += i;
                count++;
            }
        }
        return (double) sum /count;
    }

    /*
        public static double getAverageMark(int[][] marks) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            for (int j = 0; j < marks[i].length; j++) {
                sum += marks[i][j];
                count++;
            }
        }
        return (double) sum /count;
    }

     */


    public static int getMinMark(int[][] marks) {
        int min = Integer.MAX_VALUE;
        for (int[] mark : marks) {
            for (int i : mark) {
                if (min>i) min=i;
            }
        }
        return min;
    }


    public static int getMaxMark(int[][] marks) {
        int max = Integer.MIN_VALUE;
        for (int[] mark : marks) {
            for (int i : mark) {
                if (max<i) max=i;
            }
        }
        return max;
    }



}
